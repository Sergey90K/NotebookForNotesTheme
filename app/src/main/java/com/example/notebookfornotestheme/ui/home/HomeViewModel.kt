package com.example.notebookfornotestheme.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebookfornotestheme.data.Item
import com.example.notebookfornotestheme.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    suspend fun markAsDone(step: Int) {
        viewModelScope.launch {
            val currentItem = homeUiState.value.itemList[step]
            if (!currentItem.done) {
                itemsRepository.updateItem(currentItem.copy(done = true))
            } else {
                itemsRepository.updateItem(currentItem.copy(done = false))
            }
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val itemList: List<Item> = listOf())