package com.canvarli.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*


class RecyclerAdapter(val kahramanListesi : ArrayList<String>,
                      val kahramanGorselleri : ArrayList<Int>) :
                        RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>() {
    // bu sınıf bir viewHolder(görünüm tutucu) sınıfıdır. Görünüm dediğimiz bu sınıftan oluşturulan
    //nesne ile olacak.
    class SuperKahramanVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
// Alt taraftaki 3 fonksiyon recycler adapter sınıfının gerekli duyduğu fonksiyonlardır.

    // Buradaki itemrow recycler view ile görünümümüzü birbirimize bağlamamıza yarar.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanVH {
        //Inflater, LayoutInflater, MenuInflater
        //Inflater: Xml dosyası ile bir sınıfı birbirine bağlayacağımız zaman bunu kullanırız.
        //Hangi context'de kullanacaksak o context'i veriyoruz.
        //2. değişken ise hangi kaynağa bağlayacaksak onu yazıyoruz.
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row
            ,parent,false)
        return SuperKahramanVH(itemView)
    }
    //Bu recyler sınıfının içinde kaç tane satır olacak onu sayıyor ve ona göre işlem yapıyor.
    //dinamik olması için direk listenin boyutunu veriyoruz.
    override fun getItemCount(): Int {
        return kahramanListesi.size
    }

    //View holder sınıfı oluşturulduğu zaman yapılacak işlemler burada yazılıyor.
    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {

        //Burada position dememizin sebebi oluşturduğumuz recycler view ve listelerin
        //birlikte çalıştırır. Bulundukları indexlere göre çalışır.
        // Dizide 1. indexte ise 1. indextekini verir.
        holder.itemView.recyclerViewTextView.text = kahramanListesi.get(position)

        //Recycler view'da listelenmiş süper kahraman isimlerine tıklandığında
        // gerekli aktivite penceresine gidip ilgili görseli açtırıyoruz.
        holder.itemView.setOnClickListener {
            //intent de context ister. Biz context'i tıklanan item'ın context'ini vericaz.
            //Bir de hangi sınıfa gideceğimizi belirtiyoruz.
            val intent = Intent(holder.itemView.context,TanitimActivity::class.java)
            intent.putExtra("superKahramanIsmi",kahramanListesi.get(position))
            intent.putExtra("superKahramanGorseli",kahramanGorselleri.get(position))
            /*
            //Seçilen kahramanın görselini alma işlemi burada verimsiz şekilde yapıldı.
            val singleton = SingletonClass.SecilenKahraman
            singleton.gorsel = kahramanGorselleri.get(position)
             */
            //butona tıklandığında o aktiviteye gidiş için intenti veriyoruz.
            holder.itemView.context.startActivity(intent)
        }

    }

}
