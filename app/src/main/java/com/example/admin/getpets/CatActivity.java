package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
    }
    public void sendMessagebcat(View view)
    {
        Intent i = new Intent(CatActivity.this,DetailActivity.class);
        i.putExtra("petid",11);
        startActivity(i);
    }
    public void sendMessagetcat(View view)
    {
        Intent i = new Intent(CatActivity.this,DetailActivity.class);
        i.putExtra("petid",12);
        startActivity(i);
    }
    public void sendMessagewcat(View view)
    {
        Intent i = new Intent(CatActivity.this,DetailActivity.class);
        i.putExtra("petid",13);
        startActivity(i);
    }
}
