package com.example.caremicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button b1;
    EditText t1,t2,t3,t4;
    TextView tt1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(this);
        t1=(EditText)findViewById(R.id.paa);
        t2=(EditText)findViewById(R.id.dpp);
        t3=(EditText)findViewById(R.id.irr);
        t4=(EditText)findViewById(R.id.ltt);
        tt1=(TextView)findViewById(R.id.textView6);
    }
    public void onClick(View v)
    {
        double p,r,n,d,emi;
        p=Double.parseDouble(t1.getText().toString());
        d=Double.parseDouble(t2.getText().toString());
        if (d > p) {
            t2.setError("Down payment cannot be more than the principal amount");
            return;
        }
        p=p-d;
        r=Double.parseDouble(t3.getText().toString());
        r=r/(12*100);
        n=Double.parseDouble(t4.getText().toString());
        emi=p*(r*Math.pow((1+r),n))/(Math.pow((1+r),n)-1); // double emi = principleAmount * (interestRate * Math.pow((1 + interestRate), loanTerm)) / (Math.pow((1 + interestRate), loanTerm) - 1);
        emi = Math.round(emi * 100.0) / 100.0; // Round off to two decimal places
        tt1.setText(String.valueOf(emi));


    }

}