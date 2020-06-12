package com.soumyoroy.englishstories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating an Adapter
        val storyAdapter = ArrayAdapter<Story>(
            this, android.R.layout.simple_list_item_1,Data.stories)

        // Binding Adapter to the listview
        listViewStories.adapter = storyAdapter

        // Creating click events
        listViewStories.setOnItemClickListener {
                parent, view, position, id ->
            // Toast.makeText(this, "You have Clicked ${stories[position]}", Toast.LENGTH_SHORT).show()

            // Launching Full Text activity from main activity
            val intent = Intent(this, FullTextActivity::class.java)
            // Putting values from Main Activity to Full Text Activity
            intent.putExtra("ITEM_INDEX", position)
            startActivity(intent)
        }


    }
}
