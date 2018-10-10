package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alvindrakes.fingerpainter.ColourPicker;

public class CanvasBlank extends AppCompatActivity {

    Button chooseColour;
    Button chooseBrush;
    FloatingActionButton uploadPic;
    ImageView chosenImage;
    Uri imageURI;
    private static final int PICK_IMAGE = 100;
    public FingerPainterView fingerPainterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_blank);

        chooseColour = (Button) findViewById(R.id.colourPicker);
        chooseBrush = (Button) findViewById(R.id.brushPicker);
        chosenImage = (ImageView) findViewById(R.id.chosenImage);
        uploadPic = (FloatingActionButton) findViewById(R.id.uploadPic);

        fingerPainterView = new FingerPainterView(CanvasBlank.this);

        // get the default brush colour

        // Toast.makeText(getBaseContext(), "default Color : " + brushColour, Toast.LENGTH_LONG).show();


        // upload image to edit
        uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDownloadImage();
            }
        });


        // open new activity to choose colour
        chooseColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colourIntent = new Intent(CanvasBlank.this, ColourPicker.class);
                CanvasBlank.this.startActivity(colourIntent);
            }
        });

        // open new activity to choose brush type
        chooseBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brushIntent = new Intent(CanvasBlank.this, brushPicker.class);
                CanvasBlank.this.startActivity(brushIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        fingerPainterView.getColour();
    }

    // load chosen image from phone
    private void openDownloadImage() {
        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(image, PICK_IMAGE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageURI = data.getData();
            chosenImage.setImageURI(imageURI);
        }
    }

}
