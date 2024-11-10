package com.example.fiap_sprint

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fiap_sprint.db.WineRepository
import com.example.fiap_sprint.models.Wine

class WineViewModel(private val wineRepository: WineRepository) : ViewModel() {

    private var _id = 0

    fun getWines(): LiveData<List<Wine>> {
        val winesLiveData = MutableLiveData<List<Wine>>()
        winesLiveData.value = wineRepository.listar()
        return winesLiveData
    }


    fun onRemoveWine(id: Int) {
        wineRepository.excluir(id)
    }

    fun onCreateWine(name: String, price: Double){
        wineRepository.salvar(Wine(id = _id, name=name, price=price))
        _id += 1
    }

    fun onEditWine(id: Int, name: String, price: Double){
        wineRepository.atualizar(Wine(id = id, name=name, price=price))
    }

    fun find(id: Int): Wine {
        return wineRepository.buscar(id)
    }


}
