package br.com.lucas.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {"Daniel", "Ronaldo", "Jeferson", "Felipe"};

        findViewById(R.id.lista_alunos);



    }


}
