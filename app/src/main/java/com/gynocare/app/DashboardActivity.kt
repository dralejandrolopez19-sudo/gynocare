package com.gynocare.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("EXTRA_USER") ?: "Doctora"
        binding.welcomeText.text = "Bienvenida, $usuario"

        binding.todayPatientsValue.text = "12"
        binding.remindersValue.text = "08"
        binding.analysisValue.text = "14"

        binding.appointmentsButton.setOnClickListener {
            startActivity(Intent(this, AppointmentActivity::class.java))
        }

        binding.imagesButton.setOnClickListener {
            startActivity(Intent(this, ImageStudyActivity::class.java))
        }

        binding.vaccinesButton.setOnClickListener {
            startActivity(Intent(this, VaccineActivity::class.java))
        }

        binding.analyticsButton.setOnClickListener {
            startActivity(Intent(this, AnalyticsActivity::class.java))
        }

        binding.profileButton.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.logoutButton.setOnClickListener {
            finish()
        }
    }
}
