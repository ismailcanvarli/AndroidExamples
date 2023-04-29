package com.canvarli.superkahramankitabi

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tanitim.*

class TanitimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanitim)

        //Buraya bir intent ile geliniyor. Gelinen intet'i alıyor.
        val intent = intent
        //Seçilen süperkahramana göre ismi resmin altında yazdırdıyor.
        val secilenKahramanIsmi = intent.getStringExtra("superKahramanIsmi")
        textView.text = secilenKahramanIsmi

        //Seçilen kahramanın görseli için id oluşturduk ve bu id'yi vereceğiz.
        val secilenKahramanGorseli = intent.getIntExtra("superKahramanGorseli",0)
        //bitmap oluşturduk.
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,secilenKahramanGorseli)
        imageView.setImageBitmap(bitmap)
        /* // bu işlem verimsizdir.
        val secilenKahraman = SingletonClass.SecilenKahraman
        val secilenGorsel = secilenKahraman.gorsel
        imageView.setImageBitmap(secilenGorsel)
        */

    }
}