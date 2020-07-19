package pl.nojkir.soppinglist.ui.shoppinglist

import pl.nojkir.soppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked (item : ShoppingItem)
}