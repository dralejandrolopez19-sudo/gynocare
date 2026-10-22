package com.gynocare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val usuario = binding.userInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingresa usuario y contraseña", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("EXTRA_USER", usuario)
            startActivity(intent)
        }
    }
}
