package com.bretthirschberger.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;
    private Button button;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grade1 = findViewById(R.id.grade1);
        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        grade4 = findViewById(R.id.grade4);
        grade5 = findViewById(R.id.grade5);
        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);
    }

    public void calculateGrade(View view) {
        double avg;
        if (grade1.getText().toString().equals("") ||
                grade2.getText().toString().equals("") ||
                grade3.getText().toString().equals("") ||
                grade4.getText().toString().equals("") ||
                grade5.getText().toString().equals("")) {
            Toast.makeText(this, getString(R.string.empty_field), Toast.LENGTH_SHORT).show();
            return;
        }
        avg = (Double.parseDouble(grade1.getText().toString()) +
                Double.parseDouble(grade2.getText().toString()) +
                Double.parseDouble(grade3.getText().toString()) +
                Double.parseDouble(grade4.getText().toString()) +
                Double.parseDouble(grade5.getText().toString())) / 5;
        Toast.makeText(this, "" + avg, Toast.LENGTH_SHORT).show();
        if (avg >= 80) {
            layout.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (avg >= 60 && avg < 80) {
            layout.setBackgroundColor(getResources().getColor(R.color.yellow));
        } else if (avg < 60) {
            layout.setBackgroundColor(getResources().getColor(R.color.red));
        }
        button.setOnClickListener(this::clearNumberFields);
        button.setText(R.string.clear_label);
    }

    public void clearNumberFields(View view) {
        grade1.setText(null);
        grade2.setText(null);
        grade3.setText(null);
        grade4.setText(null);
        grade5.setText(null);
        layout.setBackgroundColor(getResources().getColor(R.color.white));
        button.setOnClickListener(this::calculateGrade);
        button.setText(R.string.calc_label);
    }
}
