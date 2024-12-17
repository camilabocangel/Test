package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.debuggers.PantallaDeEntrenamientoAdapter.HistorialAdapter
import com.example.debuggers.adapters.PantallaDeEntrenamientoAdapter.PantallaDeEntrenamientoAdapter
import com.example.debuggers.databinding.ActivityHistorialBinding
import com.example.debuggers.databinding.ActivityPantallaDeEntrenamientoBinding
import com.example.debuggers.dataclasses.ejercicios

class ActivityHistorial : AppCompatActivity() {
    private lateinit var binding: ActivityHistorialBinding

    private val HistorialAdapter by lazy { HistorialAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclewViewHistorial()

        binding.botonAtrasAPantallaInicio.setOnClickListener {
            val intentPantallaInicio = Intent (this, ActivityPantallaInicio::class.java)
            startActivity(intentPantallaInicio)
        }
    }

    fun setUpRecyclewViewHistorial(){
        val listaDatos = mutableListOf(
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            ),
            ejercicios(
                nombreEj = "biceps",
                imagen = R.drawable.pesita,
                peso = 10
            )
        )
        HistorialAdapter.addDataToList(listaDatos)

        binding.recyclerHistorial.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = HistorialAdapter
        }
    }
}