package com.example.notebookfornotestheme.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.notebookfornotestheme.data.ItemsRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : ViewModel() {
private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

//    val uiState: StateFlow<ItemDetailsUiState> =
//        itemsRepository.getItemStream(itemId)
//            .filterNotNull()
//            .map {
//            }
}

data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails = ItemDetails()
)