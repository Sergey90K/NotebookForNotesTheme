package com.example.notebookfornotestheme.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notebookfornotestheme.NotebookForNotesApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(NotebookForNotesApplication().container.itemsRepository)
        }

    }
}

fun CreationExtras.inventoryApplication():  NotebookForNotesApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as  NotebookForNotesApplication)