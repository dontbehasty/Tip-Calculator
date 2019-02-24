package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    EditText billAmtEditText;
    EditText tipPercentageEditText;
    EditText splitEditText;
    Button calculateButton;
    TextView tipAmtTextView;
    TextView totalAmtTextView;
    TextView perPersonTextView;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmtEditText = (EditText) findViewById(R.id.billAmtEditText);
        tipPercentageEditText = (EditText) findViewById(R.id.tipPercentageEditText);
        splitEditText = (EditText) findViewById(R.id.splitEditText);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        tipAmtTextView = (TextView) findViewById(R.id.tipAmtTextView);
        totalAmtTextView = (TextView) findViewById(R.id.totalAmtTextView);
        perPersonTextView = (TextView) findViewById(R.id.perPersonTextView);
        resetButton = (Button) findViewById(R.id.resetButton);


        //Calculate Button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check if Text Fields are empty
                if (billAmtEditText.getText().toString().length() == 0 || tipPercentageEditText.getText().toString().length() == 0 || splitEditText.getText().toString().length() == 0) {
                    //Textfields are empty.
                    Log.d("Error","Fields are empty");
                } else {
                    //Get Bill Amount
                    Double billTotal = Double.valueOf(billAmtEditText.getText().toString());

                    //Read in Tip Percentage & Calculate it as a Decimal
                    Double tip = Double.valueOf(tipPercentageEditText.getText().toString());
                    Double tipPercentage = tip / 100;

                    //Read in No of People Amount
                    int split = Integer.valueOf(splitEditText.getText().toString());

                    //Determine & Display Tip Amount
                    Double tipAmt = billTotal * tipPercentage;
                    tipAmtTextView.setText("£" + String.format("%.2f", tipAmt));

                    //Determine & Display Total Amount
                    Double totalAmt = billTotal + tipAmt;
                    totalAmtTextView.setText("£" + String.format("%.2f", totalAmt));

                    //Determine Total Amount Per Person
                    Double perPerson = totalAmt / split;
                    perPersonTextView.setText("£" + String.format("%.2f", perPerson));

                }
            }
        });

        //Reset Button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                billAmtEditText.setText(" ");
                tipPercentageEditText.setText("10");
                splitEditText.setText("1");
                tipAmtTextView.setText("£0.00");
                totalAmtTextView.setText("£0.00");
                perPersonTextView.setText("£0.00");
            }
        });

    }

}
