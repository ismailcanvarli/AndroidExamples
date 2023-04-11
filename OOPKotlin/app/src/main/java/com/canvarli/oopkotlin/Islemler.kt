package com.canvarli.oopkotlin

//bu sınıf polymorphism örneği için oluşturuldu.
//Aynı fonksiyonu aynı isimde ama farklı parametre de çağırabiliyoruz.
//Bu işleme "Static polymorphism" deniliyor
class Islemler {

    fun carpma() : Int {
        return 0
    }

    fun carpma(a: Int, b: Int) : Int {
        return a * b
    }

    fun carpma(a: Int, b: Int, c: Int) : Int {
        return a * b * c
    }
}