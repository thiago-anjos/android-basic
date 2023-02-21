package thiagoanjos.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import thiagoanjos.appminhaideia.R;
import thiagoanjos.appminhaideia.model.Cliente;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEIA";

    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Oncreate: Tela Principal carregada...");

        Bundle bundle = getIntent().getExtras();

        Log.d(TAG, "Bundle nome" + bundle.getString("nome"));
        Log.d(TAG, "Bundle email" + bundle.getString("email"));

        txtNome = findViewById(R.id.txtNome);
        txtNome.setText("Olá "+bundle.getString("nome")+" bem-vindo");

    }
}
