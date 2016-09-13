package edu.orangecoastcollege.cs273.gbyers.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        double weightOunces = Double.parseDouble(charSequence.toString());
            packageOne.setWeight(weightOunces);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
