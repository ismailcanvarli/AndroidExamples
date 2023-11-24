package com.canvarli.kullaniciadisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Burada tanımlıyoruz ki diğer fonksiyonlarda da kullanalım.
    //lateinit sonradan o nesneyi tanımlayacağız demek.
    lateinit var sharedPreferences : SharedPreferences
    //bu da kaydedilen kullanıcı adını shared prefences'dan almak için kullandık
    //bunun null olabileceğini söyledik. Sonuçta veri boş olabilir.
    var alinanKullaniciAdi : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //oluşturulurken paket ismimiz ne ise onla oluşturulur karışıklık olmasın diye.
        //mode_private ise sadece bizim kullandığımız uygulama görsün diye yazılır.
        sharedPreferences = this.getSharedPreferences("com.canvarli.kullaniciadisaklama",
            Context.MODE_PRIVATE)
        //yazdığımız anahtar veriyi vermek istiyor.
        //virgülden sonraki kısım ise öyle bir şey yoksa ne yapayım diyor. boş bıraktık biz.
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")

        if (alinanKullaniciAdi != null) {
            textView.text = "Kaydedilen Kullanıcı Adı: ${alinanKullaniciAdi}"
        }
    }

    fun kaydet(view: View) {
        val kullaniciAdi = editText.text.toString()
        //kullanıcı hiç bir şey yazmazsa toast mesajı bastırıyoruz.
        if (kullaniciAdi == ""){
            Toast.makeText(this,"Lütfen Bir Değer Giriniz!",Toast.LENGTH_LONG).show()
        } else {
            //shared preferences'den değer almayıp değer değiştiriceksek edit dedik.
            sharedPreferences.edit().putString("kullanici",kullaniciAdi).apply()
            //bir text view ile kaydettiğimiz kullanıcı adını yazdırıyoruz.
            textView.text = "Kaydedilen Kullanıcı Adı: ${kullaniciAdi}"
        }
    }

    //shared preferences'de kaydedilen veriyi silme işlemi yapacağız.
    fun sil(view: View){
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if (alinanKullaniciAdi != null) {
            textView.text = "Kaydedilen Kullanıcı Adı: "
            //değişiklik yapacağımız için edit dedik.
            // sonra kaldırdık en son apply yani kaydet dedik.
            sharedPreferences.edit().remove("kullanici").apply()
        }
    }
}