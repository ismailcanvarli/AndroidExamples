package com.example.sqlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
            val database = this.openOrCreateDatabase("Products", MODE_PRIVATE, null)
            //sorguyu çalıştır diyoruz. Eğer yoksa oluştur dedik. Tablo ismini verdik.
            database.execSQL(
                "CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, " + "name VARCHAR, price INT)"
            )
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Shoes',100)")

            //burada bir imleç oluşturduk ve veritabanına kaydettiğimiz verileri alma işlemi yaptık.
            //imleç tek tek geziyor ve okuduğu verileri bize yazıyor.
            val cursor = database.rawQuery("SELECT * FROM products", null)

            //burada da oluşturduğumuz kolonlar için kolon index kısmı oluşturduk.
            val idColumnIndex = cursor.getColumnIndex("id")
            val nameColumnIndex = cursor.getColumnIndex("name")
            val priceColumnIndex = cursor.getColumnIndex("price")

            while (cursor.moveToNext()) {
                println("Id: ${cursor.getBlob(idColumnIndex)}")
                println("Name: ${cursor.getString(nameColumnIndex)}")
                println("Price: ${cursor.getInt(priceColumnIndex)}")
            }

            cursor.close()
        } catch (e: Exception) {
            e.printStackTrace()  //bu hatanın log kaydını yazdırıyor.
        }
    }
}