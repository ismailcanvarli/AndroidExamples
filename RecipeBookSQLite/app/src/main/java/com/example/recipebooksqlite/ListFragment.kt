package com.example.recipebooksqlite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    //Veri tabanından çekilen id'yi recycler view'da göstermek için yapıyoruz.
    var recipeNameList = ArrayList<String>()
    var recipeIdList = ArrayList<Int>()

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
            }

        } catch (e:Exception) {
            e.printStackTrace()
        }

    }

}

