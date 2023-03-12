package devandroid.thiago.combustivel.controller;

import android.content.SharedPreferences;

import devandroid.thiago.combustivel.model.Fuel;
import devandroid.thiago.combustivel.view.MainActivity;

public class FuelController {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_combustivel";

    public FuelController(MainActivity mainActivity){
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = sharedPreferences.edit();
    }

    public void saveFuel(Fuel fuel){
        dadosPreferences.putString("fuel", fuel.getFuelName());
        dadosPreferences.putFloat("fuel price", (float) fuel.getFuelPrice());
        dadosPreferences.putString("fuel suggestion", fuel.getSuggestedPrice());
        dadosPreferences.apply();
    }

    public void CleanPreferences(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }


}
