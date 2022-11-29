package com.example.gestorincidencies;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

//Clase para la gestión de la base de datos.

public class GestorBD extends SQLiteOpenHelper {

    public GestorBD(Context context) {super(context, "M8", null, 1); }

    //Método para crear las tablas necesarias para nuestra base de datos.
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE incidences (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT, " +
                "object TEXT, " +
                "objectType TEXT, " +
                "location TEXT, " +
                "description TEXT, " +
                "date TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor selectAll () {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM incidences;",null);
        return c;

    }

    //Método para indiar la incidencia a dar de alta en la base de datos.
    public void insertIncidencia(ContentValues cv) {
        SQLiteDatabase db = getWritableDatabase();

        db.insertOrThrow("incidences", null, cv);
    }

}
