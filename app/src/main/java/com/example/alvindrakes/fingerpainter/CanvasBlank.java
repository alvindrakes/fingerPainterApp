package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CanvasBlank extends AppCompatActivity {

    Button chooseColour;
    Button chooseBrush;

    public FingerPainterView fingerPainterView;
    private static int defaultColour;
    private static Paint.Cap defaultBrush;

    private static boolean selected = false;
    private static int CHOOSE_COLOUR_CODE = 0;
    private static int CHOOSE_BRUSH_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_blank);

        fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView);

        chooseColour = (Button) findViewById(R.id.colourPickerBtn);
        chooseBrush = (Button) findViewById(R.id.brushPickerBtn);

        defaultColour = fingerPainterView.getColour();
        defaultBrush = fingerPainterView.getBrush();


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
                Bundle bundle;
                bundle = new Bundle();

                Intent brushIntent = new Intent(CanvasBlank.this, BrushPicker.class);

                if (selected) {
                    bundle.putInt("currentBrushWidth", fingerPainterView.getBrushWidth());
                } else {
                    // bundle.putSerializable(fingerPainterView.setBrush());
                }

                Toast.makeText(CanvasBlank.this, "brush NOW: " + defaultBrush, Toast.LENGTH_SHORT).show();

                brushIntent.putExtras(bundle);
                startActivityForResult(brushIntent, CHOOSE_BRUSH_CODE);
            }
        });

    }


    // receive chosen colour and change the brush colour
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_COLOUR_CODE) {
            if (resultCode == RESULT_OK) {

                defaultColour = data.getExtras().getInt("newColour");
                fingerPainterView.setColour(defaultColour);
            }
        }
    }


}
