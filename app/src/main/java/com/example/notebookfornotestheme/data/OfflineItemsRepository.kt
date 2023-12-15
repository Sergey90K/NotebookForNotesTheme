package com.example.notebookfornotestheme.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> {
       return itemDao.getAllItems()
    }

    override fun getItemStream(id: Int): Flow<Item?> {
        return itemDao.getItem(id)
    }

    override suspend fun insertItem(item: Item) {
      return itemDao.insert(item)
    }

    override suspend fun deleteItem(item: Item) {
        return itemDao.delete(item)
    }

    override suspend fun updateItem(item: Item) {
        return itemDao.update(item)
    }
}