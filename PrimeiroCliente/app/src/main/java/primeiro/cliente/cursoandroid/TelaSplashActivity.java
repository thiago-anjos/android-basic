package primeiro.cliente.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class TelaSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        goToMainPage();
    }

    private void goToMainPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent changeScreen = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(changeScreen);
                finish();
            }
        }, 10000);
    }


}