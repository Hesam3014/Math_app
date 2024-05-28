package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve the string from the Intent
        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra("messageKey");

        // Get the TextView from the layout
        TextView textView = findViewById(R.id.number3TextView);

        // Set the receivedMessage string to the TextView
        textView.setText(receivedMessage);

        // Get the result from the Intent
        String result = intent.getStringExtra("messegekey2");

        // Get the LottieAnimationView from the layout
        LottieAnimationView animationView = findViewById(R.id.animationView);

        // Set the animation based on the result
        if ("correct".equals(result)) {
            // Set correct animation
            animationView.setAnimation("Animation-correct.json");
        } else {
            // Set false animation
            animationView.setAnimation("Animation-fals.json");
        }
        // Start the animation
        animationView.playAnimation();
        //yes
    }
}
