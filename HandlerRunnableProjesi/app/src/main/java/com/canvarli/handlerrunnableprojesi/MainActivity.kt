package com.canvarli.handlerrunnableprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var numara = 0
    //bunları sınıf içinde her yerde erişebilmek için buraya koyduk.
    var runnable : Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //başlata butonuna basıldığında 0'dan başlayarak artarak gidecek.

    fun baslat(view: View){
        numara = 0

        //abstract class
        runnable = object : Runnable{
            //bu fonksiyon oluşturmak zorundayız.
            override fun run() {
                numara = numara + 1
                textView.text = "Sayaç: ${numara}"
                //kaç saniye rötarlı beklemeli çalıştıracağımızı yazdık.
                handler.postDelayed(runnable,1000)
            }
        }
        handler.post(runnable) // runnable'ı çalıştır dedik
    }

    fun durdur(view: View){

        handler.removeCallbacks(runnable) //runnable'ı kaldır dedik yani durdurduk.
        numara = 0
        textView.text = "Sayaç: 0"
    }
}