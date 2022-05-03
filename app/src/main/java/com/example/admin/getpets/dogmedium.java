package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dogmedium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogmedium);
    }
    public void sendgolden(View view)
    {
        Intent i = new Intent(dogmedium.this,DetailActivity.class);
        i.putExtra("petid",6);

        startActivity(i);
    }
    public void sendhusky(View view)
    {
        Intent i = new Intent(dogmedium.this,DetailActivity.class);
        i.putExtra("petid",7);
        startActivity(i);
    }
    public void senddalmation(View view)
    {
        Intent i = new Intent(dogmedium.this,DetailActivity.class);
        i.putExtra("petid",1);
        startActivity(i);
    }

}
