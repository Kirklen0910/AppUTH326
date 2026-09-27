package com.uth.apputh326.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.uth.apputh326.Database.DatabaseHelper;
import com.uth.apputh326.Models.Personas;

public class PersonasController
{
    private final DatabaseHelper databaseHelper;

    public PersonasController(Context context)
    {
        databaseHelper - new DatabaseHelper(context);
    }
}
