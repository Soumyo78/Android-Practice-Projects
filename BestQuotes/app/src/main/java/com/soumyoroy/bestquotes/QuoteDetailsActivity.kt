package com.soumyoroy.bestquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class QuoteDetailsActivity : AppCompatActivity() {

    var quoteCategoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)

        quoteCategoryId = intent.extras!!.get("QUOTE_CATEGORY_ID").toString().toInt()
        Toast.makeText(this, "You have clicked on ${quoteCategoryId.toString()}", Toast.LENGTH_SHORT).show()
    }
}
