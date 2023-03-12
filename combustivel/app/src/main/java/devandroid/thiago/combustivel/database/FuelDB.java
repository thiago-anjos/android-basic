package devandroid.thiago.combustivel.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FuelDB extends SQLiteOpenHelper {
    //criar metodos para implementar um CRUD
    // nome do banco, versão

    public static final String DB_NAME = "fuel.db";
    public static final int DB_VERSION = 1;

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

}
