package com.example.projetobloco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobloco.database.Transaction

class MainActivity : AppCompatActivity() {
    private val transactions = DataHolder.getInstance().transactions
    private val adapter = CustomAdapter(transactions as ArrayList<Transaction>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Changes actual activity if user taps the button.
        val button = findViewById<Button>(R.id.new_transaction_button)
        button.setOnClickListener {
            val intent = Intent(this, TransactionForm::class.java)
            startActivity(intent)
        }
        // Inflates the activity
        val transactionsList = findViewById<RecyclerView>(R.id.transactions_list)
        val manager = LinearLayoutManager(this)
        transactionsList.layoutManager = manager
        transactionsList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyItemInserted(transactions.size)
    }
}