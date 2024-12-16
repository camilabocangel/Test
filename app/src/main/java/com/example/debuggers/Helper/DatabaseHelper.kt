package com.example.debuggers.Helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)




class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "gimnasio.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME1 = "musculos"
        const val ID_MUSCULO = "id"
        const val MUSCULO = "musculo"

        const val TABLE_NAME2 = "ejercicios"
        const val ID_EJERCICIOS = "id_ejercicos"
        const val NOMBRE_EJERCICIO = "nombre_ejercicio"
        const val GIF_EJERCICIO = "gif_ejercicio"

        const val TABLE_NAME3 = "registro_ejercicios"
        const val ID_REGISTRO = "id_registro"
        const val FECHA = "fecha"
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
            $GIF_EJERCICIO TEXT NOT NULL
            )
            """
        db?.execSQL(createTable2)
        val createTable3 = """
             CREATE TABLE $TABLE_NAME3 (
             $ID_REGISTRO INTEGER PRIMARY KEY AUTOINCREMENT,
             $ID_EJERCICIOS NOT NULL,
             $FECHA DATETIME NOT NULL,
             $PESO INTEGER NOT NULL,
             $TERMINADO BOOLEAN NOT NULL
             )
             """
        db?.execSQL(createTable3)

        val musculos = listOf("Biceps", "Triceps","Cuadriceps", "Espalda", "Femoral", "Pecho")
        val ejercicios = listOf(
            Quadruple(1,1, "Curl con barra", "hamster.gif"),
            Quadruple(2,1, "Curl martillo", "sun.gif"),
            Quadruple(3,1, "Curl predicador", "hamster.gif"),
            Quadruple(4,1, "Curl inverso", "sun.gif"),
            Quadruple(5,2, "Fondos paralelas", "hamster.gif"),
            Quadruple(6,2, "Skull chushers", "sun.gif"),
            Quadruple(7,2, "Copa con mancuernas", "hamster.gif"),
            Quadruple(8,2, "Pullover", "hamster.gif")
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

            val sql1 = "INSERT INTO $TABLE_NAME2 ($ID_EJERCICIOS, $ID_MUSCULO, $NOMBRE_EJERCICIO, $GIF_EJERCICIO) VALUES (?,?,?,?)"
            val statement1 = db?.compileStatement(sql1)

            for (e in ejercicios) {
                statement1?.clearBindings()
                statement1?.bindLong(1,e.first.toLong())
                statement1?.bindLong(2,e.second.toLong())
                statement1?.bindString(3,e.third)
                statement1?.bindString(4,e.fourth)
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
        onCreate(db)
    }
}