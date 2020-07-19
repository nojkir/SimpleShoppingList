package pl.nojkir.soppinglist.other

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.shopping_item.view.*
import pl.nojkir.soppinglist.R
import pl.nojkir.soppinglist.data.db.entities.ShoppingItem
import pl.nojkir.soppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter (
    var items : List<ShoppingItem>,
private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    inner class  ShoppingViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tv_name.text = currentShoppingItem.name
        holder.itemView.tv_amount.text = "${currentShoppingItem.amount}"

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemView.iv_plus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.iv_minus.setOnClickListener {
            if (currentShoppingItem.amount > 0){
            currentShoppingItem.amount--
            viewModel.upsert(currentShoppingItem)
            }
        }
    }


}