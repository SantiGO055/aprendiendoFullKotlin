package com.santigo.cursoandroid

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String?=""
    private var edad: Int ?= 0
    private val args: SegundoFragmentArgs by navArgs()

    /**
     * si obtengo los argumentos aca, puedo usar antes que la vista se cree, en caso de preinicializar la vista con esos datos
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //obtengo argumentos
//        nombre = requireArguments().getString(MI_NOMBRE)
//        edad = requireArguments().getInt(MI_EDAD)
        //si los argumentos no son nulos entra en el siguiente metodo
        /**
         * lo saco para usar safe args
        arguments?.let {
        bundle ->
        nombre = bundle.getString(MI_NOMBRE)
        edad = bundle.getInt(MI_EDAD)
        }
         */
        nombre = args.nombre
        edad = args.edad

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_output)
        text.text = "Nombre: $nombre, Edad: $edad"
        val boton = view.findViewById<Button>(R.id.btn_enviar_datos)
        boton.setOnClickListener {
            val result = "resultado"
            setFragmentResult("req", bundleOf("bundleKey" to result)) //bundleOf paso clave (el nombre que le puse en el primer fragment) valor ()
            findNavController().navigate(Uri.parse("cursoandroid://card")) //paso el nombre del uri del deeplink
        }

    }

    /**
     * esto es como una especie de de constructor
     */
    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        /**
         * creo fragmento y le aplico argumentos
         * @return set de clave valor
         */
        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply { //retorno
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad) //creo set de clave valor
        }
    }
}