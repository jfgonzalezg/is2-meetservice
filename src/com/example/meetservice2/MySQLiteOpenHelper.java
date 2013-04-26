package com.example.meetservice2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "Service";
    private static final int DATABASE_VERSION = 1;
     
    public static class TablaUsuarios{
        public static String TABLA_USUARIOS = "usuarios";
        public static String COLUMNA_ID = "idu";
        public static String COLUMNA_NAME = "name";
        public static String COLUMNA_LAST = "lastname";
        public static String COLUMNA_EMAIL = "email";
        public static String COLUMNA_PROF = "prof";
        public static String COLUMNA_CITY = "city";
        public static String COLUMNA_ADDRESS = "address";
        public static String COLUMNA_USER = "user";
        public static String COLUMNA_PASSWORD = "password";
        
    }
     
    
    private static final String DATABASE_CREATE = "create table "
            + TablaUsuarios.TABLA_USUARIOS + "(" + TablaUsuarios.COLUMNA_ID
            + " integer primary key autoincrement, " + TablaUsuarios.COLUMNA_NAME
            + " text not null," +TablaUsuarios.COLUMNA_LAST
            + " text not null," +TablaUsuarios.COLUMNA_EMAIL
            + " text not null," +TablaUsuarios.COLUMNA_PROF
            + " text not null," +TablaUsuarios.COLUMNA_CITY
            + " text not null," +TablaUsuarios.COLUMNA_ADDRESS
            + " text not null," +TablaUsuarios.COLUMNA_USER
            + " text not null," +TablaUsuarios.COLUMNA_PASSWORD
            + " text not null);";

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
	

	@Override
	public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(DATABASE_CREATE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("delete table if exists " + TablaUsuarios.TABLA_USUARIOS);
        onCreate(db);
    }

}
