package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entites.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_dialog_shopping_item)

        findViewById<TextView>(R.id.tvAdd)?.setOnClickListener {
            val name = findViewById<EditText>(R.id.etName)?.text.toString()
            val amount = findViewById<EditText>(R.id.etAmount)?.text.toString()

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.addOnButtonClicked(item)
            dismiss()
        }
        findViewById<TextView>(R.id.tvCancel)?.setOnClickListener {
            cancel()
        }
    }
}