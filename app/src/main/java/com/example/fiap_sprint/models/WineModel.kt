package com.example.fiap_sprint.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_wine")
data class Wine(
    @PrimaryKey(autoGenerate = true) var id: Int,
    val name: String,
    val price: Double)
