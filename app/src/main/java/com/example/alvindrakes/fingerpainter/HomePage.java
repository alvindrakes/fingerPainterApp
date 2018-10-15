package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView mTextMessage;
    private Button gotoCanvas;
    private Button uploadPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mTextMessage = (TextView) findViewById(R.id.welcomeMessage);
        gotoCanvas = (Button) findViewById(R.id.gotoCanvas);

        uploadPic = (Button) findViewById(R.id.uploadPic);


        gotoCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent canvasIntent = new Intent(HomePage.this, CanvasBlank.class);
                HomePage.this.startActivity(canvasIntent);
            }
        });

        uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageCanvasIntent = new Intent(HomePage.this, ImageCanvas.class);
                HomePage.this.startActivity(imageCanvasIntent);
            }
        });
    }

}
