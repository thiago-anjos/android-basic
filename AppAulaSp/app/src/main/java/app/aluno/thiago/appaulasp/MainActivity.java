package app.aluno.thiago.appaulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App Aula Shared Preferences";
    private static final String PREF_NOME = "App_Aula_SP_PREF";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Oncreate: Rodando");
        Log.i(TAG, "Oncreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "Oncreate: Pasta Shared Criada");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 123456;
        precoProduto = 1.8f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoqueProduto", estoque);
        dados.apply();

        //modo debug
        Log.i(TAG, "Dados para serem salvos");
        Log.i(TAG, "produto"+nomeProduto);
        Log.i(TAG, "codigo"+codigoProduto);
        Log.i(TAG, "preco"+precoProduto);
        Log.i(TAG, "estoque"+estoque);

        //limpar o arquivo;
        //dados.clear();
        //dados.apply();

        //apagar um campo
        //dados.remove("estoque");

        Log.i(TAG, "Dados recuperados");
        Log.d(TAG, "produto"+sharedPreferences.getString("nomeProduto ", "N/D"));
        Log.d(TAG, "codigo"+sharedPreferences.getInt("codigoProduto ", -1));
        Log.d(TAG, "preco"+sharedPreferences.getFloat("precoProduto ", -1f));
        Log.d(TAG, "estoque"+sharedPreferences.getBoolean("estoque ", true));

    }
}