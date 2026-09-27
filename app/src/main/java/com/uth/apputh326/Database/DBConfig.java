package com.uth.apputh326.Database;

public class DBConfig
{
    private static final String DATABASE_NAME = "personas.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PERSONAS = "personas.db";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRES = "nombre";
    private static final String COLUMN_APELLIDOS = "apellido";
    private static final String COLUMN_DIRECCION = "direccion";
    private static final String COLUMN_FECHANAC = "fechaNac";
    private static final String COLUMN_TELEFONO = "telefono";
    private static final String COLUMN_CORREO = "correo";

    public static final String CREATE_TABLE_PERSONAS = "CREATE TABLE "
            + TABLE_PERSONAS + " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT , "
            + COLUMN_NOMBRES + " TEXT NOT NULL , "
            + COLUMN_APELLIDOS + " TEXT NOT NULL , "
            + COLUMN_FECHANAC + " TEXT NOT NULL , "
            + COLUMN_DIRECCION + " TEXT , "
            + COLUMN_TELEFONO + " TEXT , "
            + COLUMN_CORREO + " TEXT ) ";

    public static final String DROP_TABLE_PERSONAS = "DROP TABLE IF EXIST " + TABLE_PERSONAS;

    public static final String SELECT_TABLE_PERSONAS = "SELECT * FROM " + TABLE_PERSONAS;


}
