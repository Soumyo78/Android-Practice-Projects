package com.soumyoroy.bestquotes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BestQuotesSQLiteOpenHelper(context:Context): SQLiteOpenHelper (context, "BestQuotesDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        // Writing code for creating tables inside our database
        db!!.execSQL("CREATE TABLE quote_categories("+
                "_id INTEGER PRIMARY KEY,"+
                "image_resource_id TEXT,"+
                "name TEXT"+
                ")")

        // Adding Quote Categories and Images
        insertQuoteCategory(db, 1, R.drawable.love, "Love")
        insertQuoteCategory(db, 2, R.drawable.sad, "Sad")
        insertQuoteCategory(db, 3, R.drawable.romantic, "Romantic")
        insertQuoteCategory(db, 4, R.drawable.childhood, "Childhood")
        insertQuoteCategory(db, 5, R.drawable.success, "Success")
        insertQuoteCategory(db, 6, R.drawable.marriage, "Marriage")
        insertQuoteCategory(db, 7, R.drawable.alone, "Alone")
        insertQuoteCategory(db, 8, R.drawable.birthday, "Birthday")

    }

    // Creating method to insert quote category
    fun insertQuoteCategory(db:SQLiteDatabase?, id: Int, resourceId: Int, name: String){
        val contentValues = ContentValues()

        // Putting values using .put() method
        contentValues.put("_id", id)
        contentValues.put("image_resource_id", resourceId)
        contentValues.put("name", name)

        // Executing insert method in the database
        db!!.insert("quote_categories", null, contentValues)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}