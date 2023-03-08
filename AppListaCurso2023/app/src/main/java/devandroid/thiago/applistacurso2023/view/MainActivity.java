package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.thiago.applistacurso2023.R;
import devandroid.thiago.applistacurso2023.controller.PessoaController;
import devandroid.thiago.applistacurso2023.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController pessoaController;
    Pessoa pessoa;
    EditText field_nome;
    EditText field_sobrenome;
    EditText field_curso;
    EditText field_contato;

    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoaController = new PessoaController(MainActivity.this);
        pessoaController.search(pessoa);

        field_nome = findViewById(R.id.txt_nome);
        field_sobrenome = findViewById(R.id.txt_sobrenome);
        field_curso = findViewById(R.id.txt_curso);
        field_contato = findViewById(R.id.txt_contato);

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        //mostrar na tela os dados
        field_nome.setText(pessoa.getPrimeiroNome());
        field_sobrenome.setText(pessoa.getSobrenome());
        field_curso.setText(pessoa.getCursoDesejado());
        field_contato.setText(pessoa.getTelefoneContato());

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                field_nome.setText("");
                field_sobrenome.setText("");
                field_curso.setText("");
                field_contato.setText("");
                pessoaController.clearListVip();
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(field_nome.getText().toString());
                pessoa.setSobrenome(field_sobrenome.getText().toString());
                pessoa.setCursoDesejado(field_curso.getText().toString());
                pessoa.setTelefoneContato(field_contato.getText().toString());
                pessoaController.saveVipList(pessoa);
                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}