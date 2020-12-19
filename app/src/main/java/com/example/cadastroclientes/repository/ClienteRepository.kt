package com.example.cadastroclientes.repository

import android.content.ContentValues
import android.content.Context
import com.example.cadastroclientes.datasource.DatabaseDefinitions
import com.example.cadastroclientes.datasource.DatabaseHelper
import com.example.cadastroclientes.model.Cliente

class ClienteRepository(context: Context) {

    // criando a instancia do banco
    private val dbHelper = DatabaseHelper(context)

    // salva um jogo no banco
    fun save(cliente: Cliente) : Int{

        // colocando o banco em modo escrita
        val db = dbHelper.writableDatabase

        // criando um mapa de informações
        val conteudo = ContentValues()
        conteudo.put(DatabaseDefinitions.Cliente.Columns.NOME, cliente.nome)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.EMAIL, cliente.email)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.CEP, cliente.cep)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.RUA, cliente.rua)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.BAIRRO, cliente.bairro)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.CIDADE, cliente.cidade)
        conteudo.put(DatabaseDefinitions.Cliente.Columns.ESTADO, cliente.estado)

        // inserindo os dados no banco
        val id = db.insert(DatabaseDefinitions.Cliente.TABLE_NAME, null, conteudo)
        return id.toInt()
    }

    // lista todos os jogos do banco
    fun getClientes(): ArrayList<Cliente>{

        // colocando o banco em modo leitura
        val db = dbHelper.readableDatabase

        // definindo a ordem de selecao do banco
        val sortOrder = "${DatabaseDefinitions.Cliente.Columns.NOME} ASC"
0
        // executando uma query de consula
        val cursor =  db.query(DatabaseDefinitions.Cliente.TABLE_NAME, null, null,
            null, null, null, sortOrder)

        // declarando que a variavel cliente é um arrayList
        var clientes = ArrayList<Cliente>()

        // verificando se o cursor é nulo
        if(cursor != null){
            while (cursor.moveToNext()){
                var cliente = Cliente(
                    id =  cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.ID)),
                    nome =  cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.NOME)),
                    email = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.EMAIL)),
                    cep = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.CEP)),
                    rua = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.RUA)),
                    bairro = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.BAIRRO)),
                    cidade = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.CIDADE)),
                    estado = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Cliente.Columns.ESTADO))
                )
                clientes.add(cliente)
            }
        }
        return clientes
    }
}