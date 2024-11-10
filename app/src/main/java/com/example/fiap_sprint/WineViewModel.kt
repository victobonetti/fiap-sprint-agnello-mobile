package com.example.fiap_sprint

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WineViewModel : ViewModel() {
    private val _wines = MutableLiveData<List<Wine>>(
        listOf(
            Wine(
                id = 0,
                name = "Chardonnay",
                price = 30.50
            ),
            Wine(
                id = 1,
                name = "Chardonnay2",
                price = 31.50
            )
        )
    )

    private var _id = 2

    val wines: LiveData<List<Wine>> = _wines

    fun onRemoveWine(id: Int) {
        _wines.value = _wines.value?.filter { it.id != id }
    }

    fun onCreateWine(name: String, price: Double){
        _wines.value = _wines.value?.plus(Wine(id = _id, name=name, price=price))
        _id += 1
    }

    fun onEditWine(id: Int, name: String, price: Double){
        onRemoveWine(id)
        _wines.value = _wines.value?.plus(Wine(id = id, name=name, price=price))
    }

    fun find(id: Int): Wine {
        return _wines.value?.find { it.id == id }!!
    }


}
