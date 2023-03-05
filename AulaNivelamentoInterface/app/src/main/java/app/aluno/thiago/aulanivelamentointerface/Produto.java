package app.aluno.thiago.aulanivelamentointerface;

import android.util.Log;

public class Produto implements ICrud{
    private static final String TAG = "CRUD";
    private String nome;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public void incluir() {
        Log.i(TAG, "incluir produto");
    }

    @Override
    public void alterar() {

    }

    @Override
    public void deletar() {

    }

    @Override
    public void listar() {

    }
}
