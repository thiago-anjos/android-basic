package app.aluno.thiago.aulanivelamentointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Client client;
    Produto produto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new Client();
        client.setNome("Thiago");
        client.setEmail("teste@gmail.com");
        client.incluir();

        produto = new Produto();
        produto.setFornecedor("Magazine Luiza");
        produto.incluir();

    }
}