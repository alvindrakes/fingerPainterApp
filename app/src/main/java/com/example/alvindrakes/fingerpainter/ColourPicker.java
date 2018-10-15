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

public class ColourPicker extends AppCompatActivity implements View.OnClickListener {

    private RadioButton redColourBtn;
    private RadioButton blueColourBtn;
    private RadioButton blackColourBtn;
    private RadioButton greenColourBtn;
    private RadioButton yellowColourBtn;
    private RadioButton magentaColourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_picker);

        // animation for pop up
        DisplayMetrics disMetric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disMetric);

        int width = disMetric.widthPixels;
        int height = disMetric.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        redColourBtn = (RadioButton) findViewById(R.id.redColour);
        redColourBtn.setOnClickListener(this);

        blueColourBtn = (RadioButton) findViewById(R.id.blueColour);
        blueColourBtn.setOnClickListener(this);

        greenColourBtn = (RadioButton) findViewById(R.id.greenColour);
        greenColourBtn.setOnClickListener(this);

        blackColourBtn = (RadioButton) findViewById(R.id.blackColour);
        blackColourBtn.setOnClickListener(this);

        yellowColourBtn = (RadioButton) findViewById(R.id.yellowColour);
        yellowColourBtn.setOnClickListener(this);

        magentaColourBtn = (RadioButton) findViewById(R.id.magentaColour);
        magentaColourBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int chosenColour = 0;
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.redColour:
                chosenColour = Color.RED;
                break;
            case R.id.yellowColour:
                chosenColour = Color.YELLOW;
                break;
            case R.id.blueColour:
                chosenColour = Color.BLUE;
                break;
            case R.id.blackColour:
                chosenColour = Color.BLACK;
                break;
            case R.id.magentaColour:
                chosenColour = Color.MAGENTA;
                break;
            case R.id.greenColour:
                chosenColour = Color.GREEN;
                break;
        }
        intent.putExtra("newColour", chosenColour);
        setResult(RESULT_OK, intent);
        finish();
    }
}
