package com.pbt2.loaninstalment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdPage extends AppCompatActivity {
    EditText installmentpermonth, totalloan;
    Button back;
    double P, r, A, TotalLoan;
    int n;
    TextView trytv;

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        installmentpermonth = findViewById(R.id.editTextNumberDecimal);
        totalloan = findViewById(R.id.editTextNumberDecimal2);
        back = findViewById(R.id.button);
        P = getIntent().getDoubleExtra("Amount",0.00);
        r = getIntent().getDoubleExtra("Interest",0.00000);
        n = getIntent().getIntExtra("Years",0);

        r = r / 12 / 100;
        n = n * 12;
        A = P * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        installmentpermonth.setText(String.format("%.2f", A));
        TotalLoan = (A * n) - P;
        totalloan.setText(String.format("%.2f",TotalLoan));

        trytv = findViewById(R.id.textView4);
        trytv.setText("P = RM "+String.format("%.2f", P)+
                "\n r = "+String.format("%.4f", r)+"% per period"+
                "\n n = "+n+" Total Periods"+
                "\n Installment Per Month = RM "+String.format("%.2f",A)+
                "\n Total Interest = RM "+String.format("%.2f",TotalLoan));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(getApplicationContext(),SecondPage.class);
                startActivity(x);
            }
        });
    }
}