package edu.orangecoastcollege.cs273.gbyers.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //add currency format for locale (could use Local.US as parameter)
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    //Associate Controller with neede views
    private EditText weightEditText;
    private TextView baseCost;
    private TextView addedCost;
    private TextView totalCost;

    //Associate Controller with Model
    public ShipItem packageOne = new ShipItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weight_edit_text);
        baseCost = (TextView) findViewById(R.id.base_cost);
        addedCost = (TextView) findViewById(R.id.added_cost);
        totalCost = (TextView) findViewById(R.id.total_cost);

        //define a listener for the weight editText onTextChange
        weightEditText.addTextChangedListener(weightTextChangeListener);
    }
    private TextWatcher weightTextChangeListener = new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try{
                double weightOunces = Double.parseDouble(charSequence.toString());
                packageOne.setWeight(weightOunces);
            }catch(NumberFormatException e){
                weightEditText.setText("");
            }
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
private void updateViews()
{
    baseCost.setText(currency.format(packageOne.getBaseCost()));
    addedCost.setText(currency.format(packageOne.getAddedCost()));
    totalCost.setText(currency.format(packageOne.getTotal()));
}
}
