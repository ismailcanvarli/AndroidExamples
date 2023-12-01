package com.example.recipebooksqlite

import android.Manifest
import android.app.Activity
import android.content.Context
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
import androidx.navigation.Navigation
import java.io.ByteArrayOutputStream


class RecipeFragment : Fragment() {
    var chosenPicture: Uri? = null //Seçilen görselin adresini tutucaz.
    var chosenBitmap: Bitmap? = null //görseli dönüştürmek için

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Fragmentlarda eğerki butona bir fonksiyon atıyorsak bunu setOnClick listener ile yapmalıyız
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val saveButton = view.findViewById<Button>(R.id.save_button)
        val imageView = view.findViewById<ImageView>(R.id.image_view)

        saveButton.setOnClickListener {
            savePicture(it)
        }
        imageView.setOnClickListener {
            choosePicture(it)
        }
    }

    //kaydetme işleminden önce bitmap'i küçültme işlemi yapacağız.
    fun savePicture(view: View) {
        //sql kaydetme
        val recipeName = R.id.recipe_name_text.toString()
        val recipeMetarial = R.id.recipe_material_text.toString()

        if(chosenBitmap != null) {
            //küçültülen bitmap
            val reducedBitmap = createSmallBitmap(chosenBitmap!!,300)

            //Veri dizisini array'e dönüştürürken bize yardımcı olan bir sınıf
            val outputStream = ByteArrayOutputStream()
            //bitmap'i küçültüyoruz. Png formatında saklıyoruz.
            reducedBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val byteArray = outputStream.toByteArray()

            try {
                context?.let {
                    val database = it.openOrCreateDatabase("Recipes",Context.MODE_PRIVATE,null)
                    database.execSQL("CREATE TABLE IF NOT EXISTS recipes " +
                            "(id INTEGER PRIMARY KEY, recipeName VARCHAR, recipeMaterials VARCHAR, picture BLOB)")

                    //Veri tabanına ekleme işlemlerini normalde bu şekilde yapıyorduk.
                    //Bu şekilde yapmayacağız daha farklı daha basit bir şekilde yapacağız.
                    //database.execSQL("INSERT INTO recipes(recipeName, recipeMaterials, pciture) VALUES() ")

                    //soru işaretlerini verileri sonradan koyacağımız ve değiştirebileceğimiz için koyduk
                    val sqlString = "INSERT INTO recipes (recipeName, recipeMaterials, picture) VALUES (?,?,?)"
                    val statement = database.compileStatement(sqlString)
                    //şimdi ise soru işaretlerini bağlama işlemi yapacağız.
                    //en sonda statement'ı execute ettik.
                    statement.bindString(1,recipeName)
                    statement.bindString(2,recipeMetarial)
                    statement.bindBlob(3,byteArray)
                    statement.execute()
                }

            } catch (e:Exception) {
                e.printStackTrace()
            }
            //En son kaydetme işlemi bittikten sonra listeye geri dönüyoruz.
            val action = RecipeFragmentDirections.actionRecipeFragmentToListFragment()
            Navigation.findNavController(view).navigate(action)
        }
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
        val imageView = view?.findViewById<ImageView>(R.id.image_view)

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

    //Bunu tüm bitmap küçültme işlemlerinde kullanabiliriz.
    //bitmap'in boyutunu küçültmek için yazacağız bu fonksiyonu
    fun createSmallBitmap(chosenBitmap: Bitmap, maximumSize: Int) : Bitmap {
        //bu uzunluk ve genişlik değerlerininin oranını koruyarak işlem yapacağız
        var width = chosenBitmap.width
        var height = chosenBitmap.height
        //bitmap'in oranını aldık.
        val bitmapRate : Double = width.toDouble() / height.toDouble()

        //görüntünün yatay mı dikey mi olduğunu tespit edeceğiz.
        if(bitmapRate > 1) {
            //Görselimiz yatayken
            width = maximumSize
            val shortenedHeight = width / bitmapRate //kısaltılmış yüksekliği bulucaz
            height = shortenedHeight.toInt()

        } else if(bitmapRate < 1) {
            //görselimiz dikeyken.
            height = maximumSize
            val shortenedWidth = height * bitmapRate
            width = shortenedWidth.toInt()
        }
    return Bitmap.createScaledBitmap(chosenBitmap, width, height,true)
    }
}



