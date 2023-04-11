package com.canvarli.oopkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("------Classes (Sınıflar)------")

        val kullanici = Kullanici("Atıl",70)
        val digerKullanici = Kullanici("Samancıoğlu",50)


        println("------Encapsulation (Kapsülleme) ------")

        val ahmet = Sanatci("Ahmet",50,"Muzisyen")
        println(ahmet.isim)
        //ahmet.isim = "Ahmet2"
        println(ahmet.isim)

        println("------Inheritance------")

        //OzelSanatci sınıfı Sanatci sınıfından kalıtım alıyor.
        val mehmet = OzelSanatci("Mehmet",40,"Tiyatrocu")
        mehmet.sarkiSoyle()


        println("------Polymorphism (Çok biçimlilik)------")

        //Statik Polymorphism: Yani direk aynı isimli bir fonksiyona
        // farklı sayıda paramtereler göndererek farklı sonuç elde etmeye yarar.

        val islem = Islemler()
        println(islem.carpma())
        println(islem.carpma(2,3))
        println(islem.carpma(2,3,4))

        //Dinamik Polymorphism: Kalıtım alan sınıfların kalıtım aldıkları fonksiyonu
        //direk aynı isim ve belki paramtre sayısı ile özelliğini yani içeriğini değiştirmesi
        //olayıdır. Aşşağıda ki örnekte hayvan sınıfında sesCikar işlemi var biz bu işlemi
        //kedi ve köpek sınıflarına göre farklı işlemler yapabilecekleri gibi değiştirebiliyoruz

        val kedi = Hayvan()
        kedi.sesCikar()

        val barley = Kopek()
        barley.sesCikar()
        barley.kopekFonksiyonu()

        println("------Abstraction(Soyutlama) & Interface (Arayüz)------")

        //Soyut sınıfdan nesne oluşturulamaz. Başka sınıflara özellik aktarımı için önemli
        //Aynı özelliği diğer sınıflara nesne oluşturmadan kalıtım verebiliyor.
        //Interface (arayüz) bir sınıf sadece 1 kere kalıtım alabilir ancak ınterface ile
        //bir sınıfa birden çok kalıtım verebiliyoruz.
        // Bu örnekte gitar hem bir ensturumandır hemde bir ev eşyası oda dekorudur.
        //Bu iki sınıfın özelliklerinide alabilmesi için Bu enstruman ve dekorasyon sınıflarının
        //interface sınıflar olması gerekiyor.

        kullanici.insanFonksiyonu()
        var gitar = Gitar()
        gitar.marka = "Gitar Markası"
        gitar.elektro = true
        gitar.bilgi()
        println(gitar.oda)

    }
}