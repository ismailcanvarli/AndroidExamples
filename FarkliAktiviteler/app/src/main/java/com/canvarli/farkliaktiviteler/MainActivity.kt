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

        println("onCreate çağırıldı")

    }
    override fun onStart() {
        super.onStart()

        println("onStart çağırıldı")

    }

    override fun onResume() {
        super.onResume()

        println("onResume çağırıldı")

    }

    override fun onPause() {
        super.onPause()

        println("onPause çağırıldı")

    }

    override fun onStop() {
        super.onStop()

        println("onStop çağırıldı")

    }

    override fun onDestroy() {
        super.onDestroy()

        println("onDestroy çağırıldı")

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
        finish()

    }

}