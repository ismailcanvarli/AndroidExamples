package com.canvarli.siniflarvefonksiyonlar

class Superkahraman(var isim:String, var yas:Int, var meslek:String) {
// (Primary Constructor): Birincil yapıcı blok.
/*
//Alttaki işlemlerde biz constructor'ı sıfırdan oluşturup this ile onu bu sınıftaki
// parametreye işaret ettiriyorduk. Ancak kotlin ile birlikte bu şekilde constructor
// oluşturabiliyoruz ve adına Primary constructor diyoruz.
    //Property
    var isim = ""
    var yas = 0
    var meslek = ""
    //Constructor
    constructor(isim: String, yas: Int, meslek: String){
        this.isim = isim
        this.yas = yas
        this.meslek = meslek
        println("constructor çağırıldı")
    }
     */

// Access Levels - Erişebilirlik Seviyeleri
// private - protected - internal - public
    private var sacininRengi = "Sarı"

    fun testFonksiyonu(){
        println("test")
    }

    //Getter
    fun sacRenginiAl() : String{
        return this.sacininRengi
    }

    //Setter
    /*
    fun sacRenginiDegistir() {
        this.sacininRengi = "Yeşil"
    }
     */



}