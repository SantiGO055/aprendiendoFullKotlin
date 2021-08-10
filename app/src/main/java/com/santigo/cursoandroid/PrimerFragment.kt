package com.santigo.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit


class PrimerFragment : Fragment(R.layout.fragment_primer) {

    // comento ya que al crear la clase y heredar se pasa como parametro el layout
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_primer, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.text)
        val button = view.findViewById<Button>(R.id.btn_navegar)
        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, SegundoFragment())
                addToBackStack("primerFragment") //el nombre que paso es un ID para identificar la pantalla anterior
                //si agrego
            }
        }
    }

}