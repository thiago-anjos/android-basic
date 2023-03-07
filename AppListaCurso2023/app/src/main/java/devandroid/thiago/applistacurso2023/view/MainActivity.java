package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import devandroid.thiago.applistacurso2023.R;
import devandroid.thiago.applistacurso2023.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Pessoa pessoaFeminina;
    String dadosPessoa;
    String dadosPessoaFeminina;

    EditText txt_nome;
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
        pessoa.setPrimeiroNome("Thiago");
        pessoa.setSobrenome("Anjos");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("(11) 96076-4638");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        txt_nome = findViewById(R.id.txt_nome);
        txt_sobrenome = findViewById(R.id.txt_sobrenome);
        txt_curso = findViewById(R.id.txt_curso);
        txt_contato = findViewById(R.id.txt_contato);

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        txt_nome.setText(pessoa.getPrimeiroNome());
        txt_sobrenome.setText(pessoa.getSobrenome());
        txt_curso.setText(pessoa.getCursoDesejado());
        txt_contato.setText(pessoa.getTelefoneContato());


        Log.i("POO android", "Pessoa: " + pessoa.toString());


    }
}