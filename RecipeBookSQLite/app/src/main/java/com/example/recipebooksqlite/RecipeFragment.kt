package com.example.recipebooksqlite

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class RecipeFragment : Fragment() {
    var chosenPicture: Uri? = null //Seçilen görselin adresini tutucaz.
    var chosenBitmap: Bitmap? = null //görseli dönüştürmek için

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Fragmentlarda eğerki butona bir fonksiyon atıyorsak bunu setOnClick listener ile yapmalıyız
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val saveButton = view.findViewById<Button>(R.id.saveButton)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        saveButton.setOnClickListener {
            savePicture(it)
        }
        imageView.setOnClickListener {
            choosePicture(it)
        }
    }

    fun savePicture(view: View) {

    }

    //normalde bu kısmı main activity'de yazmamız gerekiyor.
    //Orada yazdığımızda direk checkSelfPermission dememiz yeterli.
    //Burada yaptığımız işlem ise galeriye girme izninin olup olmadığına bakmak.
    fun choosePicture(view: View) {
        // bu activity let parantezine alma sebebimiz activity'nin var mı yok mu onu bilmek.
        //böyle yaptığımızda activity varsa yapıyoruz.
        activity?.let {
            //manifest'i seçerken manifest(android) yazanı seçmemiz gerekiyor
            //manifest'Te okuma iznimiz olup olmadığını kontrol ettik.
            //PackageManager'da ise bunun izin verildiye eşit değilse yani izin verilmediyse
            if (ContextCompat.checkSelfPermission(
                    it.applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //izin verilmedi izin istenmesi gerekiyor.
                //buradaki 1 sayısı bizim izin için belirlediğimiz kod oluyor. Biz kendimiz girdik.
                //Burada ki 1 bize lazım olacak.
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            } else {
                //izin verildi, tekrar izin istemeden galeriye git
                //Galeri için intent oluşturup oradaki bilgiyi oradan alma işlemi yapıyoruz
                //Bunuda bir action ile yapıyoruz.
                // Resim almak içinde aşağıdaki MediaStore ile ilgili kısmı yazıyoruz.
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent, 2)
            }
        }

    }

    //istenilen izinlerin sonuçlarını değerlendirdiğimiz fonksiyon
    override fun onRequestPermissionsResult(
        requestCode: Int,      //istek kodu belirlemiştik 1 ve 2 diye
        permissions: Array<out String>,  //izin çeşidi
        grantResults: IntArray       //verilen sonuçlar
    ) {

        if (requestCode == 1) {
            //izni aldığımız koşul tam olarka burası oluyor.
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent, 2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imageView = view?.findViewById<ImageView>(R.id.imageView)

        //verinin boş olup olmadığına baktık. RequestCode'un 2 olup olmadığına baktık
        //Activity'nin durumunun tamam mı olduğuna baktık. Belki olumsuz olabilir.
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            //artık seçilen görselin uri'na yani yoluna sahibiz. Bu yolu aldık.
            chosenPicture = data.data

            //görseli o konumdan alıcaz bitmap'e çevirip kaydedeceğiz.
            //Bu işlemi try catch ile yapıyoruz. Hatalarla karşılaşabiliriz.
            //Bu işlemi daha önce kullandığımız bitmap factory tarzı bir yapıyla yapıcaz.
            try {
                context?.let {
                    if (chosenPicture != null) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            //create soruce fonksiyonu api 28'den sonra çalışıyor.
                            val source =
                                ImageDecoder.createSource(it.contentResolver, chosenPicture!!)
                            chosenBitmap = ImageDecoder.decodeBitmap(source)
                            imageView?.setImageBitmap(chosenBitmap)
                        } else {
                            chosenBitmap =
                                MediaStore.Images.Media.getBitmap(it.contentResolver, chosenPicture)
                            imageView?.setImageBitmap(chosenBitmap)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}



