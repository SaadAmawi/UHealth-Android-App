package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DietPlan extends AppCompatActivity {
Button DietCalc;
EditText bmi;
TextView Diet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);
        DietCalc = findViewById(R.id.CalcDiets);
        bmi = findViewById(R.id.bmi);
        Diet = findViewById(R.id.Plan);
        DietCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String STRbmi = bmi.getText().toString();
               double INTbmi = Double.parseDouble(STRbmi);
            if(INTbmi < 16){
            Diet.setText("Your BMI indicates that you are severely below healthy weight\n" +
                    "\nChoose nutrient-rich foods. As part of an overall healthy diet," +
                         " choose whole-grain breads, pastas and cereals; fruits and vegetables; " +
                         "dairy products; lean protein sources; and nuts and seeds.\n" +
                         "Try smoothies and shakes. Don't fill up on diet soda, coffee and other " +
                        "drinks with few calories and little nutritional value. \n" +
                    "\nRecommended Calories intake:\n\n\n" +
                    "2800 cal\n" +
                    "2g of protien/KG of bodyweight\n" +
                    "40% of total calories from fat\n" +
                    "30% of total calories from Carbohydrates");
            }else if(INTbmi >16 && INTbmi <18.5){
                Diet.setText("Your BMI indicates that you are moderately below healthy weight\n" +
                        "\nChoose nutrient-rich foods. As part of an overall healthy diet," +
                        " choose whole-grain breads, pastas and cereals; fruits and vegetables; " +
                        "dairy products; lean protein sources; and nuts and seeds.\n" +
                        "Try smoothies and shakes. Don't fill up on diet soda, coffee and other " +
                        "drinks with few calories and little nutritional value. \n" +
                        "\nRecommended Calories intake:\n\n\n" +
                        "2600 cal\n" +
                        "2g of protien/KG of bodyweight\n" +
                        "30% of total calories from fat\n" +
                        "40% of total calories from Carbohydrates");

            }else if(INTbmi >18.5 && INTbmi <25){
                Diet.setText("Your BMI indicates that you are at a healthy weight for your height\n" +
                        "\nChoose nutrient-rich foods. As part of an overall healthy diet," +
                        " choose whole-grain breads, pastas and cereals; fruits and vegetables; " +
                        "dairy products; lean protein sources; and nuts and seeds.\n" +
                        "Try smoothies and shakes. Don't fill up on diet soda, coffee and other " +
                        "drinks with few calories and little nutritional value. \n" +
                        "\nRecommended Calories intake:\n\n\n" +
                        "2400 cal\n" +
                        "2g of protien/KG of bodyweight\n" +
                        "30% of total calories from fat\n" +
                        "40% of total calories from Carbohydrates");
            }else if(INTbmi >25 && INTbmi <30){
                Diet.setText("Your BMI indicates that you are overweight\n" +
                        "\nChoose nutrient-rich foods. As part of an overall healthy diet," +
                        " choose whole-grain breads, pastas and cereals; fruits and vegetables; " +
                        "dairy products; lean protein sources; and nuts and seeds.\n" +
                        "Try smoothies and shakes. Don't fill up on diet soda, coffee and other " +
                        "drinks with few calories and little nutritional value. \n" +
                        "\nRecommended Calories intake:\n\n\n" +
                        "2000 cal\n" +
                        "2g of protien/KG of bodyweight\n" +
                        "30% of total calories from fat\n" +
                        "40% of total calories from Carbohydrates");
            }else if(INTbmi >= 30){
                Diet.setText("Your BMI indicates that you are obese\n" +
                        "\nChoose nutrient-rich foods. As part of an overall healthy diet," +
                        " choose whole-grain breads, pastas and cereals; fruits and vegetables; " +
                        "dairy products; lean protein sources; and nuts and seeds.\n" +
                        "Try smoothies and shakes. Don't fill up on diet soda, coffee and other " +
                        "drinks with few calories and little nutritional value. \n" +
                        "\nRecommended Calories intake:\n\n\n" +
                        "1800 cal\n" +
                        "2.5g of protien/KG of bodyweight\n" +
                        "20% of total calories from fat\n" +
                        "40% of total calories from Carbohydrates");}
            }
        });

    }
}