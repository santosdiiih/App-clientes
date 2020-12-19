package com.example.cadastroclientes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadastroclientes.R
import com.example.cadastroclientes.adapter.ClienteReciclerAdapter
import com.example.cadastroclientes.datasource.Datasource
import com.example.cadastroclientes.model.Cliente
import com.example.cadastroclientes.repository.ClienteRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_novo__cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertToolbar()

    }

    override fun onResume() {
        iniciarRecyclerView()
        super.onResume()
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Cliente"

    }

    private fun iniciarRecyclerView() {
        val reciclerView = recycleViewCliente
        reciclerView.layoutManager = LinearLayoutManager(this)

        // recuperando a lista de select do banco
        val repo = ClienteRepository(this)


        reciclerView.adapter = ClienteReciclerAdapter(repo.getClientes())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cliente, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.novoCliente -> {
                val intent = Intent(this, Novo_Cliente::class.java)
                startActivity(intent)
            }
        }

        return true
    }





}