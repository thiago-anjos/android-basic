package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.thiago.applistacurso2023.R;
import devandroid.thiago.applistacurso2023.controller.CursoController;

public class CourseActivity extends AppCompatActivity {

    EditText editTextTextCourse;
    Button btn_voltar;
    Button btn_adicionar_curso;

    TextView nomeCurso;

    CursoController cursoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        editTextTextCourse = findViewById(R.id.editTextTextCourse);
        nomeCurso = findViewById(R.id.nomeCurso);
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_adicionar_curso = findViewById(R.id.btn_adicionar_curso);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(CourseActivity.this, MainActivity.class);
                startActivity(mainScreen);
                finish();
            }
        });

        btn_adicionar_curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeCurso.setText(editTextTextCourse.getText().toString());
            }
        });

    }


}