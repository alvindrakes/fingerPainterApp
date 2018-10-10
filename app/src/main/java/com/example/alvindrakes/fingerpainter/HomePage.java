package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView mTextMessage;
    private Button gotoCanvas;
    private Button gotoUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mTextMessage = (TextView) findViewById(R.id.message);
        gotoCanvas = (Button) findViewById(R.id.gotoCanvas);
        gotoUpload = (Button) findViewById(R.id.gotoUpload);

        gotoCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent canvasIntent = new Intent(HomePage.this, CanvasBlank.class);
                HomePage.this.startActivity(canvasIntent);
            }
        });

//        gotoUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent uploadIntent = new Intent(HomePage.this, .class);
//                HomePage.this.startActivity(uploadIntent);
//            }
//        });
    }

}
