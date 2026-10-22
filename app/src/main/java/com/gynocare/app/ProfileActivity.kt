package com.gynocare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileName.text = "Dra. Ana López"
        binding.profileEspecialidad.text = "Ginecología y obstetricia"
        binding.profileClinic.text = "Clínica Gynocare Central"
        binding.profilePhone.text = "+52 555 123 4567"

        binding.backButton.setOnClickListener { finish() }
    }
}
