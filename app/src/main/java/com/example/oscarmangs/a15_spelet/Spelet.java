package com.example.oscarmangs.a15_spelet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by oscarmangs on 2018-02-20.
 */

public class Spelet extends AppCompatActivity {

    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();

    int emptyIndex = 0;
    int currentIndex = 0;
    String savebtn = "";
    int clickcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelet);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);
        final Button button7 = findViewById(R.id.button7);
        final Button button8 = findViewById(R.id.button8);
        final Button button9 = findViewById(R.id.button9);
        final Button button10 = findViewById(R.id.button10);
        final Button button11 = findViewById(R.id.button11);
        final Button button12 = findViewById(R.id.button12);
        final Button button13 = findViewById(R.id.button13);
        final Button button14 = findViewById(R.id.button14);
        final Button button15 = findViewById(R.id.button15);
        final Button button16 = findViewById(R.id.button16);
        Button blanda = findViewById(R.id.blanda);

        final TextView textView = findViewById(R.id.textView);

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);



        blanda();

        final View.OnClickListener blandaLyssnare = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                blanda();
            }
        };
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).getText().equals("")) {
                        emptyIndex = i; //Tomma knappen i empty

                    }
                    if (buttons.get(i).getText().equals(((Button) view).getText())) {
                        currentIndex = i;   //klickade knappen i current
                    }
                }
                if (currentIndex == 3 || currentIndex == 7 || currentIndex == 11 || currentIndex == 15){
                    if (emptyIndex == currentIndex -1 || emptyIndex == currentIndex -4 || emptyIndex == currentIndex+4){
                        Button currentBtn = buttons.get(currentIndex);
                        Button emptyBtn = buttons.get(emptyIndex);
                        emptyBtn.setText(currentBtn.getText());
                        currentBtn.setText(savebtn);

                        clickcount ++;
                        textView.setText(String.valueOf(clickcount));

                        if (isSorted())
                            Toast.makeText(getApplicationContext(), "DU VANN!", Toast.LENGTH_LONG).show();
                    }
                }
                else if (currentIndex == 0 ||currentIndex == 4 || currentIndex == 8 || currentIndex == 12){
                    if (emptyIndex == currentIndex +1 || emptyIndex == currentIndex -4 ||emptyIndex == currentIndex +4){
                        Button currentBtn = buttons.get(currentIndex);
                        Button emptyBtn = buttons.get(emptyIndex);
                        emptyBtn.setText(currentBtn.getText());
                        currentBtn.setText(savebtn);

                        clickcount ++;
                        textView.setText(String.valueOf(clickcount));

                        if (isSorted())
                            Toast.makeText(getApplicationContext(), "DU VANN!", Toast.LENGTH_LONG).show();

                    }
                }
                else if (emptyIndex == currentIndex - 1 /*vänster*/ || emptyIndex == currentIndex + 1 /*höger*/ || emptyIndex == currentIndex - 4/*upp*/
                        || emptyIndex == currentIndex + 4/*ner*/) {


                    Button currentBtn = buttons.get(currentIndex);
                    Button emptyBtn = buttons.get(emptyIndex);
                    emptyBtn.setText(currentBtn.getText());
                    currentBtn.setText(savebtn);

                    clickcount ++;
                    textView.setText(String.valueOf(clickcount));

                    if (isSorted())
                        Toast.makeText(getApplicationContext(), "DU VANN!", Toast.LENGTH_LONG).show();

                }

                if (isSorted()){

                        Intent intent = new Intent(Spelet.this, MainActivity.class);
                        intent.putExtra("EXTRA_SESSION_ID", clickcount);
                        startActivity(intent);

                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(listener);
        button11.setOnClickListener(listener);
        button12.setOnClickListener(listener);
        button13.setOnClickListener(listener);
        button14.setOnClickListener(listener);
        button15.setOnClickListener(listener);
        button16.setOnClickListener(listener);
        blanda.setOnClickListener(blandaLyssnare);



    }


    public void blanda() {

        for (int i = 0; i < buttons.size(); i++) {
            Button butt = buttons.get(i);
            String buttonText = butt.getText().toString();
            strings.add(buttonText);
        }
        Collections.shuffle(strings);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText(strings.get(i));
        }

        strings.clear();
    }



    public boolean isSorted() {
        for (int i = 0; i < buttons.size() - 1 ; i++) {

            String y = buttons.get(i).getText().toString();
            if (y.equals(""))
                return false;
            int o = Integer.valueOf(y);
            if (o != i + 1)
                return false;

        }
        return true;
    }
}
