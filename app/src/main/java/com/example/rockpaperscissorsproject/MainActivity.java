package com.example.rockpaperscissorsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rock, paper, scissors;

    private ImageView playerIcon, cpuIcon;
    
    private String playerChoise, cpuChoise;

    private int player_score=0,cpu_score=0;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerIcon = findViewById(R.id.myMove);
        cpuIcon = findViewById(R.id.cpuMove);

        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "rock";
                playerIcon.setImageResource(R.drawable.rock);
                makeMove();
            }
        });
        
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "paper";
                playerIcon.setImageResource(R.drawable.paper);
                makeMove();
            }
        });
        
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "scissors";
                playerIcon.setImageResource(R.drawable.scissors);
                makeMove();
            }
        });

    }

    private void makeMove() {
        int randomChoose = random.nextInt(3);

        if(randomChoose == 0){
            cpuChoise = "rock";
            cpuIcon.setImageResource(R.drawable.rock);
        } else if(randomChoose == 1){
            cpuChoise = "paper";
            cpuIcon.setImageResource(R.drawable.paper);

        } else if(randomChoose == 2){
            cpuChoise = "scissors";
            cpuIcon.setImageResource(R.drawable.scissors);
        }


        if(playerChoise.equals("rock") && cpuChoise.equals("scissors")){
            player_score++;
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("rock") && cpuChoise.equals("paper")){
            cpu_score++;
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("paper") && cpuChoise.equals("rock")){
            player_score++;
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("paper") && cpuChoise.equals("scissors")){
            cpu_score++;
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("scissors") && cpuChoise.equals("rock")){
            cpu_score++;
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("scissors") && cpuChoise.equals("paper")){
            player_score++;
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }
    }
}
