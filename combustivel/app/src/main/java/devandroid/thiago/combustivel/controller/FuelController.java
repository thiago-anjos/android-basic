package devandroid.thiago.combustivel.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import devandroid.thiago.combustivel.database.FuelDB;
import devandroid.thiago.combustivel.model.Fuel;
import devandroid.thiago.combustivel.view.MainActivity;

public class FuelController extends FuelDB {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_combustivel";

    public FuelController(MainActivity mainActivity){
        super(mainActivity);
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = sharedPreferences.edit();
    }

    public void saveFuel(Fuel fuel){
        dadosPreferences.putString("fuel", fuel.getFuelName());
        dadosPreferences.putFloat("fuel price", (float) fuel.getFuelPrice());
        dadosPreferences.putString("fuel suggestion", fuel.getSuggestedPrice());
        dadosPreferences.apply();

        //save on sqlite
        ContentValues data = new ContentValues();
        data.put("name", fuel.getFuelName());
        data.put("price",fuel.getFuelPrice());
        data.put("suggestion",fuel.getSuggestedPrice());
        saveObject("Fuel", data);
    }

    public void CleanPreferences(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }

    public List<Fuel> getListFuel(){
        return listFuel();
    }

    public void updateFuel(Fuel fuel){
        ContentValues data = new ContentValues();
        data.put("id", fuel.getId());
        data.put("name", fuel.getFuelName());
        data.put("price",fuel.getFuelPrice());
        data.put("suggestion",fuel.getSuggestedPrice());
        updateFuelRegisterDB("Fuel", data);
    }

    public void deleteRegister(int id){
        deleteRegisterDB("Fuel", id);
    }


}
