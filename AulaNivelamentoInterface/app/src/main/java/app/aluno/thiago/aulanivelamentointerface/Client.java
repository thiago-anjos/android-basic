package app.aluno.thiago.aulanivelamentointerface;

import android.util.Log;

public class Client implements ICrud{
    private static final String TAG = "CRUD";
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        Log.i(TAG, "incluir cliente");
    }

    @Override
    public void alterar() {
        Log.i(TAG, "alterar cliente");

    }

    @Override
    public void deletar() {
        Log.i(TAG, "incluir cliente");

    }

    @Override
    public void listar() {
        Log.i(TAG, "listar clientes");

    }
}
