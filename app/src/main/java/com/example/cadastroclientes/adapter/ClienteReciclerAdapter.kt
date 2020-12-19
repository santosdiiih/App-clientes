package com.example.cadastroclientes.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroclientes.R
import com.example.cadastroclientes.model.Cliente
import kotlinx.android.synthetic.main.card_cliente.view.*

class ClienteReciclerAdapter (var listaCliente: ArrayList<Cliente>) : RecyclerView.Adapter <ClienteReciclerAdapter.ClientViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_cliente, parent, false)
        return ClientViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaCliente.size
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val cliente = listaCliente[position]
        holder.bind(cliente, position)
    }
    inner class  ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(cliente: Cliente, position: Int){
            itemView.nome.text = cliente.nome
            itemView.email.text = cliente.email
            itemView.cep.text = cliente.cep
            itemView.rua.text = cliente.rua
            itemView.bairro.text = cliente.bairro
            itemView.cidade.text = cliente.cidade
            itemView.estado.text = cliente.estado

        }

    }

}