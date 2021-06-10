package com.example.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecmobile.modelos.TerceiroBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerTerceiro {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerTerceiro(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(TerceiroBean ter) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", ter.getNome());
        valores.put("DATANASCIMENTO", ter.getDatanascimento());
        valores.put("CPF", ter.getCpf());
        valores.put("GENERO", ter.getGenero());
        valores.put("ENDERECO", ter.getEndereco());
        valores.put("TELEFONE", ter.getTelefone());
        valores.put("EMAIL", ter.getEmail());
        resultado = db.insert(BancoHelper.TABELATERCEIROS, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(TerceiroBean ter) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID = " + ter.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELATERCEIROS,where,null);
        db.close();
        return retorno;
    }

    public String alterar(TerceiroBean ter) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + ter.getId();
        valores = new ContentValues();
        valores.put("NOME", ter.getNome());
        valores.put("DATANASCIMENTO", ter.getDatanascimento());
        valores.put("CPF", ter.getCpf());
        valores.put("GENERO", ter.getGenero());
        valores.put("ENDERECO", ter.getEndereco());
        valores.put("TELEFONE", ter.getTelefone());
        valores.put("EMAIL", ter.getEmail());
        db.update(BancoHelper.TABELATERCEIROS, valores,where,null);
        db.close();
        return retorno;
    }

    public List<TerceiroBean> listarTerceiros() {
        List<TerceiroBean> terceiros = new ArrayList<TerceiroBean>();
        String selectQuery = "SELECT * FROM TERCEIROS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                TerceiroBean ter = new TerceiroBean();
                ter.setId(""+cursor.getInt(0));
                ter.setNome(cursor.getString(1));
                ter.setDatanascimento(cursor.getString(2));
                ter.setCpf(cursor.getString(3));
                ter.setGenero(cursor.getString(4));
                ter.setEndereco(cursor.getString(5));
                ter.setTelefone(cursor.getString(6));
                ter.setEmail(cursor.getString(7));
                terceiros.add(ter);
            } while (cursor.moveToNext());
        }
        return terceiros;
    }

        public List<TerceiroBean> listarTerceiros(TerceiroBean terEnt) {
        List<TerceiroBean> terceiros = new ArrayList<TerceiroBean>();
        String parametro = terEnt.getNome();
        String selectQuery = "SELECT ID, NOME, DATANASCIMENTO, CFP, GENERO, ENDERECO, TELEFONE, EMAIL FROM TERCEIROS WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                TerceiroBean ter = new TerceiroBean();
                ter.setId(""+cursor.getInt(0));
                ter.setNome(cursor.getString(1));
                ter.setDatanascimento(cursor.getString(2));
                ter.setCpf(cursor.getString(3));
                ter.setGenero(cursor.getString(4));
                ter.setEndereco(cursor.getString(5));
                ter.setTelefone(cursor.getString(6));
                ter.setEmail(cursor.getString(7));
            } while (cursor.moveToNext());
        }
        return terceiros;
    }

    public TerceiroBean validarTerceiros(TerceiroBean terEnt) {
        TerceiroBean ter = new TerceiroBean();
        String nomePar = '"' + terEnt.getNome().trim() + '"';
        String datanascimentoPar = '"' + terEnt.getDatanascimento().trim() + '"';
        String cpfPar = '"' + terEnt.getCpf().trim() + '"';
        String generoPar = '"' + terEnt.getGenero().trim() + '"';
        String enderecoPar = '"' + terEnt.getEndereco().trim() + '"';
        String telefonePar = '"' + terEnt.getTelefone().trim() + '"';
        String emailPar = '"' + terEnt.getEmail().trim() + '"';


        String selectQuery = "SELECT ID, NOME, DATANASCIMENTO, CPF, GENERO, ENDERECO, TELEFONE, EMAIL FROM TERCEIROS WHERE NOME = ? AND DATANASCIMENTO = ? " ;
        String[] whereArgs = new String [] {nomePar,datanascimentoPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        ter.setNome("0 = " + nomePar + "1 = " +datanascimentoPar);
        if (cursor.moveToFirst()) {
            do {
                ter.setId(""+cursor.getInt(0));
                ter.setNome(cursor.getString(1));
                ter.setDatanascimento(cursor.getString(2));
                ter.setCpf(cursor.getString(3));
                ter.setGenero(cursor.getString(4));
                ter.setEndereco(cursor.getString(5));
                ter.setTelefone(cursor.getString(6));
                ter.setEmail(cursor.getString(7));
            } while (cursor.moveToNext());
        }
        return ter;
    }

    public List<TerceiroBean> listarTerceirosTeste() {
        List<TerceiroBean> terceiros = new ArrayList<TerceiroBean>();
        for (int i = 0; i < 10; i++ ) {
            TerceiroBean ter = new TerceiroBean();
            ter.setId(" Id " + i);
            ter.setNome(" Nome " + i);
            ter.setDatanascimento(" Data de Nascimento " + i);
            ter.setCpf(" CPF " + i);
            ter.setGenero(" Genero " + i);
            ter.setEndereco(" Endereço " + i);
            ter.setTelefone(" Telefone " + i);
            ter.setEmail(" Email " + i);

            terceiros.add(ter);
        }
        return terceiros;
    }



}
