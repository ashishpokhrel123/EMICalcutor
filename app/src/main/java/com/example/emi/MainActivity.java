package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3;
    TextView result;
    Button btncal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.loan);
        et2  = findViewById(R.id.rate);
        et3 = findViewById(R.id.time);
        btncal =findViewById(R.id.calbmi);
        result =findViewById(R.id.emidis);

        btncal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       float loan = Float.parseFloat(et1.getText().toString());
       float rate = Float.parseFloat(et2.getText().toString());
       float time = Float.parseFloat(et3.getText().toString());


     float   emi =  emical(loan,rate,time);
        result.setText(String.format("EMI =%.2f",emi));





    }
    // Calcuating EMI
    static float emical(float p, float r, float t){
        float  r1 = r / (12 * 100);
        float t1 = t * 12;
        float em = (p * r1 * (float)Math.pow(1 + r1, t1)) / (float)(Math.pow(1 + r1, t1) - 1);

        return (em);  // Returning emi value




    }
}
