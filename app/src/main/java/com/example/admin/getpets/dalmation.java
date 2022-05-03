package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dalmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_dalmation);
        TextView weight = (TextView)findViewById(R.id.textView13);
       // TextView height=(TextView)findViewById(R.id.textView14);
        TextView availabilityText=(TextView)findViewById(R.id.textView15);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        PetDetails pet = dbHandler.findHandler(2);
        weight.setText("Weight:- " + pet.weight+" lbs");
        availabilityText.setText("Availability:- " + pet.availability);
    }

    public void OnBuyClick(View view){

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        dbHandler.updateHandler(1);

        PetDetails pet = dbHandler.findHandler(1);
        TextView availabilityText=(TextView)findViewById(R.id.textView15);
        availabilityText.setText("Availability:- " + pet.availability);
    }


}
