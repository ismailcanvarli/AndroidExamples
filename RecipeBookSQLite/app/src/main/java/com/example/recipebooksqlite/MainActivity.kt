package com.example.recipebooksqlite

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Burada menüyü bağlama işlemi yapacağız.
    //bağlama işlemi için infilater kullanıcaz
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.recipe_add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //burada menüden item seçilirse ne yapılacak ona bakacağız.
    //birden fazla item olabilir. Biz hangisinin seçildiğini kontrol etmeliyiz.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.recipe_add_menu_item) {
            // Action ID'sini belirleyin (Navigation Graph'ta oluşturduğunuz action'ın ID'si)
            val action = ListFragmentDirections.actionListFragmentToRecipeFragment()

            // NavController üzerinden action'ı çağırın
            Navigation.findNavController(this, R.id.fragment_container_view).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }

}
