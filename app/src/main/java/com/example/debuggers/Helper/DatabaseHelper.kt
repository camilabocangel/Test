package com.example.debuggers.Helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.debuggers.dataclasses.Registro
import com.example.debuggers.dataclasses.RegistroEjercicio
import com.example.debuggers.model.Ejercicio
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Quintuple<A, B, C, D, E>(val first: A, val second: B, val third: C, val fourth: D, val fifth: E)




class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "gimnasio.db"
        private const val DATABASE_VERSION = 8

        const val TABLE_NAME1 = "musculos"
        const val ID_MUSCULO = "id"
        const val MUSCULO = "musculo"

        const val TABLE_NAME2 = "ejercicios"
        const val ID_EJERCICIOS = "id_ejercicos"
        const val NOMBRE_EJERCICIO = "nombre_ejercicio"
        const val GIF_EJERCICIO = "gif_ejercicio"
        const val IMAGEN_EJERCICIO = "imagen_ejercicio"

        const val TABLE_NAME3 = "registro"
        const val ID_REGISTRO = "id_registro"
        const val FECHA = "fecha"

        const val TABLE_NAME4 = "registro_ejercicios"
        const val ID_EJ_REGISTRO = "id_ejercicio_registro"
        const val PESO = "peso"
        const val TERMINADO = "terminado"

        @Volatile
        private var instance: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper {
            return instance ?: synchronized(this) {
                instance ?: DatabaseHelper(context.applicationContext).also { instance = it }
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable1 = """
             CREATE TABLE $TABLE_NAME1 (
             $ID_MUSCULO INTEGER PRIMARY KEY,
             $MUSCULO TEXT NOT NULL
             )
             """
        db?.execSQL(createTable1)
        val createTable2 = """
            CREATE TABLE $TABLE_NAME2 (
            $ID_EJERCICIOS INTEGER PRIMARY KEY,
            $ID_MUSCULO INTEGER NOT NULL,
            $NOMBRE_EJERCICIO TEXT NOT NULL,
            $GIF_EJERCICIO TEXT NOT NULL,
            $IMAGEN_EJERCICIO TEXT NOT NULL
            )
            """
        db?.execSQL(createTable2)
        val createTable3 = """
             CREATE TABLE $TABLE_NAME3 (
             $ID_REGISTRO INTEGER PRIMARY KEY AUTOINCREMENT,
             $FECHA DATETIME NOT NULL
             )
             """
        db?.execSQL(createTable3)
        val createTable4 = """
             CREATE TABLE $TABLE_NAME4 (
             $ID_EJ_REGISTRO INTEGER PRIMARY KEY AUTOINCREMENT,
             $ID_REGISTRO INTEGER NOT NULL,
             $ID_EJERCICIOS INTEGER NOT NULL,
             $PESO INTEGER NOT NULL,
             $TERMINADO BOOLEAN NOT NULL
             )
             """
        db?.execSQL(createTable4)

        val musculos = listOf("Biceps", "Triceps","Cuadriceps", "Espalda", "Femoral", "Pecho")
        val ejercicios = listOf(
            Quintuple(1,1, "Crossover bicep polea", "sun","jalon_pecho"),
            Quintuple(2,1, "Curl barra", "sun","jalon_pecho"),
            Quintuple(3,1, "Curl concentrado", "curl_concentrado.mp4","jalon_pecho"),
            Quintuple(4,1, "Curl inverso", "curl_inverso.mp4","jalon_pecho"),
            Quintuple(5,1, "Curl martillo", "curl_martillo.mp4","jalon_pecho"),
            Quintuple(6,1, "Curl predicador", "curl_predicador.mp4","jalon_pecho"),
            Quintuple(7,2, "Copa con mancuernas", "hamster.gif","imagen7"),
            Quintuple(8,2, "Fondos en paralelas", "hamster.gif","imagen8"),
            Quintuple(9,2, "Overhead tricep extension", "crossover_bicep_polea.mp4","imagen9"),
            Quintuple(10,2, "Pullover tricep", "sun.gif","imagen10"),
            Quintuple(11,2, "Pushdown con cuerda", "hamster.gif","imagen11"),
            Quintuple(12,2, "Skull crushers", "sun.gif","imagen12"),
            Quintuple(13,2, "Tricep kickbacks", "hamster.gif","imagen13"),
            Quintuple(14,3, "Bulgaras", "hamster.gif","imagen14"),
            Quintuple(15,3, "Extensiones de cuadrticeps", "hamster.gif","imagen15"),
            Quintuple(16,3, "Front squats", "crossover_bicep_polea.mp4","imagen16"),
            Quintuple(17,3, "Hack squat", "sun.gif","imagen17"),
            Quintuple(18,3, "Lounges estaticos", "hamster.gif","imagen18"),
            Quintuple(19,3, "Prensa de piernas", "sun.gif","imagen19"),
            Quintuple(20,3, "Squats", "hamster.gif","imagen20"),
            Quintuple(21,4, "Dominadas", "hamster.gif","imagen21"),
            Quintuple(22,4, "Good mornings", "hamster.gif","imagen22"),
            Quintuple(23,4, "Jalon al pecho", "crossover_bicep_polea.mp4","imagen23"),
            Quintuple(24,4, "Pushdown", "sun.gif","imagen24"),
            Quintuple(25,4, "Remo banco inclinado", "hamster.gif","imagen25"),
            Quintuple(26,4, "Remo barra t", "sun.gif","imagen26"),
            Quintuple(27,4, "Remo unilateral", "hamster.gif","imagen27"),
            Quintuple(28,5, "Femoral acostado", "hamster.gif","imagen28"),
            Quintuple(29,5, "Femoral sentado", "hamster.gif","imagen29"),
            Quintuple(30,5, "Hip thrust", "crossover_bicep_polea.mp4","imagen30"),
            Quintuple(31,5, "Hiperextensiones", "sun.gif","imagen31"),
            Quintuple(32,5, "Patada unilateral", "hamster.gif","imagen32"),
            Quintuple(33,5, "Peso muerto", "sun.gif","imagen33"),
            Quintuple(34,5, "Prensa con apertura", "hamster.gif","imagen34"),
            Quintuple(35,6, "Cruce de poleas", "hamster.gif","imagen35"),
            Quintuple(36,6, "Jale abierto inclinado", "hamster.gif","imagen36"),
            Quintuple(37,6, "Press con barra", "crossover_bicep_polea.mp4","imagen37"),
            Quintuple(38,6, "Press inclinado", "sun.gif","imagen38"),
            Quintuple(39,6, "Press en maquina", "hamster.gif","imagen39"),
            Quintuple(40,6, "Press plano mancuernas", "sun.gif","imagen40"),
            Quintuple(41,6, "Pushups", "hamster.gif","imagen41")
        )

        db?.beginTransaction()
        try {
            val sql = "INSERT INTO $TABLE_NAME1 ($ID_MUSCULO, $MUSCULO) VALUES (?,?)"
            val statement = db?.compileStatement(sql)
            for ((i,m) in musculos.withIndex()) {
                statement?.clearBindings()
                statement?.bindLong(1,i.toLong()+1)
                statement?.bindString(2,m)
                statement?.executeInsert()
            }

            val sql1 = "INSERT INTO $TABLE_NAME2 ($ID_EJERCICIOS, $ID_MUSCULO, $NOMBRE_EJERCICIO, $GIF_EJERCICIO, $IMAGEN_EJERCICIO) VALUES (?,?,?,?,?)"
            val statement1 = db?.compileStatement(sql1)

            for (e in ejercicios) {
                statement1?.clearBindings()
                statement1?.bindLong(1,e.first.toLong())
                statement1?.bindLong(2,e.second.toLong())
                statement1?.bindString(3,e.third)
                statement1?.bindString(4,e.fourth)
                statement1?.bindString(5,e.fifth)
                statement1?.executeInsert()
            }

            db?.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db?.endTransaction()
        }
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME1")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME3")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME4")
        onCreate(db)
    }
    fun insertRutina(ejercicios: List<Ejercicio>):Unit {
        val fecha = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(FECHA, fecha)
        }
        val idRegistro = db.insert(TABLE_NAME3, null, contentValues)
        ejercicios.forEach { ejercicio ->
            val cv = ContentValues().apply {
                put(ID_REGISTRO, idRegistro)
                put(ID_EJERCICIOS, ejercicio.id)
                put(PESO, ejercicio.peso)
                put(TERMINADO, ejercicio.isSelected)
            }
            db.insert(TABLE_NAME4, null, cv)
        }
    }
    fun getHistorial(): List<Registro> {
        val registros = mutableListOf<Registro>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME3 ORDER BY fecha DESC", null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(ID_REGISTRO))
                val fecha = getString(getColumnIndexOrThrow(FECHA)) // Si guardaste la fecha como String
                registros.add(Registro(id,fecha, mutableListOf()))
            }
        }
        cursor.close()
        registros.forEach{registro ->
            val cursor2 = db.rawQuery("SELECT * FROM $TABLE_NAME4 JOIN $TABLE_NAME2 ON $TABLE_NAME4.$ID_EJERCICIOS = $TABLE_NAME2.$ID_EJERCICIOS WHERE id_registro = ?", arrayOf(registro.id.toString()))
            with(cursor2) {
                while (moveToNext()) {
                    val ejercicio = getString(getColumnIndexOrThrow(NOMBRE_EJERCICIO))
                    val peso = getInt(getColumnIndexOrThrow(PESO))  // Si guardaste la fecha como String
                    registro.ejercicios.add(RegistroEjercicio(ejercicio,peso))
                }
            }
            cursor2.close()
        }
        db.close()
        return registros
    }
     //val nombre = getString(getColumnIndexOrThrow("nombre"))
               // val peso = getInt(getColumnIndexOrThrow("peso"))
}