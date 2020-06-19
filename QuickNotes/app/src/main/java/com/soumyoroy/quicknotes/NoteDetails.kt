package com.soumyoroy.quicknotes

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetails : AppCompatActivity() {

    var db:SQLiteDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val quickNotesDatabaseHelper = QuickNotesSQLiteOpenHelper(this)
        db = quickNotesDatabaseHelper.writableDatabase // Creating a writable connection
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item!!.itemId == R.id.save_note){

            // Inserting new notes
            val newNoteValues = ContentValues()

            // Checking the title is empty or not
            if (editTextTitle.text.isEmpty()){
                newNoteValues.put("TITLE", "Untitled")
            }
            else{
                newNoteValues.put("TITLE", editTextTitle.text.toString())
            }

            newNoteValues.put("DESCRIPTION", editTextDescription.text.toString())

            db!!.insert("notes", null, newNoteValues)
            Toast.makeText(this, "Note saved Successfully", Toast.LENGTH_SHORT).show()

            // Clearing the edit texts
            editTextTitle.setText("")
            editTextDescription.setText("")

            // Shifting the focus to editTextTitle after clearing
            editTextTitle.requestFocus()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_details_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()

        db!!.close()
    }
}
