package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.thiago.applistacurso2023.R;
import devandroid.thiago.applistacurso2023.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    Pessoa pessoaFeminina;

    String dadosPessoa;
    String dadosPessoaFeminina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Thiago");
        pessoa.setSobrenome("Anjos");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("879797798789798");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        pessoaFeminina = new Pessoa();
        pessoaFeminina.setPrimeiroNome("Luana");
        pessoaFeminina.setSobrenome("Lopes");
        pessoaFeminina.setCursoDesejado("Moda");
        pessoaFeminina.setTelefoneContato("12121212");


        dadosPessoaFeminina = "Primeiro nome: ";
        dadosPessoaFeminina += pessoaFeminina.getPrimeiroNome();
        dadosPessoaFeminina += " Sobrenome: ";
        dadosPessoaFeminina += pessoaFeminina.getSobrenome();
        dadosPessoaFeminina += " Curso desejado: ";
        dadosPessoaFeminina += pessoaFeminina.getCursoDesejado();
        dadosPessoaFeminina += " Telefone contato: ";
        dadosPessoaFeminina += pessoaFeminina.getTelefoneContato();

        Log.i("POO android", "Pessoa: " + pessoa.toString());
        Log.i("POO android", "Pessoa feminina: " + pessoaFeminina.toString());


    }
}