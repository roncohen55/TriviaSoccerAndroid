package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start(View view)
    {
        Intent intent=new Intent(this,activityQuiz.class);

        EditText myName = (EditText) findViewById(R.id.txtName);
        String name=myName.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Empty ...",Toast.LENGTH_LONG).show();
        }
        else {
            intent.putExtra("hello",name);
            startActivity(intent);
        }

    }

    public  void  putquest(View view)
    {
        Intent intent=new Intent(this,activityQuest.class);
        startActivity(intent);
    }

}