package com.project.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BmiActivity extends AppCompatActivity {
    android.widget.Button mrecalculate;
    TextView mbmidisplay, mbmicategory, mgender;
    ImageView mimageiew;
    Intent intent;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intHeight, intWeight;

    RelativeLayout mbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

       /* getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);*/

        intent = getIntent();
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mimageiew = findViewById(R.id.imageview);
        mrecalculate = findViewById(R.id.recalculate);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;
        intbmi = intWeight/(intHeight*intHeight);
        mbmi = Float.toString(intbmi);

        if(intbmi < 16)
        {
            mbmicategory.setText("Server Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageiew.setImageResource(R.drawable.crosss);
            
        } else if (intbmi < 16.9 && intbmi > 16) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageiew.setImageResource(R.drawable.warning);
            
        } else if (intbmi < 18.4 && intbmi > 17) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageiew.setImageResource(R.drawable.warning);
            
        } else if (intbmi < 25 && intbmi > 18.4) {
            mbmicategory.setText("Normal");
           // mbackground.setBackgroundColor(Color.YELLOW);
            mimageiew.setImageResource(R.drawable.ok);
        } else if (intbmi < 29.4 && intbmi > 25) {
            mbmicategory.setText("OverWeight");
            mbackground.setBackgroundColor(Color.RED);
            mimageiew.setImageResource(R.drawable.warning);
        }
        else {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageiew.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mrecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }


}