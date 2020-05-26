package com.soumyoroy.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating seekbar functionality

        // For Tip Percent
        seekBarTipPercent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekbarPercentText.text = progress.toString()+" %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // For No of People

        // SeekBar Range
        var MIN = 1

        seekBarNoOfPeople.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (progress < MIN){
                    seekBar?.progress = MIN
                }

                else if (progress >= MIN){
                    seekbarNoOfPeopleText.text = progress.toString()
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })


        // Creating a Button click function
        calculateBtn.setOnClickListener {
            if (editTextBillAmount.text.isEmpty()){
                Toast.makeText(applicationContext, "Enter the Bill Amount First", Toast.LENGTH_SHORT).show()
            }
            else {
                // Getting Bill Amount
                var billAmount = editTextBillAmount.text.toString().toInt()

                // Getting tip percent
                var tipPercent = seekBarTipPercent.progress

                // Calculating tip amount
                var tipAmount = (billAmount * tipPercent) / 100

                // Calculating total payment
                var totalPayment = billAmount + tipAmount

                // Adding no of people
                var noOfPeople = seekBarNoOfPeople.progress

                // Calculating splitted amount
                var splittedAmount = totalPayment / noOfPeople

                // Display the result
                // totalPaymentText.text = "Total Amount: ₹"+totalPayment+"\nTip Amount: ₹"+tipAmount+"\nSplitted Amount: ₹"+splittedAmount // This is method 1 ( By using concatenating )
                totalPaymentText.text = "Total Amount: ₹${totalPayment}\nTip Amount: ₹${tipAmount}\nSplitted Amount: ₹${splittedAmount}" // This is method 2 ( By using placeholder )
                // We have to use dollar sign ($) in order to use placeholder
            }

        }

    }
}
