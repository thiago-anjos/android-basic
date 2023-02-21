package primeiro.nivelamento.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import primeiro.nivelamento.java.model.Client;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP NIVELAMENTO";
    Client objClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objClient = new Client("Thiago", "thiago@gmail.com", "11960764638", 35, false);

        Log.i(TAG, "Oncreate: ObjClient Nome:"+objClient.getNome());
        Log.i(TAG, "Oncreate: ObjClient Email:"+objClient.getEmail());
    }
}