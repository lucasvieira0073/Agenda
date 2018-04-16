package br.com.lucas.agenda.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.lucas.agenda.R;
import br.com.lucas.agenda.dao.AlunoDAO;
import br.com.lucas.agenda.formulario.FormularioActivity;
import br.com.lucas.agenda.models.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Button btnNovoAluno = (Button) findViewById(R.id.lista_btn_novo);
        btnNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //de onde estamos e para onde vamos
                Intent intentVaiProFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarLista();
    }

    private void carregarLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);//alt + enter faz o import

        //convertendo Strings em Views
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_expandable_list_item_1, alunos);

        //vincula a lista com o adapter
        listaAlunos.setAdapter(adapter);

    }
}
