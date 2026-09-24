package com.example.alunamobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AlunoDao {
    private final DatabaseHelper helper;

    public AlunoDao(Context context) {
        helper = new DatabaseHelper(context);
    }

    public long inserirAluno(String ra, String nome, String email) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("ra", ra);
        valores.put("nome", nome);
        valores.put("email", email);
        try {
            return db.insertOrThrow("alunos", null, valores);
        } catch (Exception e) {
            return -1;
        } finally {
            db.close();
        }
    }
}
