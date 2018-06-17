package com.amruthpillai.currencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        // Hide Keyboard on Press
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText dollarAmountEditText = (EditText) findViewById(R.id.dollarAmountEditText);
        TextView convertedCurrencyTextView = (TextView) findViewById(R.id.convertedCurrencyTextView);

        String dollarAmountString = dollarAmountEditText.getText().toString();
        Double dollarAmount = Double.parseDouble(dollarAmountString);

        // 1 USD = 64.27 INR (Indian Rupees)
        Double convertedCurrencyAmount = dollarAmount * 64.27;
        String convertedCurrencyAmountString = convertedCurrencyAmount.toString();
        String convertedCurrencyAmountFormattedString = "Rs. " + String.format("%.2f", convertedCurrencyAmount);
        convertedCurrencyTextView.setText(convertedCurrencyAmountFormattedString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
