package com.example.cadastroclientes.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME , null, DATABASE_VERSION) {

    // metodo que cria o banco de dados
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE_CLIENTE)
    }

    //metodo que atualiza as informações do banco
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object{
        private const val DATABASE_NAME = "cliente.db"
        private const val DATABASE_VERSION = 1
        private const val CREATE_TABLE_CLIENTE =   "CREATE TABLE ${DatabaseDefinitions.Cliente.TABLE_NAME} (" +
                "${DatabaseDefinitions.Cliente.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DatabaseDefinitions.Cliente.Columns.NOME} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.EMAIL} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.CEP} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.RUA} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.BAIRRO} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.CIDADE} TEXT, " +
                "${DatabaseDefinitions.Cliente.Columns.ESTADO} TEXT);"
    }
}