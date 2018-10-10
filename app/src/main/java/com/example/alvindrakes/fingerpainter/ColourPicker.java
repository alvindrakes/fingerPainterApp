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

public class ColourPicker extends AppCompatActivity {

    private RadioButton redColourBtn;
    private RadioButton blueColourBtn;
    private RadioButton blackColourBtn;
    private RadioButton greenColourBtn;
    private RadioButton yellowColourBtn;
    private RadioButton purpleColourBtn;

    public FingerPainterView fingerPainterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_picker);

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

        redColourBtn = (RadioButton) findViewById(R.id.redColour);
        blueColourBtn = (RadioButton) findViewById(R.id.blueColour);
        greenColourBtn = (RadioButton) findViewById(R.id.greenColour);
        blackColourBtn = (RadioButton) findViewById(R.id.blackColour);
        yellowColourBtn = (RadioButton) findViewById(R.id.yellowColour);
        purpleColourBtn = (RadioButton) findViewById(R.id.purpleColour);



        redColourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fingerPainterView.setColour(Color.argb(0xff, 0x99, 0x4c, 0x00));
            }
        });
    }
}
