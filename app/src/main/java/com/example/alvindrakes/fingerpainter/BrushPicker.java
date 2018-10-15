package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class BrushPicker extends AppCompatActivity implements View.OnClickListener {

    private RadioButton roundCapBtn;
    private RadioButton squareCapbtn;
    private SeekBar brushWidthSeekbar;

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

        roundCapBtn = (RadioButton) findViewById(R.id.roundStroke);
        roundCapBtn.setOnClickListener(this);

        squareCapbtn = (RadioButton) findViewById(R.id.squareStroke);
        squareCapbtn.setOnClickListener(this);

        brushWidthSeekbar = (SeekBar) findViewById(R.id.brushWidthSeekbar);
        brushWidthSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        String chosenBrushtype = null;
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.roundStroke:
                chosenBrushtype = "ROUND";
                break;
            case R.id.squareStroke:
                chosenBrushtype = "SQUARE";
                break;
        }

        intent.putExtra("newBrush", chosenBrushtype);
        setResult(RESULT_OK, intent);
        finish();

    }
}
