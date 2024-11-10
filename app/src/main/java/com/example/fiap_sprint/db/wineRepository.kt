package com.example.fiap_sprint.db

import android.content.Context
import com.example.fiap_sprint.models.Wine


class WineRepository(context: Context) {

    private val db = ConnDb.getDatabase(context).wineDao()

    fun salvar(wine: Wine) {
        db.salvar(wine)
    }

    fun atualizar(wine: Wine) {
        db.atualizar(wine)
    }

    fun excluir(id: Int) {
        db.excluir(id)
    }

    fun listar(): List<Wine> {
        return db.listWines()
    }

    fun buscar(id: Int): Wine {
        return db.getWineById(id)
    }

}