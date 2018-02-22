package com.example.oscarmangs.a15_spelet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int s = getIntent().getIntExtra("EXTRA_SESSION_ID", 0);

        final TextView textViewMenu = findViewById(R.id.textViewMenu);
        textViewMenu.setText(String.valueOf(s));

    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, Spelet.class);
        startActivity(intent);
    }
}
