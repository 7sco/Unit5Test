package nyc.c4q.androidtest_unit4final;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by franciscoandrade on 1/23/18.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    static final int DB_VERSION= 2;


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        onUpgrade(db, 1, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion<1){
            String query= "CREATE TABLE colors(name TEXT, code TEXT);";
            db.execSQL(query);
        }

        if(oldVersion<2){
            db.execSQL("ALTER TABLE colors ADD  student TEXT");
            String query= "CREATE TABLE names(_id INTEGER PRIMARY KEY autoincrement, name TEXT);";
            db.execSQL(query);
            //Log.d("ADDING ID==", "onUpgrade: ");
        }

        // ALTER TABLE employees ADD status VARCHAR;


//        db.execSQL("DROP TABLE IF EXISTS colors");
//        //we create the class after we drop the older version
//        onCreate(db);
    }


    public  void addColors(String name, String code){
        ContentValues values= new ContentValues();
        values.put("name", name);
        values.put("code", code);
        this.getWritableDatabase().insert("colors", null, values);
    }

    //Method allow to open DB
    public void openDB(){
        this.getWritableDatabase();
    }

    //Method allow to close DB
    public void closeDB(){
        this.close();
    }

}
