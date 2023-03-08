package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.thiago.applistacurso2023.R;
import devandroid.thiago.applistacurso2023.controller.PessoaController;
import devandroid.thiago.applistacurso2023.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String NOME_PREFERENCES = "pref_lista_vip";
    PessoaController pessoaController;
    Pessoa pessoa;
    EditText field_nome;
    EditText txt_sobrenome;
    EditText txt_curso;
    EditText txt_contato;

    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        pessoaController = new PessoaController();

        pessoaController.toString();

        sharedPreferences = getSharedPreferences(NOME_PREFERENCES,0);
        SharedPreferences.Editor listaVip = sharedPreferences.edit();

        //setar valores no objeto pessoa do xml
        pessoa.setPrimeiroNome(sharedPreferences.getString("nome","N/A"));
        pessoa.setSobrenome(sharedPreferences.getString("sobrenome","N/A"));
        pessoa.setCursoDesejado(sharedPreferences.getString("curso","N/A"));
        pessoa.setTelefoneContato(sharedPreferences.getString("contato","N/A"));

        field_nome = findViewById(R.id.txt_nome);
        txt_sobrenome = findViewById(R.id.txt_sobrenome);
        txt_curso = findViewById(R.id.txt_curso);
        txt_contato = findViewById(R.id.txt_contato);

        //mostrar na tela os dados
        field_nome.setText(pessoa.getPrimeiroNome());
        txt_sobrenome.setText(pessoa.getSobrenome());
        txt_curso.setText(pessoa.getCursoDesejado());
        txt_contato.setText(pessoa.getTelefoneContato());

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        field_nome.setText(pessoa.getPrimeiroNome());
        txt_sobrenome.setText(pessoa.getSobrenome());
        txt_curso.setText(pessoa.getCursoDesejado());
        txt_contato.setText(pessoa.getTelefoneContato());

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                field_nome.setText("");
                txt_sobrenome.setText("");
                txt_curso.setText("");
                txt_contato.setText("");

                listaVip.clear();
                listaVip.apply();

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
                pessoa.setSobrenome(txt_sobrenome.getText().toString());
                pessoa.setCursoDesejado(txt_curso.getText().toString());
                pessoa.setTelefoneContato(txt_contato.getText().toString());
                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("nome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobrenome());
                listaVip.putString("curso", pessoa.getCursoDesejado());
                listaVip.putString("contato", pessoa.getTelefoneContato());
                //salvar dados usuário no arquivo xml preferences
                listaVip.apply();
                pessoaController.salvar(pessoa);

            }
        });

        Log.i("POO android", "Pessoa: " + pessoa.toString());

    }
}