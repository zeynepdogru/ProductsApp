package com.zeynepdogru.productsapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zeynepdogru.productsapp.R
import com.zeynepdogru.productsapp.databinding.ItemProductBinding
import com.zeynepdogru.productsapp.model.Product

class ProductAdapter(var productList: ArrayList<Product>) :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(var view: ItemProductBinding): RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       var inflater=LayoutInflater.from(parent.context)
        var view=DataBindingUtil.inflate<ItemProductBinding>(inflater, R.layout.item_product,parent,false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.view.titleTV.text= productList[position].title
        holder.view.priceTV.text= productList[position].price.toString()

        Glide.with(holder.view.root).load(productList[position].productImage).into(holder.view.productIV)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Product>){
        productList=newList as ArrayList<Product>
        notifyDataSetChanged()
    }
}