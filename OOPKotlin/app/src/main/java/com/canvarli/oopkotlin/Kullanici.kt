package com.canvarli.oopkotlin

//Soyut sınıf olduğu için "()" açmaya gerek kalmıyor.
//Insan sınıfından kalıtım aldı oradaki fonksiyonları kullanabiliyor.
class Kullanici : Insan {
    var isim: String? = null
    var yas : Int? = null

    constructor(isim: String, yas: Int){
        this.isim = isim
        this.yas = yas
        println("constructor çağırıldı")
    }

    init {
        println("init çağırıldı")
    }
}