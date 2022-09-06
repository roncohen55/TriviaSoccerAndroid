package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Bundle arguments=getIntent().getExtras();
        String str1=arguments.get("hello").toString();
        String str=arguments.get("hello11").toString();



        db = getBaseContext().openOrCreateDatabase("Quiz.db", MODE_PRIVATE, null);
        String Result = "Correct : 7/"  + str1;
        name=str;
        score=Integer.parseInt( str1);
        Add();
       String Score = ShowScore();
        TextView myScore=new TextView(this);
        myScore.setTextSize(30);
        Result +="\n"+"\n" + Score;
        myScore.setPadding(300,500,10,10);
        myScore.setText(Result);
        setContentView(myScore);
        Delete();


    }
    SQLiteDatabase db;
    int score=0;
    String name="";

    public int ShowId() {
        int id=0;
        Cursor q=db.rawQuery("select * from score  ",null);
        while(q.moveToNext())
        {
            id=q.getInt(0);

        }
        q.close();
        // db.close();
        return  id;
    }

    public void Add()
    {
        try{

            int id = ShowId();
            id+=1;


                db.execSQL("insert into score values("+id+",'" + name + "',"+score+")");
                Toast.makeText(this, "Added ...", Toast.LENGTH_LONG).show();


        }
        catch(Exception err) {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public String  ShowScore()
    {

        int ID=0,_id=0;





        String nameSTR="",str="",tmp="";
        int id1=0,scores=0;

        Cursor q=db.rawQuery("select * from score order by correct DESC ",null);
        while(q.moveToNext())
        {
            id1 = q.getInt(0);
            nameSTR =q.getString(1);

            scores =q.getInt(2);

            str+="Name "+nameSTR+" "+"score: "+scores+"\n";

        }
        q.close();
        return str;




    }

    //
    public void Delete() {
        try {



                //    db = getBaseContext().openOrCreateDatabase("College.db", MODE_PRIVATE, null);
                db.execSQL("delete from score where correct=" + 0 + "");
                Toast.makeText(this, "Delete ...", Toast.LENGTH_LONG).show();



        }
        catch(Exception err) {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_LONG).show();
        }
    }



}