package com.example.fiap_sprint.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fiap_sprint.models.Wine

@Database(
    entities = [Wine::class],  // Correct entity
    version = 2
)
abstract class ConnDb: RoomDatabase() {
    abstract fun wineDao(): WineDao

    companion object {

        private lateinit var instance: ConnDb

        fun getDatabase(context: Context): ConnDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        ConnDb::class.java,
                        "conn_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance

        }
    }
}

