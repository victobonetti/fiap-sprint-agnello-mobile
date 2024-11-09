package com.example.fiap_sprint

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WineViewModel : ViewModel() {
    private val _wines = MutableLiveData<List<Wine>>(
        listOf(
            Wine(
                id = "1",
                name = "Chardonnay",
                price = 30.50
            )
        )
    )
    val wines: LiveData<List<Wine>> = _wines

    fun onRemoveWine(id: String) {
        _wines.value = _wines.value?.filter { it.id != id }
    }

}
