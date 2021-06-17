package com.example.fatecmobile.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "RESGATFATEC.db";
    public static final String TABELAUSUARIOS = "USUARIOS";
    public static final String TABELATERCEIROS = "TERCEIROS";

    private static final int VERSAO_SCHEMA = 2;
    private final String S_CREATE;
    private final String S_CREATE2;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATE2 = "CREATE TABLE TERCEIROS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,DATANASCIMENTO TEXT,CPF TEXT,GENERO TEXT,ENDERECO TEXT,TELEFONE TEXT,EMAIL TEXT);";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE);
        db.execSQL(S_CREATE2);
        db.execSQL("INSERT INTO USUARIOS values (1, 'will','','','')");
        db.execSQL("INSERT INTO TERCEIROS values (1, 'Teste Terceiros','','','','','','')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELAUSUARIOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABELATERCEIROS);
        onCreate(db);
    }
}
