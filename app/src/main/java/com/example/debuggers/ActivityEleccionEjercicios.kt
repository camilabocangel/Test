package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.debuggers.databinding.ActivityEleccionEjerciciosBinding

class ActivityEleccionEjercicios : AppCompatActivity() {
    private lateinit var binding: ActivityEleccionEjerciciosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEleccionEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val selectedItems = intent.getIntArrayExtra("musculosSeleccionados")
        binding.siguienteAEntrenamiento.setOnClickListener {
            val intentEntrenamiento = Intent (this, ActivityPantallaDeEntrenamiento::class.java)
            startActivity(intentEntrenamiento)
        }
        binding.botonAtrasAEleccionMusculo.setOnClickListener {
            val intentAtrasMusculos = Intent (this, ActivityEleccionMusculos::class.java)
            startActivity(intentAtrasMusculos)
        }
    }
}