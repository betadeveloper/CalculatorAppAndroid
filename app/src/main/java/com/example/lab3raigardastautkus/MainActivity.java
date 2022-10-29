package com.example.lab3raigardastautkus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String oldNumber="";
    String op = "+";
    boolean isNegative = false;
    boolean isNewOp = true;
    EditText tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.calculatorScreen);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            tv1.setText("");
        isNewOp = false;
        String number = tv1.getText().toString();
        switch(view.getId()) {
            case R.id.n0:
                number += "0";
                break;
            case R.id.n1:
                number += "1";
                break;
            case R.id.n2:
                number += "2";
                break;
            case R.id.n3:
                number += "3";
                break;
            case R.id.n4:
                number += "4";
                break;
            case R.id.n5:
                number += "5";
                break;
            case R.id.n6:
                number += "6";
                break;
            case R.id.n7:
                number += "7";
                break;
            case R.id.n8:
                number += "8";
                break;
            case R.id.n9:
                number += "9";
                break;
            case R.id.dot:
                number+=".";
                break;
            case R.id.PlusMinus:
                    number = String.valueOf(Double.parseDouble(number)*-1);
                    break;
            case R.id.del:
                if(number.length() > 1) {
                    String newText = number.substring(0, number.length() - 1);
                    number = newText;
                    break;
                }
        }
        tv1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = tv1.getText().toString();
        switch(view.getId()) {
            case R.id.division: op = "/"; break;
            case R.id.multiplication: op = "*"; break;
            case R.id.plus: op = "+"; break;
            case R.id.minus: op = "-"; break;
            case R.id.sqrt: op = "√"; break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = tv1.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "√":
                result = Math.sqrt(Double.parseDouble(oldNumber));
                break;
        }
        tv1.setText(result+"");
    }

    public void CEevent(View view) {
        tv1.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double n = Double.parseDouble(tv1.getText().toString())/100;
        tv1.setText(n+"");
        isNewOp = true;
    }
}