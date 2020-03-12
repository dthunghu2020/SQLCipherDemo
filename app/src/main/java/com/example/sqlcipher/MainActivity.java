package com.example.sqlcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSQLCipher();
    }

    private void initializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        File databaseFile = getDatabasePath("demo.db");
        //String dbPath = this.getDatabasePath("demo.db").getPath();
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbPath,"dbPassword", null);
        databaseFile.mkdirs();
        databaseFile.delete();
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile,"test123",null);
        database.execSQL("create table t1(a,b)");
        database.execSQL("insert into t1(a,b) values(?,?)", new Object[]{"one for the money","to for the show"});
    }
}
