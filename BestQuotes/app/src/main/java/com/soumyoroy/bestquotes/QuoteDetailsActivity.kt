package com.soumyoroy.bestquotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quote_details.*

class QuoteDetailsActivity : AppCompatActivity() {

    var quoteCategoryId:Int = 0
    var db:SQLiteDatabase? = null
    var cursor:Cursor? = null

    var quoteAdapter:QuoteAdapter? = null // Creating quoteAdapter object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)

        // Getting key from putExtra method
        quoteCategoryId = intent.extras!!.get("QUOTE_CATEGORY_ID").toString().toInt()
        // Showing toast message
        Toast.makeText(this, "You have clicked on $quoteCategoryId", Toast.LENGTH_SHORT).show()

        // Reading Data from database
        val bestQuotesDatabaseHelper = BestQuotesSQLiteOpenHelper(this)
        db = bestQuotesDatabaseHelper.readableDatabase

        cursor = db!!.query(
            "quotes",
            arrayOf("quote"),
            "category_id=?",
            arrayOf(quoteCategoryId.toString()),
            null, null, null
        )

        // Creating a list of quotes
        val listOfQuotes = mutableListOf<String>()

        // Iterating through the data of the cursor
        while (cursor!!.moveToNext()){
            val quote = cursor!!.getString(0)
            listOfQuotes.add(quote)
        }

        // Creating an Adapter object from QuoteAdapter class
        quoteAdapter = QuoteAdapter(this, listOfQuotes){quote ->

            // Creating the body of onLongItemClick() function
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, quote)
            shareIntent.type = "text/plain"
            startActivity(shareIntent)
        }

        // Using a Layout Manager
        val layoutManager = LinearLayoutManager(this)

        // Setting Adapter and Layout Manager to the Recycler View
        recyclerViewQuotes.layoutManager = layoutManager
        recyclerViewQuotes.adapter = quoteAdapter
    }

    override fun onDestroy() {
        super.onDestroy()

        // Closing database and cursor
        db!!.close()
        cursor!!.close()
    }
}
