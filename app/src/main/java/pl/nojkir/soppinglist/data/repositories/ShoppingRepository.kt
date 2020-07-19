package pl.nojkir.soppinglist.data.repositories

import pl.nojkir.soppinglist.data.db.ShoppingDataBase
import pl.nojkir.soppinglist.data.db.entities.ShoppingItem

class ShoppingRepository (
    private val db : ShoppingDataBase
)
{
    suspend fun upsert (item : ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete (item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()
}