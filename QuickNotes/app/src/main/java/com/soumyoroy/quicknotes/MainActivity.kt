package com.soumyoroy.quicknotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db:SQLiteDatabase?= null
    var cursor:Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Open the Note Details Activity
        fabAtNote.setOnClickListener{
            val intent = Intent(this, NoteDetails::class.java)
            startActivity(intent)
        }

        // Creating data source
        var objToCreateDB = QuickNotesSQLiteOpenHelper(this) // Creating database and table
        db = objToCreateDB.readableDatabase // Accessing the database (readable only)

        // Defining cursor
        cursor = db!!.query("notes", arrayOf("_id", "title"), // Reading data
        null, null, null, null, null )

        // Creating adapter
        val listAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
        cursor,
        arrayOf("title"),
        intArrayOf(android.R.id.text1),
        0
        )

        // Setting adapter view
        listViewNotes.adapter = listAdapter
    }

    // Overriding onDestroy() method to destroy unused activities when another activities will be opened
    override fun onDestroy() {
        super.onDestroy()
        cursor!!.close() // Closing the cursor
        db!!.close() // Closing the database
    }
}
