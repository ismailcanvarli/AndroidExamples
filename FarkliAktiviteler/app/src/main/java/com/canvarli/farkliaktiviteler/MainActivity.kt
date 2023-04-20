package com.canvarli.farkliaktiviteler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun aktiviteDegistir(view : View){
        //Bu intent şuraya git anlamına geliyor.

        val kullaniciVerisi = editText.text.toString()

        //Application context kısmına sonra değineceğiz.
        //, deyip gitmek istedğimiz sınıfın adını yazıyoruz.
        //sınıfın adını yazarkende böyle yazıyoruz.
        //Hangi sınıfa gideceğimizi veriyoruz hangi context'ten çalışacağımızı veriyoruz.
        val intent = Intent(applicationContext,IkinciActivity::class.java)

        //kullanıcıdan aldığımız veriyi intent ile putExtra fonksiyonu ile
        // diğer aktiviteye gönderebiliyoruz.

        intent.putExtra("yollananVeri",kullaniciVerisi)
        startActivity(intent)

    }

}