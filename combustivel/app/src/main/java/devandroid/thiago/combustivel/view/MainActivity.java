package devandroid.thiago.combustivel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import devandroid.thiago.combustivel.R;
import devandroid.thiago.combustivel.controller.FuelController;
import devandroid.thiago.combustivel.model.Fuel;
import utils.CalculateFuel;

public class MainActivity extends AppCompatActivity {

    FuelController fuelController;
    CalculateFuel calculateFuel;
    Fuel fuel;
    Fuel gasolineFuel;
    Fuel ethanolFuel;

    EditText text_gasolina;
    EditText text_etanol;
    TextView text_title_calcular;
    Button btn_calcular;
    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    double gasolinePrice;
    double ethanolPrice;
    String suggestedFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fuelController = new FuelController(MainActivity.this);

        text_gasolina = findViewById(R.id.text_gasolina);
        text_etanol = findViewById(R.id.text_etanol);
        text_title_calcular = findViewById(R.id.text_title_calcular);
        btn_calcular = findViewById(R.id.btn_calcular);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        //esconder botão salvar
        btn_salvar.setAlpha(0);


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valid = true;

                if(TextUtils.isEmpty(text_etanol.getText())){
                    text_etanol.setError("* Campo obrigatório");
                    text_etanol.requestFocus();
                    valid = false;
                }
                if(TextUtils.isEmpty(text_gasolina.getText())){
                    text_gasolina.setError("* Campo obrigatório");
                    text_gasolina.requestFocus();
                    valid = false;
                }

                if(valid){
                    gasolinePrice = Double.parseDouble(text_gasolina.getText().toString());
                    ethanolPrice = Double.parseDouble(text_etanol.getText().toString());
                    suggestedFuel = calculateFuel.CalculateFuelBestOption(gasolinePrice, ethanolPrice);
                    text_title_calcular.setText(suggestedFuel);
                    btn_salvar.setEnabled(true);
                }else{
                    btn_salvar.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Digite os dados obrigatórios",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_gasolina.setText("");
                text_etanol.setText("");
                text_title_calcular.setText("");
                btn_salvar.setEnabled(false);
                fuelController.CleanPreferences();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gasolineFuel = new Fuel();
                gasolineFuel.setFuelName("Gasolina");
                gasolineFuel.setFuelPrice(gasolinePrice);
                gasolineFuel.setSuggestedPrice(suggestedFuel);

                ethanolFuel = new Fuel();
                ethanolFuel.setFuelName("Gasolina");
                ethanolFuel.setFuelPrice(ethanolPrice);
                ethanolFuel.setSuggestedPrice(suggestedFuel);



                fuelController.saveFuel(gasolineFuel);
                fuelController.saveFuel(ethanolFuel);
            }
        });

    }
}