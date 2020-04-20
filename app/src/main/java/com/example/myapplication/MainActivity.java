package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button loginbtn;
    SQLiteDatabase db;
    String mail;
    SQLiteOpenHelper helper;
    ProgressBar progressBar;
    Connection connection;
   // String un,pas,ip,url,db;
    String user,passa;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        helper=new databasehelper(this);
        db=helper.getReadableDatabase();
        username=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        loginbtn=findViewById(R.id.button);
        user= username.getText().toString();
        passa=password.getText().toString();
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mail=username.getText().toString();
                String passw=password.getText().toString();
                cursor=db.rawQuery("SELECT * FROM "+ databasehelper.TABLE_NAME+" WHERE "+databasehelper.COL_5+"=?AND "+databasehelper.COL_4+"=?",new String[]{mail,passw});
                if(cursor!=null)
                {
                    if(cursor.getCount()>0)
                    {

                        Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                        intent.putExtra("mail",mail);
                        Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public  void  myfunc(View view)
    {
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }
}
