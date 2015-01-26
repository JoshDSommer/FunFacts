package com.joshdsommer.apps.funfacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends ActionBarActivity {

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        //Declare our view variables and assigne them from views layout file.
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final RelativeLayout  background = (RelativeLayout) findViewById(R.id.background);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);

        factLabel.setText(mFactBook.getFact());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button Clicked update fact label with new fact.
                int color = mColorWheel.getColor();
                factLabel.setText(mFactBook.getFact());
                background.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };

        Log.d("FunFactsActivity","oncreate method");

        showFactButton.setOnClickListener(listener);
    }

}
