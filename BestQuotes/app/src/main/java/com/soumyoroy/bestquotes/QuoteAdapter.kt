package com.soumyoroy.bestquotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(val context:Context, val quotes:List<String>, val onItemLongClick:(String) -> Unit) : RecyclerView.Adapter<QuoteAdapter.MyViewHolder>() {

    // This inner class will be used to either create or recycle views
    inner class MyViewHolder(itemView:View, onItemLongClick: (String) -> Unit): RecyclerView.ViewHolder(itemView){

        // Finding and extracting textview inside quote_item
        val quoteTextView = itemView!!.findViewById<TextView>(R.id.quoteTextView)

        // Binding data to textview
        fun bindQuote(quote:String){
            quoteTextView.text = quote

            // Call onItemLongClick function
            itemView.setOnLongClickListener {
                onItemLongClick(quote)
                true
            }
        }

    }

    // It will create new instance from cardview layout or recycle an existing one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // Creating view object
        val view = LayoutInflater.from(context).inflate(R.layout.quote_item, parent, false)
        val myViewHolder = MyViewHolder(view, onItemLongClick)

        return  myViewHolder
    }

    // It returns number of items in data source
    override fun getItemCount(): Int {
        return quotes.count()
    }

    // Calling bindQuote() function for binding data
    override fun onBindViewHolder(viewHolder: MyViewHolder, quoteIndex: Int) {
        viewHolder!!.bindQuote(quotes[quoteIndex])
    }
}
