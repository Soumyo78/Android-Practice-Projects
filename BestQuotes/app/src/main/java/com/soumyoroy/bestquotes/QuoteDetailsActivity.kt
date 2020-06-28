package com.soumyoroy.bestquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class QuoteDetailsActivity : AppCompatActivity() {

    var quoteCategoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)

        // Getting key from putExtra method
        quoteCategoryId = intent.extras!!.get("QUOTE_CATEGORY_ID").toString().toInt()
        // Showing toast message
        Toast.makeText(this, "You have clicked on ${quoteCategoryId.toString()}", Toast.LENGTH_SHORT).show()
    }
}
