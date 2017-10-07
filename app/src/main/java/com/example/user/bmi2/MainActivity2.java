package com.example.user.bmi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText mHeightEdidtext,mWeightEdittext;
    private Button mCalculatorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeightEdidtext = (EditText) findViewById(R.id.height_edit_text);
        mWeightEdittext = (EditText) findViewById(R.id.weight_edit_text);
        mCalculatorButton = (Button) findViewById(R.id.calculator_button);

        mCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(mHeightEdidtext.getText().toString());
                Double weight = Double.valueOf(mWeightEdittext.getText().toString());
                Double bmi = weight/((height/100)*(height/100));
                String bmiText = getBmiText(bmi);

                Intent newpage = new Intent(MainActivity2.this,Main2Activity.class);
                newpage.putExtra("bmi_value",bmi);
                newpage.putExtra("bmi_text",bmiText);
                startActivity(newpage);
            }
        });
    }
    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi<18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi<25){
            bmiText = "น้ำหนักปกติ";
        }else if(bmi<30){
            bmiText= "น้ำหนักมาากกว่าปกติ (ท้วม)";
        }else{
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return  bmiText;
    }
}
