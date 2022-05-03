package com.example.admin.getpets;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.view.ViewPropertyAnimatorListener;

import java.util.IdentityHashMap;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "petDb.db";
    public static final String TABLE_NAME = "PetDetails";
    public static final String TABLE_NAME1 = "CardDetails";
    public static final String ID = "PetID";
    public static final String NAME = "PetName";
    public static final String WEIGHT = "Weight";
    public static final String HEIGHT = "Height";
    public static final String LIFEEXPECTANCY = "Lifeexpectancy";
    public static final String AVAILABILITY = "Availabilty";
    public static final String ADOPTIONFEES = "Adoptionfees";
    public static final String IMAGEURI = "Imageuri";
    public static final String IMAGEURI2 = "Imageuri2";
    public static final String CARDNO= "cardno";
    public static final String CARDNAME = "cardname";
    public static final String DATE = "date";
    public static final String CVV = "cvv";






    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY, "
                + NAME + " TEXT, "
                + WEIGHT + " REAL, "
                + HEIGHT + " REAL, "
                + LIFEEXPECTANCY + " INTEGER, "
                + AVAILABILITY + " INTEGER, "
                + ADOPTIONFEES + " INTEGER, "
                + IMAGEURI + " TEXT, "
                + IMAGEURI2 + " TEXT "
                +")";
        db.execSQL(CREATE_TABLE);

        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME1 + "(" +
                CARDNO + " BIGINT PRIMARY KEY, "
                + CARDNAME + " TEXT, "
                + DATE + " INTEGER, "
                + CVV + " INTEGER "
                +")";
        db.execSQL(CREATE_TABLE2);

        ContentValues dalmation = GetPetDetais(1,"Dalmation", 25, 25.5,
                5,11,15000,"dalmation1","dalmation2");
        db.insert(TABLE_NAME, null, dalmation);

        ContentValues jack = GetPetDetais(2,"Jack Rusell Terrier", 13, 14,13,
                5,25000,"shuttera1","shutter2");
        db.insert(TABLE_NAME, null, jack);

        ContentValues maltese = GetPetDetais(3,"Maltese", 110, 1.2,12,
                4,150000,"maltesea1","download");
        db.insert(TABLE_NAME, null, maltese);

        ContentValues pug = GetPetDetais(4,"Pug", 14, 10,12,
                9,18000,"puga1","mypug");
        db.insert(TABLE_NAME, null, pug);

        ContentValues spaniel = GetPetDetais(5,"Cocker Spaniel", 24, 1.2,9,
                8,18000,"cockerpaniela1","cockerpaniel2");
        db.insert(TABLE_NAME, null, spaniel);

        ContentValues golden = GetPetDetais(6,"Golden Retriver", 65, 1.5,12,
                12,35000,"golden2","goldenretriver2");
        db.insert(TABLE_NAME, null, golden);

        ContentValues husky = GetPetDetais(7,"Husky", 60, 1.8,14,
                6,80000,"husky1","husky2");
        db.insert(TABLE_NAME, null, husky);

        ContentValues alaskan = GetPetDetais(8,"Alakan Malamute", 120, 1.11,15,
                8,35000,"alaskanmalamute1","alaskanmalamute3");
        db.insert(TABLE_NAME, null, alaskan);

        ContentValues french = GetPetDetais(9,"French Mashtiff", 130, 1.6,8,
                3,75000,"frenchmastiff","mastif2");
        db.insert(TABLE_NAME, null, french);

        ContentValues dane = GetPetDetais(10,"Great Dane", 115, 1.8,10,
                5,35000,"greatdane1","greatdane2");
        db.insert(TABLE_NAME, null, dane);

        ContentValues blackcat = GetPetDetais(11,"Persian Black Cat", 10, 11,7,
                9,8000,"bcat","images1");
        db.insert(TABLE_NAME, null, blackcat);

        ContentValues siamesecat = GetPetDetais(12,"Siamese Kitten", 11, 1,17,
                4,60000,"scat","sscat");
        db.insert(TABLE_NAME, null,siamesecat );

        ContentValues whitecat = GetPetDetais(13,"Persian pure white Kitten", 9, 1.2,12,
                2,35000,"wcat","images");
        db.insert(TABLE_NAME, null,whitecat );





        // db.close();
    }

    private ContentValues GetPetDetais(int id, String name, double weight, double height,
                              int lifeExpectancy, int availability, int adoptionfees,
                                       String imageuri,String imageuri2)
    {
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(WEIGHT, weight);
        values.put(HEIGHT, height);
        values.put(LIFEEXPECTANCY, lifeExpectancy);
        values.put(AVAILABILITY, availability);
        values.put(ADOPTIONFEES, adoptionfees);
        values.put(IMAGEURI,imageuri);
        values.put(IMAGEURI2,imageuri2);
        return values;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
   // public String loadHandler() {}
    //public void addHandler(PetDetails petDetail) {}
    public PetDetails findHandler(int petId) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + ID + " = "  + petId;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        PetDetails pet = new PetDetails();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            pet.petID = Integer.parseInt(cursor.getString(0));
            pet.petName = cursor.getString(1);
            pet.weight = Double.parseDouble(cursor.getString(2));
            pet.height = Double.parseDouble(cursor.getString(3));
            pet.lifeExpectancy = Integer.parseInt(cursor.getString(4));
            pet.availability = Integer.parseInt(cursor.getString(5));
            pet.adoptionFees = Integer.parseInt(cursor.getString(6));
            pet.image1=cursor.getString(7);
            pet.image2=cursor.getString(8);
            cursor.close();
        } else {
            pet = null;
        }
        //db.close();
        return pet;
    }

    public boolean addHandler(CardDetails card) {

        if(card != null && card.cardno > 0){

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues args = new ContentValues();
            args.put(CARDNO, card.cardno);
            args.put(CARDNAME, card.Name);
            args.put(DATE, card.date);
            args.put(CVV, card.cvv);

            return db.insert(TABLE_NAME1, null, args) > 0;
        }
        return true;
    }

    public boolean updateHandler(int petId) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + ID + " = "  + petId;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        PetDetails pet = new PetDetails();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            pet.petID = Integer.parseInt(cursor.getString(0));
            pet.petName = cursor.getString(1);
            pet.weight = Double.parseDouble(cursor.getString(2));
            pet.height = Double.parseDouble(cursor.getString(3));
            pet.lifeExpectancy = Integer.parseInt(cursor.getString(4));
            pet.availability = Integer.parseInt(cursor.getString(5));
            pet.adoptionFees = Integer.parseInt(cursor.getString(6));
            cursor.close();
        } else {
            pet = null;
        }

        if(pet != null && pet.availability > 0){
            Integer petAvailability = pet.availability - 1;
            //SQLiteDatabase db = this.getWritableDatabase();
            ContentValues args = new ContentValues();
            args.put(ID, petId);
            args.put(AVAILABILITY, petAvailability);
            return db.update(TABLE_NAME, args, ID + "=" + petId, null) > 0;
        }
        return true;
    }
}
