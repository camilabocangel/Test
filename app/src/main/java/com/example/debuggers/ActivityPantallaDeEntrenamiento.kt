package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debuggers.databinding.ActivityPantallaDeEntrenamientoBinding

class ActivityPantallaDeEntrenamiento : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaDeEntrenamientoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDeEntrenamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.siguienteAFelicidades.setOnClickListener {
            val intentFelicidades = Intent (this, ActivityFelicidades::class.java)
            startActivity(intentFelicidades)
        }
        binding.cancelarEntrenamiento.setOnClickListener {
            val intentAtrasEjercicio = Intent (this, ActivityEleccionEjercicios::class.java)
            startActivity(intentAtrasEjercicio)
        }
    }
}