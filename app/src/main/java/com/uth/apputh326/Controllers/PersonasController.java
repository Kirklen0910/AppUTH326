package com.uth.apputh326.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uth.apputh326.Database.DBConfig;
import com.uth.apputh326.Database.DatabaseHelper;
import com.uth.apputh326.Models.Personas;

import java.util.ArrayList;
import java.util.List;

public class PersonasController {

    private final DatabaseHelper databaseHelper;

    public PersonasController(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public long insertarPersona(Personas persona) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(DBConfig.COLUMN_NOMBRES, persona.getNombre());
        valores.put(DBConfig.COLUMN_APELLIDOS, persona.getApellido());
        valores.put(DBConfig.COLUMN_FECHANAC, persona.getFechaNac());
        valores.put(DBConfig.COLUMN_DIRECCION, persona.getDireccion());
        valores.put(DBConfig.COLUMN_TELEFONO, persona.getTelefono());
        valores.put(DBConfig.COLUMN_CORREO, persona.getCorreo());

        long resultado = db.insert(DBConfig.TABLE_PERSONAS, null, valores);
        db.close();
        return resultado;
    }

    public List<Personas> obtenerPersonas() {
        List<Personas> lista = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(DBConfig.SELECT_TABLE_PERSONAS, null);

        if (cursor.moveToFirst()) {
            do {
                Personas p = new Personas();
                p.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_ID)));
                p.setNombre(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_NOMBRES)));
                p.setApellido(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_APELLIDOS)));
                p.setFechaNac(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_FECHANAC)));
                p.setDireccion(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_DIRECCION)));
                p.setTelefono(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_TELEFONO)));
                p.setCorreo(cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.COLUMN_CORREO)));
                lista.add(p);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }
}
