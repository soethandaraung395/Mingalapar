package com.firstappsta.mingalapar.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBWord extends SQLiteOpenHelper{

    private Context context;
    private static final String DB_NAME = "Mingalapar.db";
    private static final int DB_VERSION = 1;

    //cloumn names
    private static final String COL_ID = "id";
    private static final String COL_TITLE_MM = "titlemm";
    private static final String COL_TITLE_ENG = "titleeng";
    private static final String COL_IMAGE_ID = "imageid";
    private static final String COL_VOICE_ID = "voiceid";
    private static final String COL_DESC_ID = "description";

    //Animals Table
    public static final String TABLE_ANIMALS = "animals";
    private static final String CREATE_TABLE_ANIMALS = "CREATE TABLE " + TABLE_ANIMALS + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_ANIMALS = "DROP TABLE IF EXISTS " + TABLE_ANIMALS;

    //Number Table
    public static final  String TABLE_NUMBER = "number";
    private static final String CREATE_TABLE_NUMBER = "CREATE TABLE " + TABLE_NUMBER + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_NUMBER = "DROP TABLE IF EXISTS " + TABLE_NUMBER;

    //Color Table
    public static final  String TABLE_COLOR = "color";
    private static final String CREATE_TABLE_COLOR = "CREATE TABLE " + TABLE_COLOR + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_COLOR = "DROP TABLE IF EXISTS " + TABLE_COLOR;

    //Fruit Table
    public static final  String TABLE_FRUIT = "fruit";
    private static final String CREATE_TABLE_FRUIT = "CREATE TABLE " + TABLE_FRUIT + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_FRUIT = "DROP TABLE IF EXISTS " + TABLE_FRUIT;

    //Family Table
    public static final  String TABLE_FAMILY = "family";
    private static final String CREATE_TABLE_FAMILY = "CREATE TABLE " + TABLE_FAMILY + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_DESC_ID + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), " + COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_FAMILY = "DROP TABLE IF EXISTS " + TABLE_FAMILY;

    //Body Part Table
    public static final  String TABLE_BODYPART = "bodypart";
    private static final String CREATE_TABLE_BODYPART = "CREATE TABLE " + TABLE_BODYPART + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_BODYPART = "DROP TABLE IF EXISTS " + TABLE_BODYPART;

    //Occupation Table
    public static final  String TABLE_OCCUPATION = "occupation";
    private static final String CREATE_TABLE_OCCUPATION = "CREATE TABLE " + TABLE_OCCUPATION + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_OCCUPATION = "DROP TABLE IF EXISTS " + TABLE_OCCUPATION;

    //Vegetable Table
    public static final  String TABLE_VEGETABLE = "vegetable";
    private static final String CREATE_TABLE_VEGETABLE = "CREATE TABLE " + TABLE_VEGETABLE + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_VEGETABLE = "DROP TABLE IF EXISTS " + TABLE_VEGETABLE;

    //Transportation Table
    public static final  String TABLE_TRANSPORTATION = "transportation";
    private static final String CREATE_TABLE_TRANSPORTATION = "CREATE TABLE " + TABLE_TRANSPORTATION + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_TRANSPORTATION = "DROP TABLE IF EXISTS " + TABLE_TRANSPORTATION;

    //Flower Table
    public static final  String TABLE_FLOWER = "flower";
    private static final String CREATE_TABLE_FLOWER = "CREATE TABLE " + TABLE_FLOWER + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_FLOWER = "DROP TABLE IF EXISTS " + TABLE_FLOWER;

    //Month_Day Table
    public static final  String TABLE_MONTH_DAY = "monthday";
    private static final String CREATE_TABLE_MONTH_DAY = "CREATE TABLE " + TABLE_MONTH_DAY + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL_TITLE_MM + " VARCHAR(255), " + COL_TITLE_ENG + " VARCHAR(255), " + COL_IMAGE_ID + " INTEGER(11), "+ COL_VOICE_ID +  " INTEGER(11));";
    private static final String DROP_TABLE_MONTH_DAY = "DROP TABLE IF EXISTS " + TABLE_MONTH_DAY;




    private static DBWord dbWord;
    public static DBWord getInstance(Context context) {
        if (dbWord == null) {
            dbWord = new DBWord(context);
        }
        return dbWord;
    }


    public DBWord(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ANIMALS);
        sqLiteDatabase.execSQL(CREATE_TABLE_NUMBER);
        sqLiteDatabase.execSQL(CREATE_TABLE_COLOR);
        sqLiteDatabase.execSQL(CREATE_TABLE_FRUIT);
        sqLiteDatabase.execSQL(CREATE_TABLE_FAMILY);
        sqLiteDatabase.execSQL(CREATE_TABLE_BODYPART);
        sqLiteDatabase.execSQL(CREATE_TABLE_OCCUPATION);
        sqLiteDatabase.execSQL(CREATE_TABLE_VEGETABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRANSPORTATION);
        sqLiteDatabase.execSQL(CREATE_TABLE_FLOWER);
        sqLiteDatabase.execSQL(CREATE_TABLE_MONTH_DAY);

        //add quiz data
