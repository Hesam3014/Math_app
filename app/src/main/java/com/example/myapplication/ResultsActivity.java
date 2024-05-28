package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ListView resultsListView = findViewById(R.id.resultsListView);
        ArrayList<Answer> answersList = MainActivity.answersList;

        ResultsAdapter adapter = new ResultsAdapter(this, answersList);
        resultsListView.setAdapter(adapter);
    }
}
