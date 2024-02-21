package com.example.fragmentkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentkotlin.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

    }

    //fragman geçişleri için buton fonksiyonu oluşturduk.
    fun firstFragment(view: View) {
        //fragmana erişebilmek için fragment manager'ı kullanmak zorundayız.
        val fragmentManager = supportFragmentManager
        //işlem yapmaya başlatıyoruz. Değişiklik yapmaya.
        val fragmentTransaction = fragmentManager.beginTransaction()
        //fragment'e ilk fragmentimizi atıyoruz.
        val firstFragment = BlankFragment()
        //değişim işlemini başlatıyoruz. Nerede göstereceğimizi ve
        // hangisini göstereceğimizi yazıyoruz. Sonra commit ediyoruz.
        fragmentTransaction.replace(R.id.frameLayout, firstFragment).commit()
    }

    fun secondFragment(view: View) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment = BlankFragment()
        fragmentTransaction.replace(R.id.frameLayout, secondFragment).commit()
    }
}
