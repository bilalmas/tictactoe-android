package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImagesActivity extends AppCompatActivity {
    private Button play;

    private void playnow(){

        play = (Button) findViewById(R.id.imageplaybutton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playpage = new Intent(ImagesActivity.this,MainActivity.class);
                startActivity(playpage);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        playnow();
    }
}
