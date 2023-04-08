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