//        SQLiteDatabase db = this.getWritableDatabase();
        setData(sqLiteDatabase,TABLE_ANIMALS,DBDefaultData.getAnimals());
        setData(sqLiteDatabase,TABLE_NUMBER,DBDefaultData.getNumber());
        setData(sqLiteDatabase,TABLE_COLOR,DBDefaultData.getColor());
        setData(sqLiteDatabase,TABLE_FRUIT,DBDefaultData.getFruit());
        setData(sqLiteDatabase,TABLE_FAMILY,DBDefaultData.getFamily());
        setData(sqLiteDatabase,TABLE_BODYPART,DBDefaultData.getBodypart());
        setData(sqLiteDatabase,TABLE_OCCUPATION,DBDefaultData.getOccupation());
        setData(sqLiteDatabase,TABLE_VEGETABLE,DBDefaultData.getVegetable());
        setData(sqLiteDatabase,TABLE_TRANSPORTATION,DBDefaultData.getTransportation());
        setData(sqLiteDatabase,TABLE_FLOWER,DBDefaultData.getFlower());
        setData(sqLiteDatabase,TABLE_MONTH_DAY,DBDefaultData.getMonthDay());


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_ANIMALS);
        sqLiteDatabase.execSQL(DROP_TABLE_NUMBER);
        sqLiteDatabase.execSQL(DROP_TABLE_COLOR);
        sqLiteDatabase.execSQL(DROP_TABLE_FRUIT);
        sqLiteDatabase.execSQL(DROP_TABLE_FAMILY);
        sqLiteDatabase.execSQL(DROP_TABLE_BODYPART);
        sqLiteDatabase.execSQL(DROP_TABLE_OCCUPATION);
        sqLiteDatabase.execSQL(DROP_TABLE_VEGETABLE);
        sqLiteDatabase.execSQL(DROP_TABLE_TRANSPORTATION);
        sqLiteDatabase.execSQL(DROP_TABLE_FLOWER);
        sqLiteDatabase.execSQL(DROP_TABLE_MONTH_DAY);
        onCreate(sqLiteDatabase);
    }



    public void setData(SQLiteDatabase db, String tableName, ArrayList<WordData> datas){
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (WordData data : datas) {
                values.put(COL_TITLE_MM, data.getTextMm());
                values.put(COL_TITLE_ENG, data.getTextEng());
                if(tableName.equals(TABLE_FAMILY)) {
                    values.put(COL_DESC_ID, data.getDesc());
                }
                values.put(COL_IMAGE_ID, data.getImgId());
                values.put(COL_VOICE_ID, data.getVoiceId());
                db.insert(tableName, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
//            db.close();
        }
    }

    public ArrayList<WordData> getData(String tableName) {

        ArrayList<WordData> datas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        String coloumn1[] = {COL_ID, COL_TITLE_MM, COL_TITLE_ENG, COL_IMAGE_ID, COL_VOICE_ID};
        String coloumn2[] = {COL_ID, COL_TITLE_MM, COL_TITLE_ENG, COL_DESC_ID, COL_IMAGE_ID, COL_VOICE_ID};
        String coloumn[] = coloumn1;
        if(tableName.equals(TABLE_FAMILY)){coloumn = coloumn2;}

        Cursor cursor = db.query(tableName, coloumn, null, null, null, null, null);

        while (cursor.moveToNext()) {
            WordData data;
//            title.setId(cursor.getInt(0));
            if(tableName.equals(TABLE_FAMILY)){
                data = new WordData(cursor.getString(1),cursor.getString(2),cursor.getInt(4),cursor.getInt(5),cursor.getString(3));
            }else{
                data = new WordData(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4));
            }
            datas.add(data);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
//        db.close();
        return datas;
    }

}
