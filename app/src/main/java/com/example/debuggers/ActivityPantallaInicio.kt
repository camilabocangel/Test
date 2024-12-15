package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debuggers.databinding.ActivityPantallaInicioBinding

class ActivityPantallaInicio : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaInicioBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.cardviewPersonalizaRutina.setOnClickListener {
            val intentEleccionMusculos = Intent (applicationContext, ActivityEleccionMusculos::class.java)
            startActivity(intentEleccionMusculos)
        }

        binding.iconoPerfilPantallaInicio.setOnClickListener {
            val intentPerfilUsuario = Intent (this, ActivityUserPerfil::class.java)
            startActivity(intentPerfilUsuario)
        }
    }
}