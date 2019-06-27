package com.example.tictactoe;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //player0
    int activePlayer = 1;

    int[] gamestate = {2,2,2,2,2,2,2,2,2};


    int[][] wincombo = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
    public void myturn(View view){
        //tick sound upon clicking the button
        MediaPlayer mplayer = MediaPlayer.create(this, R.raw.tick);
        mplayer.start();
        ImageView counter = (ImageView) view;
        //counter tag to specify which block clicked
        String intcounter = counter.getTag().toString();
        int intcounter1 = Integer.parseInt(intcounter);

        counter.setTranslationY(-1000f);
        if(gamestate[intcounter1]==2) {
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.ex);
                gamestate[intcounter1]=0;
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.oo);
                gamestate[intcounter1]=1;
                activePlayer = 0;

            }


        }

        counter.animate().translationYBy(1000f).setDuration(300);

        TextView winner = (TextView) findViewById(R.id.playertext);
        LinearLayout linl = (LinearLayout) findViewById(R.id.LinearL);

        for(int [] wincomb: wincombo){

            if(gamestate[wincomb[0]]==gamestate[wincomb[1]] && gamestate[wincomb[1]]==gamestate[wincomb[2]] && gamestate[wincomb[0]] != 2){

                if(gamestate[wincomb[0]]==0){
                    winner.setText("X has won");
                    linl.setVisibility(View.VISIBLE);
                }
                else{
                    winner.setText("0 has won");
                    linl.setVisibility(View.VISIBLE);
                }

            }
        }
        int statecounter= 0;
        for(int iter=0; iter<gamestate.length; iter++){

            if(gamestate[iter]!=2){
                statecounter ++;
            }
        }

        if(statecounter==9){
           if(winner.getText().toString()!="X has won" || winner.getText().toString()!="0 has won") {
               winner.setText("   Draw");
               linl.setVisibility(View.VISIBLE);
           }
        }


    }

    public void playagain(View view){
        LinearLayout lin = (LinearLayout) findViewById(R.id.LinearL);
        lin.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for(int iter=0; iter<gamestate.length; iter++){

            gamestate[iter]=2;

        }
        android.support.v7.widget.GridLayout gd = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<9; i++){
            ((ImageView) gd.getChildAt(i)).setImageResource(0);

        }




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
