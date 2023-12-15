package com.example.notebookfornotestheme

import android.app.Application
import com.example.notebookfornotestheme.data.AppContainer
import com.example.notebookfornotestheme.data.AppDataContainer

class NotebookForNotesApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}