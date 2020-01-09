package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 };
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;

    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);
        if(gameActive==false){
            gameReset(view);
        }
        if (gameState[tappedImage] == 2 && gameActive){
            gameState[tappedImage] = activePlayer;
            if (activePlayer == 1){
                status.setText("X's turn - Tap to play !");
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
            }
            else if (activePlayer==0){
                status.setText("O's turn - Tap to play !");
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
            }
        }
        else if(gameState[tappedImage] != 2 ){
            status.setText("Tap to Play again");
            gameReset(view);
        }

        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                if (gameState[winPosition[0]] == 0) {
                    status.setText("X Won! - Tap to Play Again");
                    gameActive = false;
                } else if (gameState[winPosition[0]] == 1) {
                    status.setText("O Won! - Tap to Play Again");
                    gameActive = false;
                } else {
                    gameReset(view);
                    status.setText("Tap to Play Again !");
                }
            }
        }
    }

    private void gameReset(View view) {
        activePlayer = 0;
        gameActive = true;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView status = findViewById(R.id.status);
        status.setText("X's turn - Tap to play!");
    }
}
