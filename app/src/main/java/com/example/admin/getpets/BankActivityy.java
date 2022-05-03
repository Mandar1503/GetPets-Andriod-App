package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BankActivityy extends AppCompatActivity {

    public int petid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_activityy);

        Intent i= getIntent();
        petid=i.getIntExtra("petid",0);


    }

    public void saveCardDetails(View view)
    {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        CardDetails card = new CardDetails();
        card.cardno = Long.parseLong(((TextView)findViewById(R.id.cardNumberEdit)).getText().toString());
        card.Name = ((TextView)findViewById(R.id.cardNameEdit)).getText().toString();
        card.date = Integer.parseInt(((TextView)findViewById(R.id.dateEdit)).getText().toString());
        card.cvv = Integer.parseInt(((TextView)findViewById(R.id.cvvEdit)).getText().toString());

        dbHandler.addHandler(card);
        dbHandler.updateHandler(petid);

        Toast.makeText(BankActivityy.this, "Bought Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(BankActivityy.this,DetailActivity.class);
        i.putExtra("petid",petid);
        startActivity(i);
        finish();
    }
}
