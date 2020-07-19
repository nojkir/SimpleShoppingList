package pl.nojkir.soppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.nojkir.soppinglist.data.db.entities.ShoppingItem
import pl.nojkir.soppinglist.data.repositories.ShoppingRepository

class ShoppingViewModel (
    private val repository: ShoppingRepository
):ViewModel(){

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}