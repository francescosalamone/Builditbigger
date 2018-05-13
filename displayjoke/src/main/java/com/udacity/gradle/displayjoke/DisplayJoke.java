package com.udacity.gradle.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    private static final String INTENT_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        Intent intent = getIntent();
        TextView jokeTv = findViewById(R.id.joke_tv);
        jokeTv.setText(intent.getStringExtra(INTENT_JOKE));
    }

}
