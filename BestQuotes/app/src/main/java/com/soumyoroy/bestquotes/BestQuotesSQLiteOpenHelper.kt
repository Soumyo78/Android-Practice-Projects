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
        insertQuoteCategory(db, 1, R.drawable.love, "ভালোবাসার উক্তি")
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
                "আমায় তুমি খুজে নিয়ো’ সন্ধা তারার মাঝে\n" +
                "একা যদি লাগে তোমার’ মনে রেখো আমায়\n" +
                "দক্ষিনা বাতাস হয়ে আমি’ ছুয়ে দিবো তোমায়", 1)
        insertQuote(db, "অনেক দিন পর তোমাকে দেখলাম তোমাকে দেখে থমকে দারিয়ে ছিলাম\n" +
                "আমি খুব কষ্টে নিজেকে সামলে নিলামযখন তুমি আমাকে দেখে না দেখার ভান করলে\n" +
                "তখন আমার দারুন লেগেছে তোমাকে সেই অনুভুতির কথা বলে বুঝাতে পারবো না", 1)
        insertQuote(db, "তোমার হয়ে আছি আমি’ তোমার হয়ে থাকবো~\n" +
                "সারা জীবন তোমায় আমি’ ভালবেসে যাবো~\n" +
                "পাশে থেকো সারা জীবন’ দুরে যেয়ো না~\n" +
                "তোমায় ছারা একটুও আমার’ ভালো লাগে না", 1)
        insertQuote(db, "আমার জীবনে কেউ নেই তুমি ছাড়া,\n" +
                "আমার জীবনে কোন স্বপ্ন নেই তুমি ছাড়া,\n" +
                "আমার দুচোখ কিছু খোজেনা তোমায় ছাড়া,\n" +
                "আমি কিছু ভাবতে পারিনা তোমায় ছাড়া,\n" +
                "আমি কিছু লিখতে পারিনা তোমার নাম ছাড়া,\n" +
                "আমি কিছু বুঝতে চাইনা তোমায় ছাড়া !", 1)

        // For Category id: 2 and category name: SAD
        insertQuote(db, "বিশ্বাস তো শুধু তাকেই করা যায়\n" +
                "যে বিশ্বাস এর যোগ্য হয়\n" +
                "তাকে কি করে বিশ্বাস করবো\n" +
                "যে বিশ্বাস এর যোগ্যই নয়",2)
        insertQuote(db, "আজ আর মনে পড়ে না তোমার ওই কথা\n" +
                "আজ জীবনে খুশি আছি, ভুলে পুরোনো সব ব্যাথা\n" +
                "আর কোনো দিন ফিরে যাবো না পুরোনো সেই জীবনে\n" +
                "নতুন করে চিনতে পেরেছি আজ আমি নিজেকে",2)
        insertQuote(db, "আমার কি ভুল ছিলো একবার আমায় বলবে\n" +
                "যার জন্য এতো বড়ো শাস্তি দিচ্ছ আমাকে\n" +
                "আজ ও তুমি চিনতে পারলে না নিজেকে\n" +
                "তবে আমাকে তুমি কি করে চিনবে",2)
        insertQuote(db, "কে বলেছে ছেলেরা কাঁদে না\n" +
                "কে বলেছে ছেলেরা কষ্ট পায় না\n" +
                "মানুষ বলতেই সবার কষ্ট হয়\n" +
                "সেই কষ্টে সবাই কাঁদে\n" +
                "আমিও তো একটা মানুষ",2)
        insertQuote(db, "জীবনে সুযোগ তারাই পায়\n" +
                "যারা সুযোগ এর মানেটা বোঝে\n" +
                "তারা কি করে সুযোগ পাবে\n" +
                "যারা সুযোগ এর মানেটাই বোঝে না",2)
        insertQuote(db, "আজ জানিনা তুমি কোথায় আছো\n" +
                "চাইলেও হয়তো তোমাকে খুঁজে পাবো না\n" +
                "যেখানেই থাকো না কেনো খুশি থাকো\n" +
                "আর কোনো দিন তোমার কাছে যাবো না",2)

        // For Category id: 3 and category name: ROMANTIC
        insertQuote(db, "মন খারাপেরা আজ ছুটি নিয়েছে, রাস্তাতেও বেশ ভিড়,\n" +
                "তাইতো আর তোমায় খুঁজতে যাই না, পছন্দ যে সেই শূন্য নীড়\n" +
                "– লীনা দাস", 3)
        insertQuote(db, "আমার প্রেম নীরব হলেও অনুভূতি গুলো সজীব\n" +
                "– দেবশ্রী", 3)
        insertQuote(db, "অতীতের ক্যানভাসে তাকিয়ে দেখি ছবি গুলো সব সাদা,\n" +
                "কালো আর ধূসর। আর ভবিষ্যত? সে তো তুই রঙিন করে এঁকেছিস\n" +
                "– ঋতম", 3)
        insertQuote(db, "আহারে নরম আবির,\n" +
                "তোর ছোঁয়া রাঙায়ে যখন গাল\n" +
                "ছোঁয়া লাগে মনের অন্তরালেও\n" +
                "কোথাও বাজে হারিয়ে যাওয়া তাল।\n" +
                "-শতরূপা ", 3)
        insertQuote(db, "বৃষ্টি হলে খবর দিস,\n" +
                "হাঁটবো দু’জন একটি ছাতায়।\n" +
                "খালি পায়ে শহর ঘুরে\n" +
                "বৃষ্টি ভেজা প্রেমের গল্প\n" +
                "লিখে রাখব ডায়েরির পাতায়\n" +
                "– সৌম্যজ্যোতি রায়", 3)
        insertQuote(db, "মন আজ কিছু চায়, চায় শুধু কিছু পেতে,\n" +
                "ভুলবো না তোমার কথা, চাই শুধু তোমায় পেতে,\n" +
                "ভাবনা ছিল এক পথ হাঁটবো এক সাথে,\n" +
                "তবুও দু’জনে একসাথে হওয়ার স্বপ্ন দেখি এই রাতে।\n" +
                "– অন্তরীপ", 3)

        // For Category id: 4 and category name: CHILDHOOD
        insertQuote(db, "একটা শিশু অশিক্ষিত থাকার অর্থ, একটা শিশুকে হারিয়ে ফেলা", 4)
        insertQuote(db, "একটা খারাপ জ্যাকেটকে তাও সারানো যেতে পারে কিন্তু একটা কঠিন শব্দ,\n" +
                "কোনো বাচ্চার হৃদয়কে কষ্ট দিতে পারে", 4)
        insertQuote(db, "সবচেয়ে সুন্দর উপহার যা আপনি আপনার সন্তানকে দিতে পারেন তা হলো,\n" +
                "ছোট থেকেই দায়িত্ববোধ ও দ্বিতীয় হলো স্বাধীনতা", 4)
        insertQuote(db, "একটা শিশু এমন প্রশ্ন জিজ্ঞাসা করতে পারে,\n" +
                "যা একজন মহাজ্ঞানী মানুষের কাছেও উত্তর দেওয়া কঠিন হয়ে দাড়ায়", 4)
        insertQuote(db, "যদি আপনি চান আপনার সন্তান বুদ্ধিমান হোক,\n" +
                "তাহলে তাকে রূপকথার গল্প পড়ান | আর যদি আপনার সন্তানকে আপনি আরো বুদ্ধিমান করতে চান,\n" +
                "তাহলে আরো বেশি করে রূপকথার গল্প পড়ান", 4)
        insertQuote(db, "কোনো মানুষই শিশুদের দয়ালুভাব,\n" +
                "সহানুভূতি ও উদার মানসিকতা সম্পর্কে স্পষ্ঠভাবে বুঝে উঠতে পারেনি |\n" +
                "প্রত্যেক সত্য শিক্ষার প্রচেষ্টা, এই গুপ্তধন গুলোকে পাওয়ার দরজাকে খুলে দিতে পারে", 4)

        // For Category id: 5 and category name: SUCCESS
        insertQuote(db, "শুধু দাঁড়িয়ে নদী দেখতে থাকলে আপনি কোনদিনও সেই নদী পার করতে পারবেন না,\n" +
                "পার করতে হলে আপনাকে অবশ্যই সঠিক পদক্ষেপ নিতে হবে", 5)
        insertQuote(db, "এটা কোনো বেপারই না যে আপনি কত ভুল করছেন বা আপনি কত ধীর গতিতে প্রগতি করছেন,\n" +
                "আপনি এখনো ওইসব মানুষগুলির থেকে এগিয়ে যারা কোনদিন চেষ্টাও করেনা কিছু করার", 5)
        insertQuote(db, "Give Up করার মানে কিন্তু সবসময় এটা না যে আপনি খুব দুর্বল প্রকৃতির,\n" +
                "এর মানে আপনি অনেক শক্তিশালী এবং অনেক বুদ্ধিমান যে সেইসব ছেড়ে দিয়ে আগে অগ্রসর হতে চায়", 5)
        insertQuote(db, "আপনি যদি নিজের জীবনকে নিজের মত করে কাটাতে চান\n" +
                "তাহলে কোনদিনও কারোর বেশি ভক্ত (Fan) হতে যাবেন না", 5)
        insertQuote(db, "যতক্ষণ আপনি অন্যদের; নিজের সমস্যা এবং কঠিন পরিস্থিতির জন্য দায়ী বলে মনে করবেন\n" +
                "ততক্ষণ আপনি আপনার সমস্যা এবং কঠিন পরিস্থিতি গুলিকে দূর করতে একদমই পারবেন না", 5)
        insertQuote(db, "সফলতা আমাদের পরিচয় দুনিয়ার কাছে করায় কিন্তু অসফলতা আমাদের দুনিয়ার পরিচয় করায়", 5)

        // For Category id: 6 and category name: MARRIAGE
        insertQuote(db, "", 6)
        insertQuote(db, "", 6)
        insertQuote(db, "", 6)
        insertQuote(db, "", 6)
        insertQuote(db, "", 6)
        insertQuote(db, "", 6)

        // For Category id: 7 and category name: ALONE
        insertQuote(db, "", 7)
        insertQuote(db, "", 7)
        insertQuote(db, "", 7)
        insertQuote(db, "", 7)
        insertQuote(db, "", 7)
        insertQuote(db, "", 7)

        // For Category id: 8 and category name: BIRTHDAY
        insertQuote(db, "\n" +
                "কতো বছর পেরিয়ে গেলো\n" +
                "আজ শুভ দিন চলে এলো\n" +
                "আজকের দিনে থাকবেনা কোনো ঋণ\n" +
                "তোমায় আমি জানাই শুভ জন্মদিন", 8)
        insertQuote(db, " কতো পুরোনো স্মৃতি মনে ভাসে\n" +
                "কতো স্বপ্ন যত্নে রেখেছি মনের ও পাশে\n" +
                "কতো কথা বলেছি তোমাকে\n" +
                "বন্ধু ভেবে সাথে রেখেছো আমাকে\n" +
                "-----------হ্যাপি বার্থডে-----------", 8)
        insertQuote(db, " মুখের ও অনেক ভাষায় রয়েছে অনেক আশা\n" +
                "সবার আগে জানাই তোমায় আমার ভালোবাসা\n" +
                "কিছু কথা বাকি আছে, বাকি আছে অনেক ইচ্ছা\n" +
                "তার পর জানাই তোমায় জন্ম দিনের অনেক শুভেচ্ছা\n", 8)
        insertQuote(db, " খুশির গান গাইবো এক সাথে\n" +
                "ছেড়ে দিওনা হাতটা, রেখো আমার হাতে\n" +
                "সারাজীবন তোমার পাশে এভাবেই থাকবো\n" +
                "একসাথে সারাজীবন আমরা ভালোবাসবো\n" +
                "-----------হ্যাপি বার্থডে 2U-----------", 8)
        insertQuote(db, "থাকবেনা কোনো আসা, থাকবে শুধু ভালোবাসা\n" +
                "চলবো একি পথে, থাকবেনা কোনো ঋণ, কাটবে সারাদিন\n" +
                "এই শুভ দিনে জানাই তোমায়, তোমার শুভ জন্মদিন\n", 8)
        insertQuote(db, "\n" +
                "বাগানে ফুটে আছে কতো গোলাপ জুঁই\n" +
                "হাজার লোকের মাঝে মনে বাসা করে থাকবি যে শুধু তুই\n" +
                "তোর টানেতে ঘরে মন থেকে না\n" +
                "ছুট্টে যে যাই তোর কাছে\n" +
                "ভালোলাগে যখন তুই থাকিস আমার খুব পাশে\n" +
                "(*Many many happy returns of the day*)\n", 8)
    }

    // Creating method to insert quote
    private fun insertQuote(db: SQLiteDatabase?, quote: String, categoryId: Int){
        val contentValues = ContentValues()

        // Putting values using .put() method
        contentValues.put("quote", quote)
        contentValues.put("category_id", categoryId)

        // Executing insert method in the database
        db!!.insert("quotes", null, contentValues)
    }

    // Creating method to insert quote category
    private fun insertQuoteCategory(db:SQLiteDatabase?, id: Int, resourceId: Int, name: String){
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