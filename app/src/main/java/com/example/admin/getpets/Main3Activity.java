package com.example.admin.getpets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    //private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }
    public void sendMessagei(View view)
    {
        Intent i = new Intent(Main3Activity.this,breed.class);

        startActivity(i);
    }
    public void sendMessageione(View view)
    {
        Intent i = new Intent(Main3Activity.this,CatActivity.class);

        startActivity(i);
    }

}
