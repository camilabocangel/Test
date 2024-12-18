package com.example.debuggers.Helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Quintuple<A, B, C, D, E>(val first: A, val second: B, val third: C, val fourth: D, val fifth: E)




class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "gimnasio.db"
        private const val DATABASE_VERSION = 6

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
            $ID_MUSCULO NOT NULL,
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
             $ID_EJERCICIOS NOT NULL,
             $PESO INTEGER NOT NULL,
             $TERMINADO BOOLEAN NOT NULL
             )
             """
        db?.execSQL(createTable4)

        val musculos = listOf("Biceps", "Triceps","Cuadriceps", "Espalda", "Femoral", "Pecho")
        val ejercicios = listOf(
            Quintuple(1,1, "Crossover bicep polea", "sun","imagen_crossover_de_biceps"),
            Quintuple(2,1, "Curl barra", "sun","imagen_curl_barra"),
            Quintuple(3,1, "Curl concentrado", "curl_concentrado.mp4","imagen_curl_concentrado"),
            Quintuple(4,1, "Curl inverso", "curl_inverso.mp4","imagen_curl_inverso"),
            Quintuple(5,1, "Curl martillo", "curl_martillo.mp4","imagen_curl_martillo"),
            Quintuple(6,1, "Curl predicador", "curl_predicador.mp4","imagen_curl_predicador"),
            Quintuple(7,2, "Copa con mancuernas", "hamster.gif","imagen_copa_con_mancuerna"),
            Quintuple(8,2, "Fondos en paralelas", "hamster.gif","imagen_fondos_en_paralelas"),
            Quintuple(9,2, "Overhead tricep extension", "crossover_bicep_polea.mp4","imagen_overhead_tricep_extension"),
            Quintuple(10,2, "Pullover tricep", "sun.gif","imagen_pullover_tricep"),
            Quintuple(11,2, "Pushdown con cuerda", "hamster.gif","imagen_pushdown_con_cuerda"),
            Quintuple(12,2, "Skull crushers", "sun.gif","imagen_skull_crushers"),
            Quintuple(13,2, "Tricep kickbacks", "hamster.gif","imagen_tricep_kickbacks"),
            Quintuple(14,3, "Búlgaras", "hamster.gif","imagen_bulgaras"),
            Quintuple(15,3, "Extensiones de cuádriceps", "hamster.gif","imagen_extensiones_cuadriceps"),
            Quintuple(16,3, "Front squats", "crossover_bicep_polea.mp4","imagen_front_squats"),
            Quintuple(17,3, "Hack squat", "sun.gif","imagen_hack_squat"),
            Quintuple(18,3, "Lounges estáticos", "hamster.gif","imagen_lounges_estaticos"),
            Quintuple(19,3, "Prensa de piernas", "sun.gif","imagen_prensa_de_piernas"),
            Quintuple(20,3, "Smith squats", "hamster.gif","imagen_smith_squats"),
            Quintuple(21,4, "Dominadas", "hamster.gif","imagen_dominadas"),
            Quintuple(22,4, "Good mornings", "hamster.gif","imagen_good_mornings"),
            Quintuple(23,4, "Jalón al pecho", "crossover_bicep_polea.mp4","imagen_jalon_al_pecho"),
            Quintuple(24,4, "Pushdown", "sun.gif","imagen_pushdowns"),
            Quintuple(25,4, "Remo banco inclinado", "hamster.gif","imagen_remo_banco_inclinado"),
            Quintuple(26,4, "Remo con barra t", "sun.gif","imagen_remo_barra_t"),
            Quintuple(27,4, "Remo unilateral", "hamster.gif","imagen_remo_unilateral"),
            Quintuple(28,5, "Femoral acostado", "hamster.gif","imagen_femoral_acostado"),
            Quintuple(29,5, "Femoral sentado", "hamster.gif","imagen_femoral_sentado"),
            Quintuple(30,5, "Hip thrust", "crossover_bicep_polea.mp4","imagen_hip_thrust"),
            Quintuple(31,5, "Hiperextensiones", "sun.gif","imagen_hiperextensiones"),
            Quintuple(32,5, "Patada unilateral", "hamster.gif","imagen_patada_unilateral"),
            Quintuple(33,5, "Peso muerto", "sun.gif","imagen_peso_muerto"),
            Quintuple(34,5, "Prensa con apertura", "hamster.gif","imagen_prensa_apertura"),
            Quintuple(35,6, "Cruce de poleas", "hamster.gif","imagen_cruce_de_poleas"),
            Quintuple(36,6, "Jale abierto inclinado", "hamster.gif","imagen_jale_abierto_inclinado"),
            Quintuple(37,6, "Press con barra", "crossover_bicep_polea.mp4","imagen_press_con_barra"),
            Quintuple(38,6, "Press inclinado", "sun.gif","imagen_press_declinado"),
            Quintuple(39,6, "Press en máquina", "hamster.gif","imagen_press_en_maquina"),
            Quintuple(40,6, "Press plano mancuernas", "sun.gif","imagen_press_plano_mancuernas"),
            Quintuple(41,6, "Pushups", "hamster.gif","imagen_pushups")
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
}