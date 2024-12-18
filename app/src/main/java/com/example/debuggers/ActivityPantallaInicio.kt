package com.example.debuggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.debuggers.databinding.ActivityPantallaInicioBinding
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException
import java.util.Random;

class ActivityPantallaInicio : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaInicioBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.datoCurioso.text = try {
            obtenerDatoCurioso()
        } catch (e: Exception) {
            e.printStackTrace()
            "Error al cargar el dato."
        }

        val cardView2 = findViewById<CardView>(R.id.cardviewPersonalizaRutina)

        cardView2.setOnClickListener {
            val intentEleccionMusculos = Intent (applicationContext, ActivityEleccionMusculos::class.java)
            startActivity(intentEleccionMusculos)
        }

        val cardView1 = findViewById<CardView>(R.id.cardviewSinTiempo)

        cardView1.setOnClickListener {
            val intentEjerciciosPredeterminados = Intent (applicationContext, ActivityEjerciciosPredeterminados::class.java)
            startActivity(intentEjerciciosPredeterminados)
        }

        binding.iconoPerfilPantallaInicio.setOnClickListener {
            val intentPerfilUsuario = Intent (this, ActivityUserPerfil::class.java)
            startActivity(intentPerfilUsuario)
        }
        binding.iconoHistorialPantallaInicio.setOnClickListener {
            val intentHistorial = Intent (this, ActivityHistorial::class.java)
            startActivity(intentHistorial)
        }
        binding.cardviewVideos.setOnClickListener {
            val intentPantallaVideos = Intent (this, ActivityPantallaVideos::class.java)
            startActivity(intentPantallaVideos)
        }

    }

    private fun obtenerDatoCurioso(): String {
        val inputStream = resources.openRawResource(R.raw.datos_curiosos)
        return try {
            val jsonText = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonText)
            val randomIndex = Random().nextInt(jsonArray.length())
            jsonArray.getString(randomIndex)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            "Error al leer el archivo."
        } catch (jsonException: JSONException) {
            jsonException.printStackTrace()
            "Error al procesar los datos."
        }
    }
}