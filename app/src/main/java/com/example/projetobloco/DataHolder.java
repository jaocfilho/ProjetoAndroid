package com.example.projetobloco;

import com.example.projetobloco.database.Transaction;

import java.util.ArrayList;
import java.util.List;

class DataHolder {
    final List<Transaction> transactions = new ArrayList<Transaction>();

    private DataHolder() {}

    static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}