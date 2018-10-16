package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class CanvasBlank extends AppCompatActivity {

    Button chooseColour;
    Button chooseBrush;
    FloatingActionButton closeCanvas;

    public FingerPainterView fingerPainterView;
    private int defaultColour;
    private int brushWidth;

    private int CHOOSE_COLOUR_CODE = 0;
    private int CHOOSE_BRUSH_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_blank);

        fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);

        chooseColour = (Button) findViewById(R.id.colourPickerBtn);
        chooseBrush = (Button) findViewById(R.id.brushPickerBtn);
        closeCanvas = (FloatingActionButton) findViewById(R.id.closeCanvas);


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
                startActivityForResult(brushIntent, CHOOSE_BRUSH_CODE);
            }
        });

        // reset the activity and clear the canvas
        closeCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        handleIntent();

    }


    // receive chosen colour/brush shape and change the brush colour/cap
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        String defaultBrushShape;

        if (requestCode == CHOOSE_COLOUR_CODE) {
            if (resultCode == RESULT_OK) {

                defaultColour = data.getExtras().getInt("newColour");
                fingerPainterView.setColour(defaultColour);
            }
        }

        if (requestCode == CHOOSE_BRUSH_CODE) {
            if (resultCode == RESULT_OK) {

                defaultBrushShape = data.getExtras().getString("newBrush");
                brushWidth = data.getExtras().getInt("newBrushWidth");

                if(defaultBrushShape.equals("ROUND")) {
                    fingerPainterView.setBrush(Paint.Cap.ROUND);
                } else if (defaultBrushShape.equals("SQUARE")) {
                    fingerPainterView.setBrush(Paint.Cap.SQUARE);
                }

                fingerPainterView.setBrushWidth(brushWidth);
            }
        }
    }


    // save the status of brush type/width and color when the orientation is changed
    @Override
    protected void onSaveInstanceState(Bundle backState) {
        FingerPainterView fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);
        backState.putInt("newColour", fingerPainterView.getColour());
        backState.putString("newBrush", fingerPainterView.getBrush().toString());
        backState.putInt("newBrushWidth", fingerPainterView.getBrushWidth());
        super.onSaveInstanceState(backState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);
        fingerPainterView.setColour(savedInstanceState.getInt("newColour"));
        fingerPainterView.setBrushWidth(savedInstanceState.getInt("newBrushWidth"));

        String brush_shape = savedInstanceState.getString("newBrush");

        if (brush_shape.equals("ROUND")) {
            fingerPainterView.setBrush(Paint.Cap.ROUND);
        } else if (brush_shape.equals("SQUARE")) {
            fingerPainterView.setBrush(Paint.Cap.SQUARE);
        }

    }

    // handle the image opened from device and show it on canvas
    private void handleIntent() {
        Intent intent = getIntent();
        Uri data = intent.getData();

        FingerPainterView fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);
        fingerPainterView.load(data);
    }

}
