package com.android.pedro.aulabanco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

/**
 * Created by pedro on 10/05/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Agenda";
    private static final int DATABASE_VERSION = 1;
    private static String TABLE_CONTATOS = "CREATE TABLE contatos(" +
            "id INTEGER PRIMARY KEY AUTOINCREMEN T," +
            "nome TEXT, telefone TEXT";


    DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CONTATOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contatos");
        onCreate(db);
    }
}
