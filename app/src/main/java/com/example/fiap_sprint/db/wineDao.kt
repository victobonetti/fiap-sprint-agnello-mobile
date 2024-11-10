package com.example.fiap_sprint.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fiap_sprint.models.Wine

@Dao
interface WineDao {

    @Insert
    fun salvar(wine: Wine)

    @Update
    fun atualizar(wine: Wine)

    @Query("DELETE FROM t_wine WHERE id = :id")
    fun excluir(id: Int)

    @Query("SELECT * FROM t_wine WHERE id = :id")
    fun getWineById(id: Int): Wine

    @Query("SELECT * FROM t_wine ORDER BY name ASC")
    fun listWines(): List<Wine>
}

