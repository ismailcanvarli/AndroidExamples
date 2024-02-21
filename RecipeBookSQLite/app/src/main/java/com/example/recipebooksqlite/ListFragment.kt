package com.example.recipebooksqlite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    //Veri tabanından çekilen id'yi recycler view'da göstermek için yapıyoruz.
    var recipeNameList = ArrayList<String>()
    var recipeIdList = ArrayList<Int>()
    private lateinit var listAdapter : ListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        listAdapter = ListRecyclerAdapter(recipeNameList,recipeIdList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter

        gettingDataSql()
    }

    //SQL'den veri almak için kullanacağımız fonksiyon
    fun gettingDataSql() {
        try{
            activity?.let {
                val database = it.openOrCreateDatabase("Recipes", Context.MODE_PRIVATE, null)
                val cursor = database.rawQuery("SELECT * FROM recipes", null)
                val recipeNameIndex = cursor.getColumnIndex("recipeName")
                val recipeIdIndex = cursor.getColumnIndex("id")

                //Program her başladığında bu listeyi temizleyeceğiz
                //Recycler view'a yazdırmak için yapıyoruz zaten bunu
                recipeNameList.clear()
                recipeIdList.clear()

                while (cursor.moveToNext()) {
                    recipeNameList.add(cursor.getString(recipeNameIndex))
                    recipeIdList.add(cursor.getInt(recipeIdIndex))
                }
                //Veriler değiştiğinde recycler view değişecek güncelleme yapıyor.
                listAdapter.notifyDataSetChanged()
                cursor.close()
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

}

