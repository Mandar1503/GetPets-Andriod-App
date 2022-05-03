package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class largedog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_largedog);
    }
    public void sendalaskan(View view)
    {
        Intent i = new Intent(largedog.this,DetailActivity.class);
        i.putExtra("petid",8);
        startActivity(i);
    }
    public void sendfrench(View view)
    {
        Intent i = new Intent(largedog.this,DetailActivity.class);
        i.putExtra("petid",9);
        startActivity(i);
    }
    public void senddane(View view)
    {
        Intent i = new Intent(largedog.this,DetailActivity.class);
        i.putExtra("petid",10);
        startActivity(i);
    }

}
