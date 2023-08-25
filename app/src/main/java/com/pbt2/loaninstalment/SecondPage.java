package com.pbt2.loaninstalment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondPage extends AppCompatActivity {
    EditText amount, interest, year;
    Button calculate, reset;
    double Amount, Interest;
    int Years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        amount = findViewById(R.id.editTextNumberDecimal);
        interest = findViewById(R.id.editTextNumberDecimal1);
        year = findViewById(R.id.editTextNumberDecimal3);
        calculate = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount = Double.parseDouble(amount.getText().toString());
                Interest = Double.parseDouble(interest.getText().toString());
                Years = Integer.parseInt(year.getText().toString());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setText("");
                interest.setText("");
                year.setText("");
            }
        });
    }
}