package com.gynocare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityAnalyticsBinding

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }

        binding.totalPatientsValue.text = "125"
        binding.consultationsValue.text = "86"
        binding.complianceValue.text = "92%"
        binding.followUpsValue.text = "34"
        binding.imageStudiesValue.text = "18"
        binding.vaccineCoverageValue.text = "89%"
    }
}
