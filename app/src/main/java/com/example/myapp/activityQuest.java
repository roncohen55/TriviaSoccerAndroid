package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activityQuest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        db = getBaseContext().openOrCreateDatabase("Quiz.db", MODE_PRIVATE, null);

    }
    SQLiteDatabase db;



    public int ShowId() {
        int id=0;
        Cursor q=db.rawQuery("select * from quest4 ",null);
        while(q.moveToNext())
        {
            id=q.getInt(0);

        }
        q.close();
        // db.close();
        return  id;
    }

    public void Create(View view)
    {
        try {
            db.execSQL("create table  quest4 (id INTEGER PRIMARY KEY ,questName text ,ans1 text , ans2 text , ans3 text , correct INTEGER)");
            Toast.makeText(this,"Create ...", Toast.LENGTH_LONG).show();
        }
        catch(Exception err)
        {
            Toast.makeText(this,err.getMessage(),Toast.LENGTH_LONG).show();
            // Toast.makeText(this,"Ish kvar",Toast.LENGTH_LONG).show();
        }

    }

    public void CreateTableScore(View view)
    {
        try {
            db.execSQL("create table  score (id INTEGER PRIMARY KEY ,Name text , correct INTEGER)");
            Toast.makeText(this,"Create ...", Toast.LENGTH_LONG).show();
        }
        catch(Exception err)
        {
            Toast.makeText(this,err.getMessage(),Toast.LENGTH_LONG).show();
            // Toast.makeText(this,"Ish kvar",Toast.LENGTH_LONG).show();
        }

    }

    public void Add(View view)
    {
        try{
            EditText QuestName=(EditText) findViewById((R.id.InputQuest));
            EditText ans1=(EditText) findViewById((R.id.InputAns1));
            EditText ans2=(EditText) findViewById((R.id.InputAns2));
            EditText ans3=(EditText) findViewById((R.id.InputAns3));
            EditText correct=(EditText) findViewById((R.id.InputCorrect));
            String questname,a1,a2,a3;
            int core=0;
            questname=QuestName.getText().toString();
            a1=ans1.getText().toString();
            a2=ans2.getText().toString();
            a3=ans3.getText().toString();
            core=Integer.parseInt( correct.getText().toString());
            int id = ShowId();
            id+=1;
            if(TextUtils.isEmpty(questname) || TextUtils.isEmpty(a1) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(a3) || core==0)
            {
                Toast.makeText(this,"Empty ...",Toast.LENGTH_LONG).show();
            }
            else {

                db.execSQL("insert into quest4 values("+id+",'" + questname + "','" + a1 + "','"+a2+"','"+a3+"',"+core+")");
                Toast.makeText(this, "Added ...", Toast.LENGTH_LONG).show();
                QuestName.setText("");
                ans1.setText("");
                ans2.setText("");
                ans3.setText("");
                correct.setText("");
            }
        }
        catch(Exception err) {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_LONG).show();
        }
    }



}