package devandroid.thiago.applistacurso2023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.thiago.applistacurso2023.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIMEOUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cumutarTelaSplash();

    }

    private void cumutarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainScreen = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainScreen);
                finish();
            }
        }, TIMEOUT_SPLASH);
    }
}