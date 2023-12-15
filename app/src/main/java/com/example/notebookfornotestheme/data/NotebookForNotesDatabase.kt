package com.example.notebookfornotestheme.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class NotebookForNotesDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: NotebookForNotesDatabase? = null

        fun getDatabase(context: Context): NotebookForNotesDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NotebookForNotesDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}