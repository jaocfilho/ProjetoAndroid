package com.example.projetobloco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TransactionForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_form)

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }

        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener {
            val institutionEt = findViewById<EditText>(R.id.institution_et)
            val institution = institutionEt.text.toString()

            val mainActivityIntent = Intent(this, MainActivity::class.java)
            mainActivityIntent.apply {
                putExtra("institution", institution)
            }
            startActivity(mainActivityIntent)
        }
    }
}