package devandroid.thiago.applistacurso2023.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.thiago.applistacurso2023.model.Pessoa;

public class PessoaController {
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller", "Controller Iniciada");
        return super.toString();
    }


    public void salvar(Pessoa pessoa) {
        Log.i("MVC Controller", "Controller SALVAR " + pessoa.toString());    }
}
