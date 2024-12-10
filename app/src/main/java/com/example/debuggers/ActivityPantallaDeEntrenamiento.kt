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
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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