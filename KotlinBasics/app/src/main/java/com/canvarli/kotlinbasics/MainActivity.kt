package com.canvarli.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Merhaba kotlin")


        //Değişkenler & Sabitler

        println("-------------- Int --------------------")
        //INTEGER
        var yas = 50
        println("Sonuç: " + yas / 5 * 10)

        //sabit böyle tanımlanır.
        val c = 10

        //değer tanımlama ve değer atama.
        val sayi1 : Int
        sayi1 = 7
        println(sayi1)


        println("----------------------- Long ------------------------")
        //Long: çok uzun sayılar
        var longSayi : Long = 30000000000000
        longSayi = 5000000000000
        println(longSayi)


        println("----------------------- Double & Float ------------------------")
        //Double: ondalıklı sayılar için kullanılır.
        val pi = 3.14
        println(pi*2)


        println("----------------------- String ------------------------")
        //String: metinler
        val benimSting = "Benim oluşturduğum string"
        println("Benim string uzunluğu: "+benimSting.length)

        println("----------------------- Boolean ------------------------")
        //boolean: ya doğru olur ya yanlış ya 1 ya 0
        var benimBoolean = true
        benimBoolean = false
        println(benimBoolean)


        println("----------------------- Veri Tipi Dönüştürme ------------------------")
        //Veri tipi Dönüştürme
        var myInt = 10
        var longConversion = myInt.toLong()
        println(longConversion)
        //toLong, toByte, toString, toInt,,,

        //---------------------------------------------------------------

        //Collections (Kolleksiyonlar)
        //element, nulls, list, byte, boolen, char, double, float, int ,long

        println("----------------------- Koleksiyonlar ------------------------")
        println("----------------------- Diziler ------------------------")
        //Array dizi

        val stringExample = "İsmail"
        val myArray = arrayOf(stringExample,"Can","Varlı")

        println(myArray[0])
        myArray[2] = "VARLI"
        println(myArray.get(2))
        myArray.set(1,"CAN")
        println(myArray.get(1))

        val numberSeries = doubleArrayOf(1.2,1.8,1.19)
        println(numberSeries.get(2))


        println("----------------------- Diziler ------------------------")
        //ArrayList: listeler daha esnek. Array liste üst sınır yok.
        //Ya değer yazıcaz ya ya tipini belirteceğiz

        val myArrayList = arrayListOf("İsmail", "zeynep", 5)
        myArrayList.add("hasan")
        println(myArrayList.get(3))

        //any(herhangi bir): dediğimizde istediğimiz veri türünü yazabiliriz
        val randomArrayList = arrayListOf<Any>()
        randomArrayList.add(3)
        randomArrayList.add("halim")


        println("----------------------- Set ------------------------")
        //Set aynı veri tipinden 1 tane olur.
        // Mesela 5 sayısı 1 kere olur. Diziye yazılabilir ancak 1 tane alır.

        val exampleArray = arrayOf(5,5,5,10,10,7)
        val mySet = setOf<Int>(3,5,5,5,7,8,8)
        println("Set dizisinin boyutu: " + mySet.size)


        println("----------------------- HashMap ------------------------")
        //değer ve anahtar kelime eşleşmesi var.Dictionary (key,value)

        //key, value olacak. Anahtar ismini yaptık değeri kalori yaptık
        val foodCaloryMap = hashMapOf<String,Int>("Tavuk" to 350)
        //yukarıda ki "to" put'a eş değer aynıdır.
        foodCaloryMap.put("Elma",100)
        foodCaloryMap.put("Et",500)

        println(foodCaloryMap.get("Et"))


        //Matematiksel İşlemler
        println("----------Matematiksel İşlemler---------")

        var sayi = 8
        println(sayi)
        sayi = sayi + 1
        println(sayi)
        sayi++
        println(sayi)
        sayi--
        println(sayi)

        var digerSayi = 10

        println(digerSayi > sayi)

        println(digerSayi > sayi && 2 > 3)  //VE
        println(digerSayi > sayi || 2 > 3)  //VEYA

        println(8+7)
        println(10-4)
        println(20*5)
        println(10/2)

        //Remainder - Kalanı Bulmak
        println(11%3)

        //If Kontrolleri
        println("----------If Statements (Eğer Kontrolleri)---------")

        val skor = 80

        if (skor < 10) {
            println("Oyunu kaybettin!")
        } else if (skor >= 10 && skor < 20) {
            println("Skorun 10 ve 20 arasında, çok iyi skor aldın")
        } else if (skor >= 20 && skor < 30) {
            println("Skorun 20 ve 30 arasında, rekorlar kırıyorsun")
        } else {
            println("Skorun 30'un üstünde, efsane oynadın")
        }

        //When - Switch case oluyor java da
        println("----------When---------")

        var notRakami = 2
        var notStringi = ""


        when(notRakami) {
            0 -> notStringi = "Geçersiz Not"
            1 -> notStringi = "Zayıf"
            2 -> notStringi = "Kötü"
            3 -> notStringi = "Orta"
            4 -> notStringi = "İyi"
            else -> notStringi = "Pek İyi"
        }
        println(notStringi)

        /*
        if (notRakami == 0) {
            notStringi = "Geçersiz Not"
        } else if (notRakami == 1) {
            notStringi = "Zayıf"
        } else if (notRakami == 2) {
            notStringi = "Kötü"
        } else if (notRakami == 3) {
            notStringi = "Orta"
        } else if (notRakami == 4) {
            notStringi = "İyi"
        } else {
            notStringi = "Pek İyi"
        }
*/


        //Döngüler
        println("----------For Döngüsü---------")

        val baskaBirDizi = arrayOf(5,10,15,20,25,30)

        println("döngü başladı")
        for (num in baskaBirDizi) {
            println(num / 5 + 3)
        }
        println("döngü bitti")
        
        for (b in 0..9) {
            println(b)
        }

        val benimDigerStringDizim = ArrayList<String>()
        benimDigerStringDizim.add("İsmail Can")
        benimDigerStringDizim.add("VARLI")

        for (str in benimDigerStringDizim) {
            println(str)
        }

        benimDigerStringDizim.forEach {
            println(it)
        }

        //While
        println("----------While Döngüsü---------")

        var j = 0

        while (j <= 10) {
            println(j)
            j = j + 1
        }

    }


}