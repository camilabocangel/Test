package com.example.debuggers.Helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.example.debuggers.R

class MusculosAdapter(context: Context, private val items: List<Pair<Long, String>>) :
    ArrayAdapter<Pair<Long, String>>(context, R.layout.check_musculo, items) {

    private val itemStates = mutableMapOf<Long, Boolean>()

    init {
        items.forEach { itemStates[it.first] = false }
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position)
        if (item != null) {
            return item.first
        }
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.check_musculo, parent, false)
        val checkBox: CheckBox = view.findViewById(R.id.checkbox_musculo)
        val item = getItem(position)

        checkBox.text = item?.second
        checkBox.isChecked = itemStates[item?.first] == true

        // Add a listener to handle checkbox changes
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (item != null) {
                itemStates[item.first] = isChecked
            }
        }

        return view
    }
}