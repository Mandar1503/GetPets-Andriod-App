package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class smalldog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smalldog);
    }
    public void sendMessagejack(View view)
    {
        Intent i = new Intent(smalldog.this,DetailActivity.class);
        i.putExtra("petid",2);

        startActivity(i);
    }
    public void sendMessagemal(View view)
    {
        Intent i = new Intent(smalldog.this,DetailActivity.class);
        i.putExtra("petid",3);

        startActivity(i);
    }
    public void sendMessagecock(View view)
    {
        Intent i = new Intent(smalldog.this,DetailActivity.class);
        i.putExtra("petid",5);

        startActivity(i);
    }
    public void sendMessagepug(View view)
    {
        Intent i = new Intent(smalldog.this,DetailActivity.class);
        i.putExtra("petid",4);


        startActivity(i);
    }
}
