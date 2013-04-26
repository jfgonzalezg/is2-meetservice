package com.example.DAO;

import com.example.meetservice2.MySQLiteOpenHelper;
import com.example.meetservice2.MySQLiteOpenHelper.TablaUsuarios;
import com.example.negocio.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
	
	private SQLiteDatabase db;
    private MySQLiteOpenHelper dbHelper;
    private String[] columnas = { TablaUsuarios.COLUMNA_ID,
            TablaUsuarios.COLUMNA_NAME,TablaUsuarios.COLUMNA_LAST,TablaUsuarios.COLUMNA_EMAIL,
            TablaUsuarios.COLUMNA_PROF,TablaUsuarios.COLUMNA_CITY,
            TablaUsuarios.COLUMNA_ADDRESS,TablaUsuarios.COLUMNA_USER,TablaUsuarios.COLUMNA_PASSWORD, };
 
    public UserDAO(Context context) {
        dbHelper = new MySQLiteOpenHelper(context);
    }
 
    public void open() {
        db = dbHelper.getWritableDatabase();
    }
 
    public void close() {
        dbHelper.close();
    }
 
    public void crearUsuario(User us) {
    	
        ContentValues values = new ContentValues();
        values.put(TablaUsuarios.COLUMNA_NAME, us.getName() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getLastname() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getEmail() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getProfession() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getCity() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getAddress() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getUser() );
        values.put(TablaUsuarios.COLUMNA_NAME, us.getPassword() );
        
        db.insert(TablaUsuarios.TABLA_USUARIOS, null, values);
        
    }
 
}
