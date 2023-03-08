package devandroid.thiago.applistacurso2023.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.thiago.applistacurso2023.model.Pessoa;
import devandroid.thiago.applistacurso2023.view.MainActivity;

public class PessoaController {

    SharedPreferences sharedPreferences;
    public static final String NOME_PREFERENCES = "pref_lista_vip";
    // variavel lista do tipo sharepreferences editor
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = sharedPreferences.edit();
    }

    public void saveVipList(Pessoa pessoa) {
        Log.i("MVC Controller", "Controller SALVAR " + pessoa.toString());
        listaVip.putString("nome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("curso", pessoa.getCursoDesejado());
        listaVip.putString("contato", pessoa.getTelefoneContato());
        //salvar dados usuário no arquivo xml preferences
        listaVip.apply();
    }

    public Pessoa search(Pessoa pessoa) {
        //setar valores no objeto pessoa do xml
        pessoa.setPrimeiroNome(sharedPreferences.getString("nome", "N/A"));
        pessoa.setSobrenome(sharedPreferences.getString("sobrenome", "N/A"));
        pessoa.setCursoDesejado(sharedPreferences.getString("curso", "N/A"));
        pessoa.setTelefoneContato(sharedPreferences.getString("contato", "N/A"));
        return pessoa;
    }

    public void clearListVip() {
        listaVip.clear();
        listaVip.apply();
    }
}
