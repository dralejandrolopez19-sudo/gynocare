package com.gynocare.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gynocare.app.databinding.ActivityAppointmentBinding

class AppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentBinding
    private var ultimoMensajeRecordatorio: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        binding.scheduleButton.setOnClickListener { agendarCita() }
        binding.sendReminderButton.setOnClickListener { enviarRecordatorio() }
    }

    private fun agendarCita() {
        val nombre = binding.patientNameInput.text.toString().trim()
        val telefono = binding.patientPhoneInput.text.toString().trim()
        val fecha = binding.dateInput.text.toString().trim()
        val hora = binding.timeInput.text.toString().trim()

        if (nombre.isEmpty() || telefono.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_LONG).show()
            return
        }

        val numero = normalizarTelefono(telefono)
        if (numero.isEmpty()) {
            Toast.makeText(this, "Número de WhatsApp no válido", Toast.LENGTH_LONG).show()
            return
        }

        ultimoMensajeRecordatorio = "Hola $nombre, te recordamos tu cita en Gynocare. Tu consulta está programada para el $fecha a las $hora. Te esperamos."

        binding.summaryCard.visibility = View.VISIBLE
        binding.summaryTitle.text = getString(R.string.summary_title)
        binding.summaryText.text = "Cita agendada para $nombre el $fecha a las $hora."
        binding.sendReminderButton.visibility = View.VISIBLE

        Toast.makeText(this, "Cita guardada correctamente", Toast.LENGTH_SHORT).show()
    }

    private fun enviarRecordatorio() {
        val mensaje = ultimoMensajeRecordatorio
        val numero = normalizarTelefono(binding.patientPhoneInput.text.toString().trim())

        if (mensaje.isNullOrBlank()) {
            Toast.makeText(this, "Primero agenda una cita", Toast.LENGTH_SHORT).show()
            return
        }

        if (numero.isEmpty()) {
            Toast.makeText(this, "Ingresa un número de WhatsApp válido", Toast.LENGTH_LONG).show()
            return
        }

        abrirWhatsApp(numero, mensaje)
    }

    private fun abrirWhatsApp(telefono: String, mensaje: String) {
        val uri = Uri.parse("https://wa.me/$telefono?text=${Uri.encode(mensaje)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            val fallback = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://api.whatsapp.com/send?phone=$telefono&text=${Uri.encode(mensaje)}")
            )
            startActivity(fallback)
        }
    }

    private fun normalizarTelefono(telefono: String): String {
        val soloDigitos = telefono.replace("[^0-9]".toRegex(), "")
        return if (soloDigitos.length >= 10) soloDigitos else ""
    }
}
