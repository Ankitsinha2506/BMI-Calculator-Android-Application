package com.project.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    android.widget.Button mcalculateBmi;
    TextView mcurrentHeight, mcurrentAge, mcurrentWeight;
    ImageView mincrementAge, mdecrementAge, mincrementWeight, mdecrementWeight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 23;
    int currentProgress;
    String mintProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getSupportActionBar().hide();
        mcalculateBmi = findViewById(R.id.calculateBmi);
        mcurrentAge = findViewById(R.id.currentAge);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mdecrementAge = findViewById(R.id.decrementAge);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecrementWeight = findViewById(R.id.decrementWeight);
        mseekbarforheight = findViewById(R.id.seekBarForHeight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfUser = "Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfUser = "Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mintProgress = String.valueOf(currentProgress);
                mcurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        mcalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (typeOfUser.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(), "Select Your Gender First.", Toast.LENGTH_SHORT).show();
                    } else if (mintProgress.equals("0")) {
                        Toast.makeText(getApplicationContext(), "Select Your Height First.", Toast.LENGTH_SHORT).show();
                    } else if (intage == 0 || intage < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid Age.", Toast.LENGTH_SHORT).show();
                    } else if (intweight == 0 || intweight < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid Weight.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                        intent.putExtra("gender", typeOfUser);
                        intent.putExtra("height", mintProgress);
                        intent.putExtra("weight", weight2);
                        intent.putExtra("age", age2);
                        startActivity(intent);
                    }



                // Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}