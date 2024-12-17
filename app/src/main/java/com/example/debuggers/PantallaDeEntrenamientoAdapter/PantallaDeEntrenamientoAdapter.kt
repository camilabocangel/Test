package com.example.debuggers.adapters.PantallaDeEntrenamientoAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debuggers.databinding.ItemEntrenamientoBinding
import com.example.debuggers.dataclasses.ejercicios

class PantallaDeEntrenamientoAdapter :
    RecyclerView.Adapter<PantallaDeEntrenamientoAdapter.EjemploViewHolder>() {

    private val listaDatos = mutableListOf<ejercicios>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EjemploViewHolder {
        context = parent.context
        return EjemploViewHolder(
            ItemEntrenamientoBinding.inflate(
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

    inner class EjemploViewHolder(private val binding: ItemEntrenamientoBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: ejercicios) {

            binding.ejercicioEnPeso.text = data.nombreEj
            binding.contador.text = data.peso.toString()
            binding.botonAumentarPeso.setOnClickListener {
                data.peso += 1
                binding.contador.text = data.peso.toString()
            }
            binding.botonRebajarPeso.setOnClickListener {
                if (data.peso > 0) {
                    data.peso -= 1
                    binding.contador.text = data.peso.toString()
                }
            }
            binding.checkboxEntrenamiento.isChecked = data.completado
            binding.checkboxEntrenamiento.setOnCheckedChangeListener { _, isChecked ->
                data.completado = isChecked
            }

        }
    }

    fun addDataToList(list: List<ejercicios>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
    }

}