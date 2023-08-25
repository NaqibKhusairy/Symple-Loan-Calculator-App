package com.pbt2.loaninstalment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                try{
                    Amount = Double.parseDouble(amount.getText().toString());
                    Interest = Double.parseDouble(interest.getText().toString());
                    Years = Integer.parseInt(year.getText().toString());
                    Intent x = new Intent(getApplicationContext(), ThirdPage.class);
                    x.putExtra("Amount", Amount);
                    x.putExtra("Interest", Interest);
                    x.putExtra("Years", Years);
                    startActivity(x);
                }
                catch (Exception e) {
                    errormsg();
                }

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
    public void errormsg(){
        if((amount.getText().toString()).isEmpty()&&(interest.getText().toString()).isEmpty()&&(year.getText().toString()).isEmpty()){
            amount.setError("Please Enter The Loan Amount (RM)");
            interest.setError("Plase Enter The Interest Rate per Year (%)");
            year.setError("Pleas Enter How Many Years");
        }
        else if((amount.getText().toString()).isEmpty()&&(interest.getText().toString()).isEmpty()){
            amount.setError("Please Enter The Loan Amount (RM)");
            interest.setError("Plase Enter The Interest Rate per Year (%)");
        }
        else if((interest.getText().toString()).isEmpty()&&(year.getText().toString()).isEmpty()){
            interest.setError("Plase Enter The Interest Rate per Year (%)");
            year.setError("Pleas Enter How Many Years");
        }
        else if((amount.getText().toString()).isEmpty()&&(year.getText().toString()).isEmpty()){
            amount.setError("Please Enter The Loan Amount (RM)");
            year.setError("Pleas Enter How Many Years");
        }
        else {
            if ((amount.getText().toString()).isEmpty()) {
                amount.setError("Please Enter The Loan Amount (RM)");
            } else if ((interest.getText().toString()).isEmpty()) {
                interest.setError("Plase Enter The Interest Rate per Year (%)");
            } else if ((year.getText().toString()).isEmpty()) {
                year.setError("Pleas Enter How Many Years");
            }
        }
    }
}