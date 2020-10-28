package com.koloman212.tiptimeapp

import android.hardware.camera2.TotalCaptureResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.koloman212.tiptimeapp.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener(calculateTip())


    }

    fun calculateTip(): View.OnClickListener {
        val totalCost = binding.costOfService.text.toString()
        val tippercent = binding.tipQuestion.checkedRadioButtonId

        val cost = totalCost.toDouble()

        val tipPercentage = when (tippercent) {
            R.id.option_twenty_percent -> 20
            R.id.option_eighteen_percent -> 18
            else -> 16
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

}}