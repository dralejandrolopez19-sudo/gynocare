package com.gynocare.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityVaccineBinding

class VaccineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVaccineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        binding.saveVaccineButton.setOnClickListener { registrarVacuna() }
    }

    private fun registrarVacuna() {
        val nombre = binding.vaccineNameInput.text.toString().trim()
        val fecha = binding.vaccineDateInput.text.toString().trim()
        val dosis = binding.vaccineDoseInput.text.toString().trim()
        val embarazo = binding.pregnancyStageInput.text.toString().trim()

        if (nombre.isEmpty() || fecha.isEmpty() || dosis.isEmpty() || embarazo.isEmpty()) {
            Toast.makeText(this, "Completa la información de la vacuna", Toast.LENGTH_LONG).show()
            return
        }

        binding.summaryCard.visibility = View.VISIBLE
        binding.summaryTitle.text = "Vacuna registrada"
        binding.summaryText.text = "Vacuna: $nombre\nDosis: $dosis\nFecha: $fecha\nEtapa del embarazo: $embarazo"
        Toast.makeText(this, "Vacuna agregada correctamente", Toast.LENGTH_SHORT).show()
    }
}
