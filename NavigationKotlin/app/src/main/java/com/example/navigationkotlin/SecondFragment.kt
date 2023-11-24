package com.example.navigationkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val username = SecondFragmentArgs.fromBundle(it).username
            println(username)
        }

        val button2 = view.findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment2()
            Navigation.findNavController(it).navigate(action)
        }
    }

}