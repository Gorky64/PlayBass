package com.example.goran.playbass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//Activity used for note diagram
public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }
     @Override
    protected void onDestroy(){
         super.onDestroy();
         finish();
     }
}
