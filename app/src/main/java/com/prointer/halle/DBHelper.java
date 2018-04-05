package com.prointer.halle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by diogo on 04/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "Login_basededados";

    public DBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criação do banco de dados
        String str = "CREATE TABLE usuario (nome TEXT, email TEXT PRIMARY KEY, senha TEXT);";
        db.execSQL(str);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Criando a tabela usuário
        db.execSQL("DROP TABLE IF EXISTS usuario;");
        onCreate(db);

    }

    public long Criarusuario(String nome, String email, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("nome", nome);
        cv.put("email", email);
        cv.put("senha", senha);

        long resultado = db.insert("usuario", null, cv);

        return resultado;
    }

    public String Validarlogin(String email, String senha) {

        SQLiteDatabase db = getReadableDatabase();

        //Irá verificar os dados se estão corretos e no banco
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE email=? AND senha=?", new String[]{email, senha});

        if (cursor.getCount() > 0) {
            return "OK";
        }

        return "ERRO";
        //retornou
    }

    public String Pesquisarusuarios(String nome) {

        SQLiteDatabase db = getReadableDatabase();

        //Irá verificar os dados se estão corretos e no banco
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE nome=? ", new String[]{nome});

        if (cursor.getCount() > 0) {
            return "OK";
        }

        return "ERRO";
        //retornou
    }


}
