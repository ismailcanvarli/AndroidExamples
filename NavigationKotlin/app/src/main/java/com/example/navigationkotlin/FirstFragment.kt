package com.example.navigationkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    //Bu işlemi yukarıdaki fonksiyonlarda değilde burada yapmamızın nedeni şu:
    //biz genelde fragment'leri kullanırken daha view'lar oluşturulmamış oluyor
    //bizde bu fonksiyonda diyoruz ki view'lar oluşturulduğunda şunu şunu yap.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = view.findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("ismail")
            Navigation.findNavController(it).navigate(action)
        }
    }
}