package devandroid.thiago.combustivel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.thiago.combustivel.model.Fuel;

public class FuelDB extends SQLiteOpenHelper {
    //criar metodos para implementar um CRUD
    // nome do banco, versão

    private static final String DB_NAME = "fuel.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public FuelDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTableFuel = "CREATE TABLE Fuel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "price REAL, " +
                "suggestion TEXT)";
        db.execSQL(sqlTableFuel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveObject(String tableName, ContentValues data){
        db.insert(tableName, null, data);
    }

    public List<Fuel> listFuel(){
        List<Fuel> list = new ArrayList<>();

        Fuel fuelRegiter;

        String querySQL = "SELECT * FROM Fuel";
        cursor = db.rawQuery(querySQL, null);

        if(cursor.moveToFirst()){
            do{
                fuelRegiter = new Fuel();
                fuelRegiter.setId(cursor.getInt(0));
                fuelRegiter.setFuelName(cursor.getString(1));
                fuelRegiter.setFuelPrice(cursor.getDouble(2));
                fuelRegiter.setSuggestedPrice(cursor.getString(3));
                list.add(fuelRegiter);
            }while (cursor.moveToNext());
        }else{

        }
        return list;
    }

    public void updateFuelRegisterDB(String tableName, ContentValues data){
        int id = data.getAsInteger("id");
        db.update(tableName, data, "id=?", new String[]{Integer.toString(id)});
    }

    public void deleteRegisterDB(String tableName, int id){
        db.delete(tableName, "id=?", new String[]{Integer.toString(id)});
    }

}
