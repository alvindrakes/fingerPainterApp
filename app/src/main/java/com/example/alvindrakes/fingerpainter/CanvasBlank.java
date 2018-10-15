package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CanvasBlank extends AppCompatActivity {

    Button chooseColour;
    Button chooseBrush;

    public FingerPainterView fingerPainterView;
    private int defaultColour;
    private String defaultBrushCap;
    private int brushWidth;

    private int CHOOSE_COLOUR_CODE = 0;
    private int CHOOSE_BRUSH_STROKE_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_blank);

        fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);

        chooseColour = (Button) findViewById(R.id.colourPickerBtn);
        chooseBrush = (Button) findViewById(R.id.brushPickerBtn);

        defaultColour = fingerPainterView.getColour();
        brushWidth = fingerPainterView.getBrushWidth();

        // open new activity to choose colour
        chooseColour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent colourIntent = new Intent(CanvasBlank.this, ColourPicker.class);

                        startActivityForResult(colourIntent, CHOOSE_COLOUR_CODE);
            }
        });




        // open new activity to choose brush type
        chooseBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent brushIntent = new Intent(CanvasBlank.this, BrushPicker.class);

                startActivityForResult(brushIntent, CHOOSE_BRUSH_STROKE_CODE);
            }
        });

    }


    // receive chosen colour/brush cap and change the brush colour/cap
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_COLOUR_CODE) {
            if (resultCode == RESULT_OK) {

                defaultColour = data.getExtras().getInt("newColour");
                fingerPainterView.setColour(defaultColour);
            }
        }

        if (requestCode == CHOOSE_BRUSH_STROKE_CODE) {
            if (resultCode == RESULT_OK) {

                defaultBrushCap = data.getExtras().getString("newBrush");

                if(defaultBrushCap.equals("ROUND")) {
                    fingerPainterView.setBrush(Paint.Cap.ROUND);
                } else if (defaultBrushCap.equals("SQUARE")) {
                    fingerPainterView.setBrush(Paint.Cap.SQUARE);
                }
            }
        }
    }


}
