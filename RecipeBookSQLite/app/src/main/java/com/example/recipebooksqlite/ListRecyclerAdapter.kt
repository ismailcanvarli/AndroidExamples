package com.example.recipebooksqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebooksqlite.R.id.recycler_view

class ListRecyclerAdapter(val recipeList: ArrayList<String>, val idList: ArrayList<Int>) :
    RecyclerView.Adapter<ListRecyclerAdapter.RecipeHolder>() {

    class RecipeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row, parent, false)

        return RecipeHolder(view)
    }

    //Kaç tane recycler satırı oluşturduğumuzu söyleyecek.
    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.itemView.findViewById<TextView>(recycler_view).text = recipeList[position]
        holder.itemView.setOnClickListener(){
            //recycler viewdan gidersem bilgi olarak bize onu söyleyecek
            //ve id listesinde nereden geldiğini söylecek.
            //bu boolen şeklinde felanda gönderilebilir. Biz bu basit diye bunu yaptık
            val action = ListFragmentDirections.actionListFragmentToRecipeFragment("recyclerdangeldim",idList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

}