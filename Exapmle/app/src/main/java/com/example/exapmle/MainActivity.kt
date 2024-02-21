package com.example.exapmle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myArray = arrayListOf<String>("asd","ismail")
        myArray.add("hasan")
        println(myArray.size)
        println("hello")

        for (ban in myArray) {
            println(ban)
        }
        run()
    }

    fun run () : Int {
        println(5+7)
        return 12
    }

    fun buttonBas (view: View) {
        println("butona basıldı.")
    }

}