package com.canvarli.oopkotlin

//bu sınıf polymorphism örneği için oluşturuldu.
//hayvan sınıfından türetilmiştir yani kalıtım almıştır.

class Kopek : Hayvan() {
    fun kopekFonksiyonu(){
        //super üst sınıfı belirtiyor. Üst sınıfın fonk. kullandık
        super.sesCikar()
    }

    //sesCikar fonksiyonunu override etmiştir çünkü aynı
    // fonksiyonu farklı bir işlemi yapmak için kullandık.
    // Her şey aynı ancak içerik farklı
    override fun sesCikar(){
        println("köpek sınıfı")
    }

}