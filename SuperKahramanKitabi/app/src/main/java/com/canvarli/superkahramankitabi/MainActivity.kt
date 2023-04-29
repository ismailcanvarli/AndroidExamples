package com.canvarli.superkahramankitabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Veri Hazırlığı
        //Array list içinde yapıyoruz eklemesi ve çıkarması daha kolay
        //Sınırlar belli değilse array list kullanılır.

        var superKahramanIsimleri = ArrayList<String>()
        superKahramanIsimleri.add("Batman")
        superKahramanIsimleri.add("Superman")
        superKahramanIsimleri.add("Iron Man")
        superKahramanIsimleri.add("Aquaman")
        superKahramanIsimleri.add("Spiderman")

        //Bitmap: Görselleri bir değişken olarak tanımlamaya yarar.
        // Verimsiz bitmap tanımlama yöntemi: Görsel aktarımı mantıksız olur.
        //Singelton(Tekillik) yöntemi
        //Bir sınıf oluşturucaz bu sınıf sadece istediğimiz bitmap'i bize verecek.
        //Bitmap factory ile farklı kaynaklardan gelen şeyleri değişken haline getirebiliyoruz.
        //ilk değişken bitmap'e dönüştürülecek şeyin nerede olduğunu bize soruyor.
        //2. ise id'yi soruyor. Biz applicationContext diyoruz çünkü bu uygulamadan çekeceğiz verileri

        /*
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.batman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.superman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ironman)
        val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.aquaman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.spiderman)

        //Burada oluşturulan bitmap'lar diziye eklendi.
        var superKahramanGorselleri = ArrayList<Bitmap>()
        superKahramanGorselleri.add(batmanBitmap)
        superKahramanGorselleri.add(supermanBitmap)
        superKahramanGorselleri.add(ironmanBitmap)
        superKahramanGorselleri.add(aquamanBitmap)
        superKahramanGorselleri.add(spidermanBitmap)
         */

        //Verimli bitmap tanımlama yöntemi: Görselin bulunduğu yeri kaydedeceğiz.
        //Görsel istendiğinde drawble kısmındaki yerini veriyoruz.
        //Bu bir int tanımlıyor ve görsel istendiğinde bir int veriyor bize bizde id'yi veriyoruz.

        val batmanDrawableId = R.drawable.batman
        val supermanDrawableId = R.drawable.superman
        val ironmanDrawableId = R.drawable.ironman
        val aquamanDrawableId = R.drawable.aquaman
        val spidermanDrawableId = R.drawable.spiderman

        var superKahramanDrawableListesi = ArrayList<Int>()
        superKahramanDrawableListesi.add(batmanDrawableId)
        superKahramanDrawableListesi.add(supermanDrawableId)
        superKahramanDrawableListesi.add(ironmanDrawableId)
        superKahramanDrawableListesi.add(aquamanDrawableId)
        superKahramanDrawableListesi.add(spidermanDrawableId)


        //Adapter: Bu itemlerin nasıl gösterileceğini yapıyoruz.
        //Genelde alt alta koyulur onun yüzünden linear layout kullandık.
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        //Süper kahraman isimlerini ve görsellerini recycler adapter sınfına verdik.
        val adapter = RecyclerAdapter(superKahramanIsimleri,superKahramanDrawableListesi)
        recyclerView.adapter = adapter


    }
}