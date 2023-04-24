package com.canvarli.contextprojesi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast, Alert

        //applicationContext -> app context
        //activityContext
        //this, this@MainActivity -> aktivitenin contexti
        //Toast kısmında sadece bu fonksiyon var.
        //Bu fonksiyonda 2 tane parametre istiyor 1. si yazılacak şey
        //2. si süresi. Ne kadar dursun.
        Toast.makeText(this,"Hoşgeldin!",Toast.LENGTH_LONG).show()

    }
    //Burada şöyle bir şey yapıyoruz işte kullanıcının şifre girmesi gereken bir yere
    //şifre girmediği farz edilip ona göre uyarı mesajı vereceğiz.
    fun mesajGoster(view: View){
        //buraya this@MainActivity yazmazsak hata verir.
        val uyariMesaji = AlertDialog.Builder(this@MainActivity)
        uyariMesaji.setTitle("Şifre Hatası")
        uyariMesaji.setMessage("Şifreyi girmediniz, yeniden denemek ister misiniz?")

        //Lambda Gösterimi ile uyarı mesajına pozitif cevap verirse olacak şeyler.
        //burada listener'lar var yani işte kullanıcı şu işlemi yaptı mı?
        //yaptıysa biz şu olsun bu olsun diyeceğiz.
        uyariMesaji.setPositiveButton("Evet", DialogInterface.OnClickListener {
                dialogInterface, i -> Toast.makeText(this,"Yeniden Deniyorsunuz",
                    Toast.LENGTH_LONG).show()
        })
        //Lambda Gösterimi ile uyarı mesajına negatif cevap verirse olacak şeyler.
        uyariMesaji.setNegativeButton("Hayır") {
                dialogInterface, i -> Toast.makeText(this,
            "Hayırı Seçtiniz, Deneyemiyorsunuz",Toast.LENGTH_LONG).show()
        }

        uyariMesaji.show()
    }
}