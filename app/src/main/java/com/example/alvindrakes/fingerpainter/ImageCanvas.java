package com.example.alvindrakes.fingerpainter;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.URL;

public class ImageCanvas extends AppCompatActivity {

    private ImageView chosenImage;
    public FingerPainterView fingerPainterView;

    Uri imageURI;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_canvas);

//        chosenImage = (ImageView) findViewById(R.id.chosenImage);

        handleIntent();

       // openDownloadImage();

    }

//    // load chosen image from phone
//    private void openDownloadImage() {
////        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
////        startActivityForResult(image, PICK_IMAGE);
//
//        Uri selectedUri = Uri.parse(Environment.getExternalStorageDirectory() + "/Downloads/");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(selectedUri, "image/*");
//
//        if (intent.resolveActivityInfo(getPackageManager(), 0) != null)
//        {
//            fingerPainterView.load(intent.getData());
//        }
//        else
//        {
//            // if you reach this place, it means there is no any file
//            // explorer app installed on your device
//        }
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
//            imageURI = data.getData();
//            chosenImage.setImageURI(imageURI);
//        }
//    }

    // following lab 2
    private void handleIntent() {Intent intent = getIntent();
        Uri data = intent.getData();
        URL url = null;
        try {
            url = new URL(data.getScheme(),
                    data.getHost(),
                    data.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageView imageView = (ImageView) findViewById(R.id.chosenImage);
        imageView.setImageURI(data);
    }

}
