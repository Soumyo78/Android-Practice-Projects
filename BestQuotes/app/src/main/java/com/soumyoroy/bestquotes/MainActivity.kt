package com.soumyoroy.bestquotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db:SQLiteDatabase? = null
    var cursor:Cursor? = null
    var categoriesAdapter:CategoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating a readable connection with the database table
        val myNotesDatabaseHelper = BestQuotesSQLiteOpenHelper(this)
        db = myNotesDatabaseHelper.readableDatabase

        // Executing query operation
        cursor = db!!.query("quote_categories", arrayOf("_id", "image_resource_id", "name"),
            null, null, null, null, null)

        // Creating a mutable list
        var listOfCategories = mutableListOf<Category>()

        // Iterating through the rows of the table of our database
        while (cursor!!.moveToNext()){ // moveToNext() move the cursor to the next row

            // Getting row items in variables
            val categoryId = cursor!!.getInt(0)
            val categoryResourceId = cursor!!.getInt(1)
            val categoryName = cursor!!.getString(2)

            // Creating a category object based on the row items
            val category:Category = Category(categoryId, categoryResourceId, categoryName)

            // Inserting data to the mutable list
            listOfCategories.add(category)

        }

        // Passing the values to the adapter
        categoriesAdapter = CategoriesAdapter(this, listOfCategories){categoryId->

            // Writing the body of the onItemClick function
            val intent = Intent(this, QuoteDetailsActivity::class.java)
            intent.putExtra("QUOTE_CATEGORY_ID", categoryId)
            startActivity(intent)
        }

        // Creating the Layout Manager
        // val categoriesLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        val categoriesLayoutManager = GridLayoutManager(this, 2) // Creating Grid view

        // Setting the adapter and layout manager to the recycler view
        recyclerViewQuoteCategory.adapter = categoriesAdapter
        recyclerViewQuoteCategory.layoutManager = categoriesLayoutManager


    }

    override fun onDestroy() {
        super.onDestroy()

        // Closing the database and cursor
        db!!.close()
        cursor!!.close()
    }
}
