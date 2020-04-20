package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText firstname,name,pass,lastname,phone,email;
    Button regbtn;
    SQLiteDatabase db;
    TextView text;
    SQLiteOpenHelper datahelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        datahelp=new databasehelper(this);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        pass=findViewById(R.id.editText7);
        email=findViewById(R.id.email);
        text=findViewById(R.id.textView);
        phone=findViewById(R.id.editText6);
        regbtn=findViewById(R.id.registrationbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=datahelp.getWritableDatabase();

                String firstname1=firstname.getText().toString();
                String pass1=pass.getText().toString();
                String lastname1=lastname.getText().toString();
                String phone1=phone.getText().toString();
                String mail1=email.getText().toString();
                insert(firstname1,lastname1,mail1,phone1,pass1);
                Toast.makeText(getApplicationContext(),"succesfull",Toast.LENGTH_LONG).show();


                     }

});
    }
    public  void insert(String fname,String lname,String email,String phonenum,String passe)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(databasehelper.COL_2,fname);
        contentValues.put(databasehelper.COL_3,lname);
        contentValues.put(databasehelper.COL_4,passe);
        contentValues.put(databasehelper.COL_5,email);
        contentValues.put(databasehelper.COL_6,phonenum);
        long id =db.insert(databasehelper.TABLE_NAME,null,contentValues);
    }
    public void myfuncy(View view)
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}