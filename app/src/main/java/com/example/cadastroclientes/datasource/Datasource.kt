package com.example.cadastroclientes.datasource

import com.example.cadastroclientes.model.Cliente

class Datasource {

    companion object{
        fun getCliente(): ArrayList<Cliente>{
            var cliente = ArrayList<Cliente>()

            cliente.add(Cliente(100,"cleide", "cleide@santos", "06683-000",
                "rua das flores", "vila gioia", "itapevi", "SP"))


            return cliente
        }
    }

}