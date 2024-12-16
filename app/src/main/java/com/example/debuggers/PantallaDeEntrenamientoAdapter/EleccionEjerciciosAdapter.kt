package com.example.debuggers.adapters.EleccionEjerciciosAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debuggers.databinding.ItemEjerciciosBinding
import com.example.debuggers.dataclasses.ejerciciosimagen

class EleccionEjerciciosAdapter :
    RecyclerView.Adapter<EleccionEjerciciosAdapter.EjemploViewHolder>() {

    private val listaDatos = mutableListOf<ejerciciosimagen>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EjemploViewHolder {
        context = parent.context
        return EjemploViewHolder(
            ItemEjerciciosBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EjemploViewHolder, position: Int) {
        holder.binding(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class EjemploViewHolder(private val binding: ItemEjerciciosBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: ejerciciosimagen) {


            binding.checkboxEleccionEjercicios.text = data.nombreEj
            binding.imagenEjercicio.setImageResource(data.imagen)


        }
    }

    fun addDataToList(list: List<ejerciciosimagen>) {
        listaDatos.clear()
        listaDatos.addAll(list)
    }

}