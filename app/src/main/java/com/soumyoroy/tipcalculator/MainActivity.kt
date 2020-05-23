package com.soumyoroy.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating seekbar functionality
        seekBarTipPercent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekbarPercentText.text = progress.toString()+" %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })


        // Creating a Button click function
        calculateBtn.setOnClickListener {
            // Getting Bill Amount
            var billAmount = editTextBillAmount.text.toString().toInt()

            // Getting tip percent
            var tipPercent = seekBarTipPercent.progress

            // Calculating tip amount
            var tipAmount = (billAmount * tipPercent) / 100

            // Calculating total payment
            var totalPayment = billAmount + tipAmount

            // Display the result
            totalPaymentText.text = "Total Amount: ₹"+totalPayment+"\nTip Amount: ₹"+tipAmount
        }

    }
}
