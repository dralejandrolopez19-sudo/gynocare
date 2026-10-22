package com.gynocare.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityImageStudyBinding

class ImageStudyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageStudyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        binding.saveStudyButton.setOnClickListener { registrarEstudio() }
    }

    private fun registrarEstudio() {
        val nombre = binding.studyNameInput.text.toString().trim()
        val tipo = binding.studyTypeInput.text.toString().trim()
        val fecha = binding.studyDateInput.text.toString().trim()
        val reporte = binding.reportInput.text.toString().trim()

        if (nombre.isEmpty() || tipo.isEmpty() || fecha.isEmpty() || reporte.isEmpty()) {
            Toast.makeText(this, "Completa todos los datos del estudio", Toast.LENGTH_LONG).show()
            return
        }

        binding.summaryCard.visibility = View.VISIBLE
        binding.summaryTitle.text = "Estudio registrado"
        binding.summaryText.text = "$nombre - $tipo\nFecha: $fecha\nReporte: $reporte"
        Toast.makeText(this, "Estudio agregado correctamente", Toast.LENGTH_SHORT).show()
    }
}
