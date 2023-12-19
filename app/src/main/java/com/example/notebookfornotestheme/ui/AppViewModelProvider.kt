package com.example.notebookfornotestheme.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notebookfornotestheme.NotebookForNotesApplication
import com.example.notebookfornotestheme.ui.home.HomeViewModel
import com.example.notebookfornotestheme.ui.item.ItemDetailsViewModel
import com.example.notebookfornotestheme.ui.item.ItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(NotebookForNotesApplication().container.itemsRepository)
        }

        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository

            )
        }

        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

    }
}

fun CreationExtras.inventoryApplication(): NotebookForNotesApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NotebookForNotesApplication)