package com.soumyoroy.quicknotes

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetails : AppCompatActivity() {

    var db:SQLiteDatabase? = null
    var noteId:Int = 0
    var cursor:Cursor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val quickNotesDatabaseHelper = QuickNotesSQLiteOpenHelper(this)
        db = quickNotesDatabaseHelper.writableDatabase // Creating a writable connection

        noteId = intent.extras!!.get("NOTE_ID").toString().toInt()

        // Reading a Note title and description that its _id is equal to noteId
        if (noteId != 0){
            cursor = db!!.query(
                "notes",
                arrayOf("TITLE", "DESCRIPTION"),
                "_id=?",
                arrayOf(noteId.toString()),
                null, null, null
            )
            // Using moveToFirst method to process the cursor
            if (cursor!!.moveToFirst()){
                editTextTitle.setText(cursor!!.getString(0))
                editTextDescription.setText(cursor!!.getString(1))
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Saving a note
        if (item!!.itemId == R.id.save_note){

            // Inserting new notes
            val newNoteValues = ContentValues()

            // Checking the title is empty or not
            if (editTextTitle.text.isEmpty()) {
                newNoteValues.put("TITLE", "Untitled")
            } else {
                newNoteValues.put("TITLE", editTextTitle.text.toString())
            }

            newNoteValues.put("DESCRIPTION", editTextDescription.text.toString())

            // Updating a note
            if (noteId == 0)
                insertNote(newNoteValues)
            else
                updateNote(newNoteValues)
        }

        // Deleting an existing note
        else if (item!!.itemId == R.id.delete_note){
            deleteNote()
        }

        return super.onOptionsItemSelected(item)
    }

    // Creating Delete Note Function
    private fun deleteNote(){

        // Display Alert Dialog Message Before Deleting a Note
        var dialog:AlertDialog
        val builder = AlertDialog.Builder(this)

        // Setting a title for alert dialog
        builder.setTitle("Deleting Note")

        // Setting a message for alert dialog
        builder.setMessage("Are You sure you want to delete '${editTextTitle.text}' ?")

        // Setting alert dialog buttons

        // Setting positive button (Yes)
        builder.setPositiveButton("YES", dialogClickListener)

        // Setting neutral button (Cancel)
        builder.setNeutralButton("CANCEL", dialogClickListener)

        // Initializing alert dialog by builder object
        dialog = builder.create()

        // Displaying the Dialog
        dialog.show()
    }

    // Creating YES Alert click listener method
    private val dialogClickListener = DialogInterface.OnClickListener { _, which ->
        if (which == DialogInterface.BUTTON_POSITIVE){
            db!!.delete("notes", "_id=?", arrayOf(noteId.toString()))
            Toast.makeText(this, "Note Deleted Successfully", Toast.LENGTH_SHORT).show()

            // Closing NOte Details Activity
            finish()
        }
    }


    // Creating Update Note Function
    private fun updateNote(noteValues:ContentValues){

        db!!.update("notes", noteValues, "_id=?", arrayOf(noteId.toString()))
        Toast.makeText(this, "Note Updated Successfully", Toast.LENGTH_SHORT).show()
    }

    // Creating Insert Note Function
    private fun insertNote(newNoteValues:ContentValues) {

        db!!.insert("notes", null, newNoteValues)
        Toast.makeText(this, "Note saved Successfully", Toast.LENGTH_SHORT).show()

        // Clearing the edit texts
        editTextTitle.setText("")
        editTextDescription.setText("")

        // Shifting the focus to editTextTitle after clearing
        editTextTitle.requestFocus()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_details_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()

        db!!.close()
        cursor!!.close()
    }
}
