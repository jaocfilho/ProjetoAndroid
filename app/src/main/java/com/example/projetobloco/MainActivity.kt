package com.example.projetobloco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val data = mutableListOf<TransactionModel>()
    private val adapter = CustomAdapter(data)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))

        val button = findViewById<Button>(R.id.new_transaction_button)
        button.setOnClickListener { onClickHandler() }

        val transactionsList = findViewById<RecyclerView>(R.id.transactions_list)
        val manager = LinearLayoutManager(this)
        transactionsList.layoutManager = manager
        transactionsList.adapter = adapter
    }

    private fun onClickHandler() {
        data.add(TransactionModel("XP investimentos"))
        adapter.notifyItemInserted(data.size)
    }
}