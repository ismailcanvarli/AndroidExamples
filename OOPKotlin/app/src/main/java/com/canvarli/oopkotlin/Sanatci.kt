package com.canvarli.oopkotlin

open class Sanatci(isim: String, yas: Int, meslek: String) {

    //Encapsulation: kapsülleme (private, public)
    //bu şekilde yaptığımızda setter private oluyor getter ise public oluyor.
    var isim : String? = isim
        private set
        get

    var yas : Int? = yas
        private set
        get

    //Hiç değiştirilmesini istemiyorsak böyle yaparız.
    private var meslek : String? = meslek
}