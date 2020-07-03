package com.soumyoroy.bestquotes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BestQuotesSQLiteOpenHelper(context:Context): SQLiteOpenHelper (context, null, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        // Writing code for creating tables inside our database
        db!!.execSQL("CREATE TABLE quote_categories("+
                "_id INTEGER PRIMARY KEY,"+
                "image_resource_id TEXT,"+
                "name TEXT"+
                ")")

        // Adding Quote Categories and Images
        insertQuoteCategory(db, 1, R.drawable.love, "প্রেমের উক্তি")
        insertQuoteCategory(db, 2, R.drawable.sad, "দুঃখের উক্তি")
        insertQuoteCategory(db, 3, R.drawable.romantic, "রোমন্টিক উক্তি")
        insertQuoteCategory(db, 4, R.drawable.childhood, "ছোটবেলার উক্তি")
        insertQuoteCategory(db, 5, R.drawable.success, "সাফল্যের উক্তি")
        insertQuoteCategory(db, 6, R.drawable.marriage, "বিবাহের উক্তি")
        insertQuoteCategory(db, 7, R.drawable.alone, "একাকিত্বের উক্তি")
        insertQuoteCategory(db, 8, R.drawable.birthday, "জন্মদিনের উক্তি")

        // Creating another table for holding quotes
        db!!.execSQL("CREATE TABLE quotes("+
                "quote TEXT,"+
                "category_id INTEGER"+
                ")")

        // Adding data into table


        // For Category id: 1 and category name: LOVE
        insertQuote(db, "তোমার হয়ে আছি আমি’ তোমার হয়ে থাকবো\n" +
                "সারা জীবন তোমায় আমি ভালবেসে যাবো\n" +
                "পাশে থেকো সারা জীবন দুরে যেয়ো না\n" +
                "তোমায় ছারা একটুও আমার’ ভালো লাগে না ", 1)
        insertQuote(db, "কাউকে আবেগের ভালোবাসা দিওনা, মনের ভালোবাসা দিও !\n" +
                "কারন আবেগের ভালোবাসা একদিন বিবেকের কাছে হেরে যাবে আর মনের ভালোবাসা চিরদিন থেকে যাবে… ", 1)
        insertQuote(db, "আমি যদি চলে যাই’ নীল আকাশের কাছে~\n" +
                "~আমায় তুমি খুজে নিয়ো’ সন্ধা তারার মাঝে~\n" +
                "~একা যদি লাগে তোমার’ মনে রেখো আমায়~\n" +
                "~দক্ষিনা বাতাস হয়ে আমি’ ছুয়ে দিবো তোমায়~ ", 1)
        insertQuote(db, "অনেক দিন পর তোমাকে দেখলাম তোমাকে দেখে থমকে দারিয়ে ছিলাম\n" +
                "আমি খুব কষ্টে নিজেকে সামলে নিলামযখন তুমি আমাকে দেখে না দেখার ভান করলে\n" +
                "তখন আমার দারুন লেগেছে তোমাকে সেই অনুভুতির কথা বলে বুঝাতে পারবো না_ ", 1)
        insertQuote(db, "তোমার হয়ে আছি আমি’ তোমার হয়ে থাকবো~\n" +
                "~সারা জীবন তোমায় আমি’ ভালবেসে যাবো~\n" +
                "~পাশে থেকো সারা জীবন’ দুরে যেয়ো না~\n" +
                "~তোমায় ছারা একটুও আমার’ ভালো লাগে না~ ", 1)
        insertQuote(db, "আমার জীবনে কেউ নেই তুমি ছাড়া,\n" +
                "আমার জীবনে কোন স্বপ্ন নেই তুমি ছাড়া,\n" +
                "আমার দুচোখ কিছু খোজেনা তোমায় ছাড়া,\n" +
                "আমি কিছু ভাবতে পারিনা তোমায় ছাড়া,\n" +
                "আমি কিছু লিখতে পারিনা তোমার নাম ছাড়া,\n" +
                "আমি কিছু বুঝতে চাইনা তোমায় ছাড়া !", 1)

    }

    // Creating method to insert quote
    fun insertQuote(db: SQLiteDatabase?, quote: String, categoryId: Int){
        val contentValues = ContentValues()

        // Putting values using .put() method
        contentValues.put("quote", quote)
        contentValues.put("category_id", categoryId)

        // Executing insert method in the database
        db!!.insert("quotes", null, contentValues)
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