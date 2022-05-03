package com.example.admin.getpets;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public  int petid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i= getIntent();
        petid = i.getIntExtra("petid",0);


        TextView weight = (TextView)findViewById(R.id.textView13);
        TextView height=(TextView)findViewById(R.id.textView14);
        TextView name = (TextView)findViewById(R.id.textView37);
        TextView availabilityText=(TextView)findViewById(R.id.textView15);
        TextView range=(TextView)findViewById(R.id.textView19);
        TextView fees=(TextView)findViewById(R.id.textView16);
        ImageView image1 = (ImageView) findViewById(R.id.imageView27);
        ImageView image2 = (ImageView) findViewById(R.id.imageView28);


        // TextView height=(TextView)findViewById(R.id.textView14);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        PetDetails pet = dbHandler.findHandler(petid);


        weight.setText("Weight:- " + pet.weight+" lbs");
        name.setText(pet.petName);
        height.setText("Height:-"+pet.height);
        range.setText("Longitivity Range:-" + pet.lifeExpectancy +" years");
        fees.setText("Adoption Fees:-"+pet.adoptionFees);
        availabilityText.setText("Availability:- " + pet.availability);




        String imageUri = "@drawable/" + pet.image1;
        int imageResource = getResources().getIdentifier(imageUri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource, getTheme());
        image1.setImageDrawable(res);


        String imageUri2 = "@drawable/" + pet.image2;
        int imageResource2 = getResources().getIdentifier(imageUri2, null, getPackageName());
        Drawable res2 = getResources().getDrawable(imageResource2, getTheme());
        image2.setImageDrawable(res2);

    }

    public void senddane(View view)
    {
        Intent i = new Intent(DetailActivity.this,BankActivityy.class);
        i.putExtra("petid",petid);
        startActivity(i);
    }
}
