package com.santigo.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController


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

//        val texto = view.findViewById<TextView>(R.id.text)
        val button = view.findViewById<Button>(R.id.btn_navegar)
        val text = view.findViewById<TextView>(R.id.txt_output)


        /**
         * creo listener que este escuchando cambios desde el fragment dos
         */
        setFragmentResultListener("req"){
            requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            //lo que viene del segundo fragmento lo asigno al texto
            text.text = result
        }


        button.setOnClickListener {
            //navegacion con plugin de google
            findNavController().navigate(R.id.action_primerFragment_to_segundoFragment) //encontramos el main graph el cual se creo para navegar



//            navegacion de manera nativa
//            requireActivity().supportFragmentManager.commit {
//
//
//                replace(R.id.fragment_container_view, SegundoFragment.newInstance("Santiago",24))
//                addToBackStack("primerFragment") //el nombre que paso es un ID para identificar la pantalla anterior
//                //si agrego
//            }

        }
    }

}