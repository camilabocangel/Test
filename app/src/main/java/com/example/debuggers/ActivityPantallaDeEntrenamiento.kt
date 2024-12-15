package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.debuggers.adapters.PantallaDeEntrenamientoAdapter.PantallaDeEntrenamientoAdapter
import com.example.debuggers.databinding.ActivityPantallaDeEntrenamientoBinding
import com.example.debuggers.dataclasses.ejercicios


class ActivityPantallaDeEntrenamiento : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaDeEntrenamientoBinding

    private val pantallaDeEntrenamientoAdapter by lazy { PantallaDeEntrenamientoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDeEntrenamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclewViewEntrenamiento()



        binding.siguienteAFelicidades.setOnClickListener {
            val intentFelicidades = Intent (this, ActivityFelicidades::class.java)
            startActivity(intentFelicidades)
        }
        binding.cancelarEntrenamiento.setOnClickListener {
            val intentAtrasEjercicio = Intent (this, ActivityEleccionEjercicios::class.java)
            startActivity(intentAtrasEjercicio)
        }
    }
    fun setUpRecyclewViewEntrenamiento(){
        val listaDatos = mutableListOf(
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita
            )
        )
        pantallaDeEntrenamientoAdapter.addDataToList(listaDatos)

        binding.recyclerEntrenamiento.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = pantallaDeEntrenamientoAdapter
        }
    }
}