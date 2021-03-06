package br.com.lucas.agenda.formulario;

import android.widget.EditText;
import android.widget.RatingBar;

import  br.com.lucas.agenda.models.Aluno;
import br.com.lucas.agenda.R;
import br.com.lucas.agenda.formulario.FormularioActivity;

public class FormularioHelper {

    EditText campoNome;
    EditText campoEndereco;
    EditText campoTelefone;
    EditText campoSite;
    RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
    }

    public Aluno pegaAluno() {
        Aluno aluno = new Aluno(
                campoNome.getText().toString(),
                campoEndereco.getText().toString(),
                campoTelefone.getText().toString(),
                campoSite.getText().toString(),
                Double.valueOf(campoNota.getProgress())
        );


        return aluno;
    }

}
