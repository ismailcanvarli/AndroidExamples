package com.canvarli.siniflarvefonksiyonlar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var j = -10

        if (j == 0) {
            ilkFonksiyon()
        } else {
            ikinciFonksiyon()
        }

        cikarma(500,20)
        var x = toplama(10,20)
        textView.text = "Sonuç : ${x}"
/*
        button.setOnClickListener {
            val toplamaSonucu = toplama(10,50)
            textView.text = "Sonuç: ${toplamaSonucu}"
        }
*/
        sinifCalismasi()
        nullGuvenligi()

    }

    fun sinifCalismasi(){

        var superman = Superkahraman("Superman",50,"Gazeteci")
        textView.text = "Yaş: ${superman.yas}"
        superman.testFonksiyonu()
        println(superman.sacRenginiAl())
    }

//boş (değer atamama) koruması
    fun nullGuvenligi(){
        //Null, Nullability, Null Safety

        //Tanımlama, Definening
        //bir değişkeni tanımlarken yada atama yaparken değişkenin türünü yanına soru işareti
        //koyarsak bu şu anlama gelir işte bu String? string'de olabilir null da olabilir
        var benimString : String?

        //Initialization Değer atanmması
        benimString = "Atıl"

        var benimYasim : Int? = null
        println(benimYasim)

        //benimYasim = 2

        //1. yöntem genelde bunu kullan.
        if (benimYasim != null){
            println(benimYasim * 2)
        } else {
            println("null geldi")
        }

        //2. yöntem: çok tavsiye edilmez
        // !! -> null olmayacak ben garanti veriyorum demek
        //  ? -> null olabilir garanti vermiyorum.
        println(benimYasim?.minus(2))

        //3. yöntem
        //elvis operatörü ?: Eğer sonuç null geliyorsa default değer atama işlemini yapıyor
        //eğer null gelmezse zaten direk değerin kendisini alıyor.

        //benimYasim = 10
        val sonuc = benimYasim?.minus(2) ?: 10
        println(sonuc)

        //4. yöntem
        //let
        //benimYasim = 5
        benimYasim?.let {
            println(it * 5)
        }

    }

    fun ilkFonksiyon() {
        println("ilk fonksiyon çalıştırıldı")
    }

    fun ikinciFonksiyon() {
        println("ikinci fonksiyon çalıştırıldı")
    }

    //Girdi Almak

    fun cikarma(x: Int, y:Int){
        textView.text = "Sonuç: ${x-y}"
    }

    //Çıktı Vermek -> Döndürmek (Return)

    fun toplama(a: Int, b:Int) : Int {
        return a + b
    }


    fun degistir(view : View){
        val toplamaSonucu = toplama(10,50)
        textView.text = "Sonuç: ${toplamaSonucu}"
    }




}