package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView firstname2,lastname2,mail2,phone2;
    SQLiteDatabase db;
    SQLiteOpenHelper helpers;
    String result;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        firstname2=findViewById(R.id.firstname2);
        lastname2=findViewById(R.id.lastname2);
        mail2=findViewById(R.id.email2);
        phone2=findViewById(R.id.phone2);
        helpers=new databasehelper(this);
        db=helpers.getReadableDatabase();
        Intent intent=getIntent();
       result=intent.getStringExtra("mail");
      //  String []project={result};
        Cursor cursor=db.rawQuery("SELECT * FROM "+ databasehelper.TABLE_NAME +" WHERE "+databasehelper.COL_5+"=?",new String[]{result});

            while(cursor.moveToNext()) {
                s1 = cursor.getString(1);
                s2 = cursor.getString(2);
                s3 = cursor.getString(4);
                s4 = cursor.getString(5);
            }



        firstname2.setText("Firstname:"+"  "+s1+" "+s2);

        mail2.setText("Email:"+"  "+s3);
        phone2.setText("Phone:"+"  "+s4);


    }
}
