package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.debuggers.databinding.ActivityPantallaDeEntrenamientoBinding


class ActivityPantallaDeEntrenamiento : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaDeEntrenamientoBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var entrenamientoAdapter: EntrenamientoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDeEntrenamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val entrenamientoList = arrayListOf<carruselModel>()
        entrenamientoList.add(carruselModel(R.drawable.chica_pesa, "chicaPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chico_pesa, "chicoPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chica_pesa, "chicaPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chico_pesa, "chicoPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chica_pesa, "chicaPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chico_pesa, "chicoPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chica_pesa, "chicaPesa"))
        entrenamientoList.add(carruselModel(R.drawable.chico_pesa, "chicoPesa"))


        entrenamientoAdapter = EntrenamientoAdapter(entrenamientoList)
        recyclerView.adapter = entrenamientoAdapter

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