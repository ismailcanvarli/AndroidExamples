package com.canvarli.oopkotlin

//Inheritance(Kalıtım): Üst sınıfa super class denir.
//Bu sınıf "Sanatci" sınıfından kalıtım alıyor.
//kalıtım alınılan sınıfın tüm fonk. ve diğer özelliklerine sahip olur.
//Ekstradan kendisini bu sınıfta bu sınıfa özel fonksiyon tanımlayabilir.
//Bir sınıfın kalıtım alabilmesi için üst sınıfın class'ının başında open yazması gerekiyor
//örnek  open class Sanatci(...) şeklinde olması gerekiyor.

class OzelSanatci(isim: String, yas: Int, meslek: String) : Sanatci(isim, yas, meslek) {

    fun sarkiSoyle(){
        println("şarkı söyleniyor")
    }
}