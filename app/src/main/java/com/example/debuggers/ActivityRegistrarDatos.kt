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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        binding = ActivityRegistrarDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.siguienteAElecMusculos.setOnClickListener {
            val intentEleccionMusculos = Intent (applicationContext, ActivityEleccionMusculos::class.java)
            startActivity(intentEleccionMusculos)
        }
    }
}