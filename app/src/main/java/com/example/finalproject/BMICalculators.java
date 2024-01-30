package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculators extends AppCompatActivity {
Button BMICALC;
EditText Height;
EditText Weight;
TextView Result;
Button Dietbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculators);
        BMICALC = findViewById(R.id.button);
        Weight = findViewById(R.id.editTextTextPersonName4);
        Height = findViewById(R.id.editTextTextPersonName2);
        Result = findViewById(R.id.textView);
        Dietbtn = findViewById(R.id.DietButton);
        Dietbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMICalculators.this, DietPlan.class);
                startActivity(intent);
            }
        });
        BMICALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String weight = Weight.getText().toString();
                String height = Height.getText().toString();
                int weight1 = Integer.parseInt(weight);
                double height1 = Double.parseDouble(height);
                double result = weight1/Math.pow(height1/100,2);

                Result.setText(Double.toString(result));

            }
        });
    }
}