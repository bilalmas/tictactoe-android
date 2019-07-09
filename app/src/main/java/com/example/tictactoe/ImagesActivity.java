package com.example.tictactoe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;

public class ImagesActivity extends AppCompatActivity {
    private Button play;
    private ImageView image1;
    private ImageView image2;
    static public Uri imageuri1;
    public Uri imageuri2;

    public void playnow(View view){

        play = (Button) findViewById(R.id.imageplaybutton);
        Intent playpage = new Intent(ImagesActivity.this,MainActivity.class);
        playpage.putExtra("imageUri1", imageuri1);
        playpage.putExtra("imageUri2",imageuri2);
        startActivity(playpage);
        };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        //playnow();

    }

    public void faceimage1 ( View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,41);
    }

    public void faceimage2 ( View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,42);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 41 && data != null && resultCode == RESULT_OK){

            Uri selectedimage = data.getData();
            imageuri1 = selectedimage;

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedimage);
                image1 = (ImageView) findViewById(R.id.image1);
                image1.setImageBitmap(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if( requestCode == 42 && data != null && resultCode == RESULT_OK){

            Uri selectedimage = data.getData();
            imageuri2 = selectedimage;

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedimage);
                image1 = (ImageView) findViewById(R.id.image2);
                image1.setImageBitmap(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
