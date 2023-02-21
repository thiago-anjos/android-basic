package thiagoanjos.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import thiagoanjos.appminhaideia.R;
import thiagoanjos.appminhaideia.controller.ClienteController;
import thiagoanjos.appminhaideia.core.AppUtil;
import thiagoanjos.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    Cliente usuario;
    ClienteController clienteController;

    TextView txtAppVersion;

    int tempoDeEspera = 1000 * 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "Oncreate: Tela Splash carregada...");

        clienteController = new ClienteController();
        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.appVersion());

        trocarTela();
    }

    private void trocarTela() {
        Log.d(AppUtil.TAG, "Oncreate: Mudando de tela");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                usuario = new Cliente("thiago", "teste@gmail.com", "111111", 55, false);
                Log.d(AppUtil.TAG, "Esperando 10 segundos...");
                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);
                //enviar parametros para a main activity
                Bundle bundle = new Bundle();
                bundle.putString("nome", usuario.getNome());
                bundle.putString("email", usuario.getEmail());
                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}