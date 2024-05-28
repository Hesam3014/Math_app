package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ResultsAdapter extends ArrayAdapter<Answer> {

    public ResultsAdapter(Context context, ArrayList<Answer> answers) {
        super(context, 0, answers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Answer answer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(answer.toString());

        if (answer.isCorrect()) {
            textView.setTextColor(Color.GREEN);
        } else {
            textView.setTextColor(Color.RED);
        }

        return convertView;
    }
}
