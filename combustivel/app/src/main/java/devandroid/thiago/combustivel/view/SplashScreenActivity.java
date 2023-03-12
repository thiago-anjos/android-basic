package devandroid.thiago.combustivel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.thiago.combustivel.database.FuelDB;

public class SplashScreenActivity extends AppCompatActivity {

    FuelDB fuelDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fuelDB = new FuelDB(SplashScreenActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 1000);
    }
}