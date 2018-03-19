package com.example.dminh.firsttimerunapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor sharedEditor ;

    TextView ShowMsgTextView;

    public static final String PassString = "Check_App_Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowMsgTextView = (TextView) findViewById(R.id.mainacc_tv_mgs);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();

        if(CheckAppIsOpenFirstTimeOrNot()){

            ShowMsgTextView.setText("App is Launching First Time");

        }
        else {

            ShowMsgTextView.setText("App is Open Second Time or Already Opened Previously");
        }
    }

    public boolean CheckAppIsOpenFirstTimeOrNot(){

        if(sharedPreferences.getBoolean(PassString,true)){

            sharedEditor.putBoolean(PassString,false);
            sharedEditor.commit();
            sharedEditor.apply();

            // If App open for first time then return true.
            return true;
        }else {

            // If App open second time or already opened previously then return false.
            return false;
        }
    }
}
