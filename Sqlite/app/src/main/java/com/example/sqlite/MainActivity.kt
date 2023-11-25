package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //try catch yapısı
        //Try'da denemek istediğin şeyleri yaz
        //catch'de ise hata yakalanırsa ne yapılacağını yaz
        try {
            //yeni bir veritabanı oluşturucaz. Var ise onu açacağız.
            //veri tabanı ismi, kim tarafından kullanılacağı ve factory diye bir değer var
            val database = this.openOrCreateDatabase("Products", MODE_PRIVATE,null)
            //sorguyu çalıştır diyoruz. Eğer yoksa oluştur dedik. Tablo ismini verdik.
            database.execSQL("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, " +
                    "name VARCHAR, price INT)")
        } catch (e : Exception) {
            e.printStackTrace()  //bu hatanın log kaydını yazdırıyor.
        }
    }
}