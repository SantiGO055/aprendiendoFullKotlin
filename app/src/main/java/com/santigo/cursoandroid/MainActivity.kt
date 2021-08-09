package com.santigo.cursoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreate: ")

        texto = findViewById<TextView>(R.id.txt_output)
        val boton = findViewById<Button>(R.id.btn_accion)

        boton.setOnClickListener {
            if (texto.text != "Curso Android")
                texto.text = "Curso Android"
            else
                texto.text = "Hello World!"

            navegarSegundaActivity()
        }
    }

    private fun navegarSegundaActivity(){
        val intent = Intent(this,SegundaActivity::class.java) //desde esta clase (main activity) hacia la otra activity
        intent.putExtra("nombre","Segunda activity")
        //startActivity(intent)
        startActivityForResult(intent,1) //el request code es para identificar que se va a la 2da activity
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){ //el request es el que identifica que vamos a la 2da activity
            if(resultCode == Activity.RESULT_OK){
                texto.text = data?.getStringExtra("nombre2")

            }
        }
    }

    /**
     * Estos metodos se ejecutan siempre que se inicia la app
     */
    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause: ")

    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop: ")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy: ")

    }




}