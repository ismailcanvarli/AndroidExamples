package com.canvarli.sayacprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Abstract Class (soyut sınıf)
        //soyut sınıftan nesne oluşturulamaz. Direk uygulanır.
        //Abstract classlarda o sınıfta bulunan fonksiyonları kullanmak zorundayız.
        //bu countDownTimer hazır bir fonksiyon ve zaten bu işlemi yapıyor.
        object : CountDownTimer(15000,1000){

            //sayaç bittiğinde ne yapsın diyor
            override fun onFinish() {
                textView.text = "Kalan: 0"
            }

            //her bir tik attığında ne yapılsın diyor. p0 kalan milisaniyedir.
            override fun onTick(p0: Long) {
                textView.text = "Kalan: ${p0 / 1000}"
            }
        }.start() // start'ı yazmazsak çalışmaz.
    }
}