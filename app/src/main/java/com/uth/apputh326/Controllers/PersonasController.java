package com.uth.apputh326.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.uth.apputh326.Database.DatabaseHelper;
import com.uth.apputh326.Models.Personas;

public class PersonasController {

    private final DatabaseHelper databaseHelper;

    public PersonasController(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    // Insertar persona
    public long insertarPersona(Personas persona) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nombre", persona.getNombre());
        valores.put("apellido", persona.getApellido());
        valores.put("fechaNac", persona.getFechaNac());
        valores.put("direccion", persona.getDireccion());
        valores.put("telefono", persona.getTelefono());
        valores.put("correo", persona.getCorreo());

        long resultado = db.insert("personas", null, valores);
        db.close();
        return resultado;
    }
}
