package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entites.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_items, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvName).text = items[position].name
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = items[position].amount.toString()
        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewModel.delete(items[position])
        }
        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener {
            items[position].amount++
            viewModel.upsert(items[position])
        }
        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener {
            if(items[position].amount > 0){
                items[position].amount--
                viewModel.upsert(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}