package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.debuggers.adapters.EleccionEjerciciosAdapter.EleccionEjerciciosAdapter
import com.example.debuggers.databinding.ActivityEleccionEjerciciosBinding
import com.example.debuggers.dataclasses.ejercicios
import com.example.debuggers.dataclasses.ejerciciosimagen

class ActivityEleccionEjercicios : AppCompatActivity() {
    private lateinit var binding: ActivityEleccionEjerciciosBinding
    private val EleccionEjerciciosAdapter by lazy { EleccionEjerciciosAdapter () }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclewViewEjercicios()

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
    fun setUpRecyclewViewEjercicios(){
        val listaDatos = mutableListOf(
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            ),
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            ),
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            ),
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            ),
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            ),
            ejerciciosimagen(
                nombreEj = "biceps",
                imagen = R.drawable.jalon_pecho
            )
        )
        EleccionEjerciciosAdapter.addDataToList(listaDatos)

        binding.recyclerEjercicios.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = EleccionEjerciciosAdapter
        }
    }
}