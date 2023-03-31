package com.canvarli.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Merhaba kotlin")

        //Değişkenler & Sabitler

        println("-------------- Int --------------------")
        //INTEGER
        var yas = 50
        println("Sonuç: " + yas / 5 * 10)

        //sabit böyle tanımlanır.
        val c = 10

        //değer tanımlama ve değer atama.
        val sayi : Int
        sayi = 7
        println(sayi)

        println("----------------------- Long ------------------------")
        //Long: çok uzun sayılar
        var longSayi : Long = 30000000000000
        longSayi = 5000000000000
        println(longSayi)

        println("----------------------- Double & Float ------------------------")
        //Double: ondalıklı sayılar için kullanılır.
        val pi = 3.14
        println(pi*2)

        println("----------------------- String ------------------------")
        //String: metinler
        val benimSting = "Benim oluşturduğum string"
        println("Benim string uzunluğu: "+benimSting.length)

        println("----------------------- Boolean ------------------------")
        //boolean: ya doğru olur ya yanlış ya 1 ya 0
        var benimBoolean = true
        benimBoolean = false
        println(benimBoolean)

    }
}