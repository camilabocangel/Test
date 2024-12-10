package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debuggers.databinding.ActivityEleccionMusculosBinding
import com.example.debuggers.databinding.ActivityLoginBinding

class ActivityEleccionMusculos : AppCompatActivity() {
    private lateinit var binding: ActivityEleccionMusculosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionMusculosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.siguienteAElecEjercicios.setOnClickListener {
            val intentEleccionEjercicios = Intent (this, ActivityEleccionEjercicios::class.java)
            startActivity(intentEleccionEjercicios)
        }
        binding.botonAtrasARegistro.setOnClickListener {
            val intentAtrasARegistro = Intent (this, ActivityRegistrarDatos::class.java)
            startActivity(intentAtrasARegistro)
        }
    }
}