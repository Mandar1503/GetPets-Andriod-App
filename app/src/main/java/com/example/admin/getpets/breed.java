package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class breed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);
    }
    public void sendMessagersmall(View view)
    {
        Intent i = new Intent(breed.this,smalldog.class);

        startActivity(i);
    }
    public void sendMessagermedium(View view)
    {
        Intent i = new Intent(breed.this,dogmedium.class);

        startActivity(i);
    }
    public void sendMessagerlarge(View view)
    {
        Intent i = new Intent(breed.this,largedog.class);

        startActivity(i);
    }
    public void sendMessagercancel(View view)
    {
        Intent i = new Intent(breed.this,Main3Activity.class);

        startActivity(i);
    }
}
