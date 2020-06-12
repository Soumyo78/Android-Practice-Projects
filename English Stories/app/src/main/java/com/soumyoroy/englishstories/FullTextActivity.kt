package com.soumyoroy.englishstories

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_full_text.*
import kotlinx.android.synthetic.main.content_full_text.*

class FullTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_text)
        setSupportActionBar(toolbar)

        // Reading extra values from Main Activity
        val itemIndex = intent.extras?.get("ITEM_INDEX").toString().toInt()

        // Setting the titles and full texts
        title = Data.stories[itemIndex].title
        textViewStoryFullText.setText(Data.stories[itemIndex].fullText)
    }
}
