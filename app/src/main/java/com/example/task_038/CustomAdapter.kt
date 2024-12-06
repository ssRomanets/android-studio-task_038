package com.example.task_038

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val products: MutableList<Product>):
    RecyclerView.Adapter<CustomAdapter.ProductViewHolder>(){

    private var onProductClickListener: OnProductClickListener? = null

    interface OnProductClickListener {
        fun onProductClick(product: Product, position: Int)
    }

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageViewIV: ImageView = itemView.findViewById(R.id.imageViewIV)
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val priceTV: TextView = itemView.findViewById(R.id.priceTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.imageViewIV.setImageResource(product.image)
        holder.nameTV.text = product.name
        holder.priceTV.text = product.price.toString()
        holder.itemView.setOnClickListener{
            if (onProductClickListener != null) {
                onProductClickListener!!.onProductClick(product, position)
            }
        }
    }

    fun setOnProductClickListener(onProductClickListener: OnProductClickListener) {
        this.onProductClickListener = onProductClickListener
    }
}