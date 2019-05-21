package com.example.rockpaperscissorsproject;

import android.os.PersistableBundle;
import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rock, paper, scissors;

    private Bundle bundle = new Bundle();

    private ImageView playerIcon, cpuIcon;
    
    private String playerChoise, cpuChoise;

    private TextView cpuScore, playerScore;

    private int player_score, cpu_score;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerIcon = findViewById(R.id.myMove);
        cpuIcon = findViewById(R.id.cpuMove);

        playerScore = findViewById(R.id.playerScore);
        playerScore.setText("Player: " + player_score);
        cpuScore = findViewById(R.id.cpuScore);
        cpuScore.setText("Machine: " + cpu_score);

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

        if(savedInstanceState != null){
            cpu_score = savedInstanceState.getInt("machineScore");
            player_score = savedInstanceState.getInt("humanScore");
            playerScore.setText("Player: " + player_score);
            cpuScore.setText("Machine: " + cpu_score);
        }

    }

    private void makeMove() {
        int randomChoose = random.nextInt(500)%3;

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
            playerScore.setText("Player: " + ++player_score);
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("rock") && cpuChoise.equals("paper")){
            cpuScore.setText("Machine: " + ++cpu_score);
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("paper") && cpuChoise.equals("rock")){
            playerScore.setText("Player: " + ++player_score);
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("paper") && cpuChoise.equals("scissors")){
            cpuScore.setText("Machine: " + ++cpu_score);
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("scissors") && cpuChoise.equals("rock")){
            cpuScore.setText("Machine: " + ++cpu_score);
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoise.equals("scissors") && cpuChoise.equals("paper")){
            playerScore.setText("Player: " + ++player_score);
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("humanScore", player_score);
        outState.putInt("machineScore", cpu_score);
        bundle.putAll(outState);

    }
}
