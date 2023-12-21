package com.example.notebookfornotestheme.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notebookfornotestheme.NotebookForNotesApplication
import com.example.notebookfornotestheme.ui.home.HomeViewModel
import com.example.notebookfornotestheme.ui.item.ItemDetailsViewModel
import com.example.notebookfornotestheme.ui.item.ItemEditViewModel
import com.example.notebookfornotestheme.ui.item.ItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(),
                notebookForNotesApplication().container.itemsRepository
            )
        }
        initializer {
            ItemEntryViewModel(notebookForNotesApplication().container.itemsRepository)
        }
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                notebookForNotesApplication().container.itemsRepository
            )
        }
        initializer {
            HomeViewModel(NotebookForNotesApplication().container.itemsRepository)
        }
    }
}

fun CreationExtras.notebookForNotesApplication(): NotebookForNotesApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as NotebookForNotesApplication)