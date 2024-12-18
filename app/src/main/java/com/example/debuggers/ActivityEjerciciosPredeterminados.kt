package com.example.debuggers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.debuggers.PantallaDeEntrenamientoAdapter.HistorialAdapter
import com.example.debuggers.PantallaDeEntrenamientoAdapter.PredeterminadosEjerciciosAdapter
import com.example.debuggers.databinding.ActivityEjerciciosPredeterminadosBinding
import com.example.debuggers.databinding.ActivityEleccionEjerciciosBinding
import com.example.debuggers.dataclasses.ejercicios
import com.example.debuggers.dataclasses.ejerciciosPredeterminados

class ActivityEjerciciosPredeterminados : AppCompatActivity() {

    private lateinit var binding :ActivityEjerciciosPredeterminadosBinding

    private val PredeterminadosEjerciciosAdapter by lazy { PredeterminadosEjerciciosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjerciciosPredeterminadosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpRecyclerViewPredeterminados()
    }

    fun setUpRecyclerViewPredeterminados() {
        val listaDatos = mutableListOf(
            ejerciciosPredeterminados(
                nombreMs = "Biceps y Espalda",
                nombreEj = "Curl Inverso, Curl con barra, Curl Martillo, Jalon al pecho, Remo unilateral, Pushdown",
                imagen = R.drawable.pesita,

            ),
            ejerciciosPredeterminados(
                nombreMs = "Triceps y Pecho",
                nombreEj = "Copa con mancuernas, Overhead Tricep Extension, Skull crushers, Cruce de poleas, Press plano mancuernas y Press con barra.",
                imagen = R.drawable.pesita,

            ),
            ejerciciosPredeterminados(
                nombreMs = "Cuadriceps y Femoral",
                nombreEj = "Bulgaras, Extensiones de cuadriceps , Hip Thrust , Peso muerto , Patada unilateral , Prensa de piernas .",
                imagen = R.drawable.pesita,
            ),
            ejerciciosPredeterminados(
                nombreMs = "Biceps y Espalda",
                nombreEj = "Curl Inverso, Curl con barra, Curl Martillo, Jalon al pecho, Remo unilateral, Pushdown",
                imagen = R.drawable.pesita,

            ),
        ejerciciosPredeterminados(
            nombreMs = "Triceps y Pecho",
            nombreEj = "Copa con mancuernas, Overhead Tricep Extension, Skull crushers, Cruce de poleas, Press plano mancuernas y Press con barra.",
            imagen = R.drawable.pesita,

            ),
        ejerciciosPredeterminados(
            nombreMs = "Cuadriceps y Femoral",
            nombreEj = "Bulgaras, Extensiones de cuadriceps , Hip Thrust , Peso muerto , Patada unilateral , Prensa de piernas .",
            imagen = R.drawable.pesita,
        ),
        )

        PredeterminadosEjerciciosAdapter.addDataToList(listaDatos)

        binding.recyclerPredeterminados.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = PredeterminadosEjerciciosAdapter
        }
    }
}