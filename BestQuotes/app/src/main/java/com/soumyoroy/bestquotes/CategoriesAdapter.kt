package com.soumyoroy.bestquotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(val context:Context, val categories:List<Category>, val onItemClick:(Int)->Unit): RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    // This inner class will be used to either create or recycle views
    inner class MyViewHolder(itemView: View, val onItemClick: (Int) -> Unit):RecyclerView.ViewHolder(itemView){

        // Finding and extracting imageview and textview inside item_view
        val categoryImage = itemView!!.findViewById<ImageView>(R.id.imageViewCategoryImage)
        val categoryName = itemView!!.findViewById<TextView>(R.id.textViewCategoryName)

        // This method is used to bind data
        fun bindData(category:Category, context:Context){

            // Binding data to imageview and textview
            categoryImage.setImageResource(category.resourceId)
            categoryName.text = category.name

            // Creating a click listener for recycler view
            itemView.setOnClickListener {
                onItemClick(category.id)
            }
        }
    }

    // It will create new instance from cardview layout or recycle an existing one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // Creating view object
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        val myViewHolder = MyViewHolder(view, onItemClick)

        return myViewHolder
    }

    // It returns number of items in data source
    override fun getItemCount(): Int {
        return categories.count()
    }

   // Calling bindData() function for binding data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder!!.bindData(categories[position], context)
    }
}