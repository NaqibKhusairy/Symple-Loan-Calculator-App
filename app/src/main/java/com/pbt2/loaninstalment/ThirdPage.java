package com.pbt2.loaninstalment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ThirdPage extends AppCompatActivity {
    EditText installmentpermonth, totalloan;
    Button back;
    double P, r, A, TotalLoan;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        installmentpermonth = findViewById(R.id.editTextNumberDecimal);
        totalloan = findViewById(R.id.editTextNumberDecimal2);
        back = findViewById(R.id.button);
        P = getIntent().getDoubleExtra("Amount",0.00);
        r = getIntent().getDoubleExtra("Interest",0.00);
        n = getIntent().getIntExtra("Years",0);

        r = r / 12 / 100;
        n = n * 12;
        A = P * ((r * Math.pow((1 + r), n) / (Math.pow((1 + r), n) - 1)));
        installmentpermonth.setText(String.format("%.2f", A));
        TotalLoan = (((A * 12) * n) - P);
        totalloan.setText(String.format("%.2f",TotalLoan));
    }
}