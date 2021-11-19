package com.example.projetobloco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.projetobloco.database.Transaction

class TransactionForm : AppCompatActivity() {
    private val transactions = DataHolder.getInstance().transactions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_form)

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            redirectToMainActivity()
        }

        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener {
            val institutionEt = findViewById<EditText>(R.id.institution_et)
            val institution = institutionEt.text.toString()
            val amountEt = findViewById<EditText>(R.id.amount_et)
            val amount = amountEt.text.toString().toInt()
            val transaction = Transaction(institution, amount)
            transactions.add(transaction)

            redirectToMainActivity()
        }
    }

    private fun redirectToMainActivity() {
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        startActivity(mainActivityIntent)
    }
}