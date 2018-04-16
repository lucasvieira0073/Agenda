package br.com.lucas.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.lucas.agenda.models.Aluno;

public class AlunoDAO extends SQLiteOpenHelper {


    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, " +
                "endereco TEXT, telefone TEXT, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos;";
        db.execSQL(sql);
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEndereco());
        dados.put("telefone", aluno.getTelefone());
        dados.put("site", aluno.getSite());
        dados.put("nota", aluno.getNota());

        db.insert("Alunos", null, dados);

    }

    public List<Aluno> buscaAlunos() {
        String sql = "SELECT * FROM Alunos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql , null);
        c.moveToNext();

        List<Aluno> alunos = new ArrayList<Aluno>();

        while(c.moveToNext()) {
            Aluno aluno = new Aluno(
                    c.getLong(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("nome")),
                    c.getString(c.getColumnIndex("endereco")),
                    c.getString(c.getColumnIndex("telefone")),
                    c.getString(c.getColumnIndex("site")),
                    c.getDouble(c.getColumnIndex("nota"))
            );

            alunos.add(aluno);
        }

        c.close();

        return alunos;
    }
}
