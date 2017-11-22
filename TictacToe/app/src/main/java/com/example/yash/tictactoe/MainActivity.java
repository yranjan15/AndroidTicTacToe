package com.example.yash.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    TictacToeView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        tview = new TictacToeView(this);
        tview.setBackgroundColor(Color.WHITE);
         setContentView(tview);
        Log.e("main", "main before draw");

   }
}
