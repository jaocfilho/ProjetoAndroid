package com.example.projetobloco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobloco.transaction.TransactionViewModel

class MainActivity : AppCompatActivity() {
    private val data = mutableListOf<TransactionViewModel>()
    private val adapter = CustomAdapter(data)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.new_transaction_button)
        button.setOnClickListener {
            val intent = Intent(this, TransactionForm::class.java)
            startActivity(intent)
        }

        val transactionsList = findViewById<RecyclerView>(R.id.transactions_list)
        val manager = LinearLayoutManager(this)
        transactionsList.layoutManager = manager
        transactionsList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        val institution = intent.getStringExtra("institution")
        institution?.let { TransactionViewModel(it) }?.let { data.add(it) }
        adapter.notifyItemInserted(data.size)
    }
}