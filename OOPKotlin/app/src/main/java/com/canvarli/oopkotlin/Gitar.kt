package com.canvarli.oopkotlin

//Abstract ve interface kısmı için oluşturuldu
//Gıtar sınıfı hem enstruman hem dekorasyon sınıfndan kalıtım alıyor
//bu sınıflar interface olduğu için her ikisi sınıftanda kalıtım alabiliyor
class Gitar : Enstruman, Dekorasyon {

    var marka : String? = null
    var elektro : Boolean? = null

    override var oda: String
        get() = "Salon"
        set(value) {}
}