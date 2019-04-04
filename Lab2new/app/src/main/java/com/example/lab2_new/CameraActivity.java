package com.example.lab2_new;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.FrameLayout;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

import static android.content.ContentValues.TAG;

public class CameraActivity extends AppCompatActivity {
    private Camera mCamera;
    private CameraPreviewActivity mPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
        mPreview = new CameraPreviewActivity(this, mCamera);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = ;
    }
}
