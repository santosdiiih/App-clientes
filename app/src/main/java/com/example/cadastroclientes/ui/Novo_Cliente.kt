package com.example.cadastroclientes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.cadastroclientes.R
import com.example.cadastroclientes.model.Cliente
import com.example.cadastroclientes.repository.ClienteRepository
import kotlinx.android.synthetic.main.activity_novo__cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class Novo_Cliente : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo__cliente)

        insertToolbar()

        val buttonSalvar = findViewById<Button>(R.id.btnSalvar)

        buttonSalvar.setOnClickListener(this)

    }
    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        // adiciona o titulo
        supportActionBar!!.title = "Novo Registro"
        // exibe a seta de voltar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun salvarCliente() {

        // criando o objeto cliente
         val cliente = Cliente(
             nome = txtNome.text.toString(),
             email = txtEmail.text.toString(),
             cep = txtCep.text.toString(),
             bairro = txtBairro.text.toString(),
             cidade = txtCidade.text.toString(),
             estado = txtEstado.text.toString(),
             rua = txtRua.text.toString()
         )

        // criando uma instancia do repositorio
        val repo  = ClienteRepository(this)
        val id = repo.save(cliente)


    }

    private fun validaFormulario(): Boolean {
        var valida = true

        if (txtNome.length() < 5) {
            textInputNome.isErrorEnabled = true
            textInputNome.error = "É necessario digitar o nome do cliente!"
            valida = false
        } else {
            textInputNome.isErrorEnabled = false
            textInputNome.error = null
        }

        if (txtEmail.length() < 5) {
            textInputEmail.isErrorEnabled = true
            textInputEmail.error = "É necessario digitar o email do cliente!"
            valida = false
        } else {
            textInputEmail.isErrorEnabled = false
            textInputEmail.error = null
        }

        if (txtCep.length() < 5) {
            textInputCep.isErrorEnabled = true
            textInputCep.error = "É necessario digitar o CEP do cliente!"
            valida = false
        } else {
            textInputCep.isErrorEnabled = false
            textInputCep.error = null
        }

        if (txtRua.length() < 5) {
            textInputRua.isErrorEnabled = true
            textInputRua.error = "É necessario digitar a rua do cliente!"
            valida = false
        } else {
            textInputRua.isErrorEnabled = false
            textInputRua.error = null
        }

        if (txtBairro.length() < 5) {
            textInputBairro.isErrorEnabled = true
            textInputBairro.error = "É necessario digitar o bairro do cliente!"
            valida = false
        } else {
            textInputBairro.isErrorEnabled = false
            textInputBairro.error = null
        }

        if (txtCidade.length() < 5) {
            textInputCidade.isErrorEnabled = true
            textInputCidade.error = "É necessario digitar a cidade do cliente!"
            valida = false
        } else {
            textInputCidade.isErrorEnabled = false
            textInputCidade.error = null
        }

        if (txtEstado.length() < 5) {
            textInputEstado.isErrorEnabled = true
            textInputEstado.error = "É necessario digitar o estado do cliente!"
            valida = false
        } else {
            textInputEstado.isErrorEnabled = false
            textInputEstado.error = null
        }

        return valida
    }

    override fun onClick(view: View) {
       if(view.id == R.id.btnSalvar) {
            if(validaFormulario()){
                if(salvarCliente() != null){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

}