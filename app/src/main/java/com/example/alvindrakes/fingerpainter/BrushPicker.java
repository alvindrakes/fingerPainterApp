package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class BrushPicker extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_picker);

        // animation for pop up
        DisplayMetrics disMetric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disMetric);

        int width = disMetric.widthPixels;
        int height = disMetric.heightPixels;

        getWindow().setLayout((int)(width * .8), (int)(height * .7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

    }
}
