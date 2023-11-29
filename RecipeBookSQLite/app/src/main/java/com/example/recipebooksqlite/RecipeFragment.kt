package com.example.recipebooksqlite

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class RecipeFragment : Fragment() {

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
                    it.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE
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

}



