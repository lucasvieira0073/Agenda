package br.com.lucas.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {"Daniel", "Ronaldo", "Jeferson", "Felipe"};
        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);//alt + enter faz o import

        //convertendo Strings em Views
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, alunos);

        //vincula a lista com o adapter
        listaAlunos.setAdapter(adapter);




    }


}
