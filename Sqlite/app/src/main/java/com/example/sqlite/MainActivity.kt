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
            //Veri ekleme işlemi
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Shoes',100)")
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Shoes',100)")
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Tshirt',50)")
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Hat',20)")
            //database.execSQL("INSERT INTO products (name, price) VALUES ('Bot',100)")

            //burada bir imleç oluşturduk ve veritabanına kaydettiğimiz verileri alma işlemi yaptık.
            //imleç tek tek geziyor ve okuduğu verileri bize yazıyor.
            /* val cursor = database.rawQuery(
                "SELECT * FROM products " + "WHERE name = 'Hat'", null
            )*/

            //veri tabanında id'ye göre silme işlemi
            database.execSQL("DELETE FROM products WHERE id = 3")

            //Veri tabanında isme göre fiyat güncelleme işlemi
            database.execSQL("UPDATE produtcs SET price = 30 WHERE name = 'Hat'")

            val cursor = database.rawQuery(
                "SELECT * FROM products", null
            )

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