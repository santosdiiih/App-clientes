package com.example.cadastroclientes.datasource

class DatabaseDefinitions {

    // objeto de informações para o banco de dados
    object Cliente {

        // representa o nome da tabela
        const val TABLE_NAME = "tbl_cliente"

        object Columns {
            const val ID  = "id"
            const val NOME = "nome"
            const val EMAIL = "email"
            const val CEP = "cep"
            const val RUA = "rua"
            const val BAIRRO = "bairro"
            const val CIDADE = "cidade"
            const val ESTADO = "estado"

        }

    }
}