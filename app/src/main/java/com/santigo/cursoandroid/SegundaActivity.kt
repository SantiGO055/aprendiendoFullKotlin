package com.santigo.cursoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    private var nombre: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val button = findViewById<Button>(R.id.btn_volver)
        val texto = findViewById<TextView>(R.id.txt_output)
        /**
         * //puede ser null, se puede hacer un if para validar o usar let
         */
        intent.extras?.let { bundle ->

            nombre = bundle.getString("nombre")

        }
        texto.text = nombre
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nombre2","Hola desde segunda activity")
            setResult(Activity.RESULT_OK,intent)
            finish() // destruyo esta activity y vuelve a la activity anterior
            //android utiliza backstack para guardar el destino anterior, si se usa intent se crearia otra vista mas de main
            //se va haciendo una pila de actividades, lo recomendable es utilizar finish


        }
    }
}