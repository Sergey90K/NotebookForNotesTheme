package com.example.notebookfornotestheme.ui.item

import com.example.notebookfornotestheme.R
import com.example.notebookfornotestheme.ui.navigation.NavigationDestination

object ItemDetailsDestination : NavigationDestination {
    override val route = "item_details"
    override val titleRes = R.string.item_detail_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}