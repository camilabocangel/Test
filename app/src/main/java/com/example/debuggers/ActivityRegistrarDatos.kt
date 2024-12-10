package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debuggers.databinding.ActivityLoginBinding
import com.example.debuggers.databinding.ActivityRegistrarDatosBinding

class ActivityRegistrarDatos : AppCompatActivity() {
    private lateinit var binding:ActivityRegistrarDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarDatosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.siguienteAElecMusculos.setOnClickListener {
            val intentEleccionMusculos = Intent (this, ActivityEleccionMusculos::class.java)
            startActivity(intentEleccionMusculos)
        }
    }
}