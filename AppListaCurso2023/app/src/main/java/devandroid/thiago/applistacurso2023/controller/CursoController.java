package devandroid.thiago.applistacurso2023.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.thiago.applistacurso2023.model.Curso;

public class CursoController {

    private List listCursos;
    public List getListaCursos(){
        listCursos = new ArrayList<Curso>();
        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("Angular"));
        listCursos.add(new Curso("React"));
        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>();
        for(int i =0; i < getListaCursos().size(); i++){
            Curso itens = (Curso) getListaCursos().get(i);
            dados.add(itens.getNomeCurso());
        }
        return dados;
    }

}
