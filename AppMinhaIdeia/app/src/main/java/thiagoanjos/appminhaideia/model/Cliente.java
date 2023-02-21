package thiagoanjos.appminhaideia.model;

import android.util.Log;

// Pojo
public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private Number idade;
    private Boolean sexo;

    public Cliente(String nome, String email, String telefone, Number idade, Boolean sexo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.sexo = sexo;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Number getIdade() {
        return idade;
    }

    public void setIdade(Number idade) {
        this.idade = idade;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }
}