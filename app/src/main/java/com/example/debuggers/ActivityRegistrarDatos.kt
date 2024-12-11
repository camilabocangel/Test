package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debuggers.databinding.ActivityRegistrarDatosBinding
import com.example.debuggers.databinding.ActivityLoginBinding

class ActivityRegistrarDatos : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarDatosBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
            binding.siguienteAElecMusculos.setOnClickListener {
                val intentEleccionMusculos = Intent(applicationContext, ActivityEleccionMusculos::class.java)
                startActivity(intentEleccionMusculos)
            }
    }
}