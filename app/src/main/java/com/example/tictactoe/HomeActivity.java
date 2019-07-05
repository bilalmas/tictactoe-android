package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    public Button button;
    public Button instructionButton;

    public void init(){
        button = (Button) findViewById(R.id.playbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextpage = new Intent(HomeActivity.this,ImagesActivity.class);
                startActivity(nextpage);
            }
        });

    }
    public void instructfunc(){
        instructionButton = (Button) findViewById(R.id.instructionbutton);
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instructionpage = new Intent(HomeActivity.this,InstructionActivity.class);
                startActivity(instructionpage);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        instructfunc();
        init();
    }

}
