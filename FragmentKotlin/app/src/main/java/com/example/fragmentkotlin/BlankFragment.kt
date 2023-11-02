package com.example.fragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BlankFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    // inflater xml dosyası ile layout'u birbirine bağlamak istediğimiz zaman kullanıyoruz.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater'ı layout görünümü için kullandık
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

}