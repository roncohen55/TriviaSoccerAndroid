package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activityQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        db = getBaseContext().openOrCreateDatabase("Quiz.db", MODE_PRIVATE, null);
        Bundle arguments=getIntent().getExtras();
        nameUs=arguments.get("hello").toString();
        ShowQuestTOFirst();
        //Show();

    }
    String nameUs="";

    SQLiteDatabase db;
    int id=1,CounterQuest=0;
    int core;





    public  int GiveMeId(){
        if(id<=6)
            id+=1;
        else {
            Intent intent=new Intent(this,EndActivity.class);
            intent.putExtra("hello",CounterQuest);
            intent.putExtra("hello11",nameUs);
            startActivity(intent);
           // id = 1;
        }
        return id;
    }



    public void  ShowQuest(View view)
    {

        int ID=0,_id=0;
        ID=GiveMeId();

        TextView textQuest=(TextView) findViewById(R.id.txtQuest);

        Button Bans1=(Button) findViewById(R.id.btnAns1);
        Button Bans2=(Button) findViewById(R.id.btnAns2);
        Button Bans3=(Button) findViewById(R.id.btnAns3);
        String quest="",a1="",a2="",a3="",tmp="";


        Cursor q=db.rawQuery("select * from quest4 where id=" + ID +"",null);
        while(q.moveToNext())
        {
            _id = q.getInt(0);
            quest =q.getString(1);
            a1 =q.getString(2);
            a2 =q.getString(3);
            a3 =q.getString(4);
            core =q.getInt(5);

        }
        q.close();
        // db.close();
        textQuest.setText(quest);
        Bans1.setText(a1);
        Bans2.setText(a2);
        Bans3.setText(a3);


        String result="";




    }

    public  void  CheckAns1(View view){

        Button Bans1=(Button) findViewById(R.id.btnAns1);

        if(core==1){
            CounterQuest+=1;
        }

    }

    public  void  CheckAns2(View view){

        Button Bans2=(Button) findViewById(R.id.btnAns2);
        if(core==2){
            CounterQuest+=1;
        }

    }

    public  void  CheckAns3(View view){

        Button Bans3=(Button) findViewById(R.id.btnAns3);
        if(core==3){
            CounterQuest+=1;
        }

    }

    public void  ShowQuestTOFirst()
    {

        int idfirst=1,_id=0;

        TextView textQuest=(TextView) findViewById(R.id.txtQuest);
        Button Bans1=(Button) findViewById(R.id.btnAns1);
        Button Bans2=(Button) findViewById(R.id.btnAns2);
        Button Bans3=(Button) findViewById(R.id.btnAns3);
        String quest="",a1="",a2="",a3="";


        Cursor q=db.rawQuery("select * from quest4 where id=" + idfirst +"",null);
        while(q.moveToNext())
        {
            _id = q.getInt(0);
            quest =q.getString(1);
            a1 =q.getString(2);
            a2 =q.getString(3);
            a3 =q.getString(4);
            core =q.getInt(5);


        }
        q.close();
        // db.close();
        textQuest.setText(quest);
        Bans1.setText(a1);
        Bans2.setText(a2);
        Bans3.setText(a3);


    }




}