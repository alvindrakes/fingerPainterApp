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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BrushPicker extends AppCompatActivity implements View.OnClickListener {

    private RadioButton roundCapBtn;
    private RadioButton squareCapbtn;
    private SeekBar brushWidthSeekbar;
    private TextView brushWidthValue;

    int chosenBrushWidth;
    String chosenBrushType = null;

    Button confirmBrushBtn;


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

        brushWidthValue = (TextView) findViewById(R.id.brushWidthValue);

        confirmBrushBtn = (Button) findViewById(R.id.confirmBrushBtn);
        confirmBrushBtn.setOnClickListener(this);

        roundCapBtn = (RadioButton) findViewById(R.id.roundStroke);
        roundCapBtn.setOnClickListener(this);

        squareCapbtn = (RadioButton) findViewById(R.id.squareStroke);
        squareCapbtn.setOnClickListener(this);

        // slider for brushwidth
        brushWidthSeekbar = (SeekBar) findViewById(R.id.brushWidthSeekbar);
        brushWidthSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                chosenBrushWidth = progress;
                brushWidthValue.setText(String.valueOf(progress));
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
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.roundStroke:
                chosenBrushType = "ROUND";
                break;
            case R.id.squareStroke:
                chosenBrushType = "SQUARE";
                break;
            case R.id.confirmBrushBtn:
                if (chosenBrushWidth != 0 && chosenBrushType != "") {
                    sendBrushType(intent, "newBrush", chosenBrushType);
                    sendBrushWidth(intent, "newBrushWidth", chosenBrushWidth);
                    finish();
                }
                break;
        }
    }

    private void sendBrushType(Intent intent, String key, String brushType) {
        intent.putExtra(key, brushType);
        setResult(RESULT_OK, intent);
    }

    private void sendBrushWidth(Intent intent, String key, int brushWidth) {
        intent.putExtra(key, brushWidth);
        setResult(RESULT_OK, intent);
    }
}
