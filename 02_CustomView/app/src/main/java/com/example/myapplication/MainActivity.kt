package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import values.SeatsView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Catatan: Jika Anda ingin memperbesar
         * tampilan dan menghilangkan toolbar,
         * tambahkan kode berikut di atas pemanggilan fungsi setContentView.
         * */
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val seatView = findViewById<SeatsView>(R.id.seatsView)
        val button = findViewById<Button>(R.id.finishButton)

        button.setOnClickListener {
            seatView.seat?.let {
                Toast.makeText(this, "Kursi Anda nomor ${it.name}.", Toast.LENGTH_SHORT).show()
            } ?: run {
                Toast.makeText(this, "Silakan pilih kursi terlebih dahulu.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}