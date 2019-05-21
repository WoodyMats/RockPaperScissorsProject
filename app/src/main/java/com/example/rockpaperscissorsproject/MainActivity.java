package com.example.rockpaperscissorsproject;

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

    private ImageView playerIcon, cpuIcon;
    
    private String playerChoice, cpuChoice;

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
                playerChoice = "rock";
                playerIcon.setImageResource(R.drawable.rock);
                makeMove();
            }
        });
        
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = "paper";
                playerIcon.setImageResource(R.drawable.paper);
                makeMove();
            }
        });
        
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = "scissors";
                playerIcon.setImageResource(R.drawable.scissors);
                makeMove();
            }
        });

        if(savedInstanceState != null){
            cpu_score = savedInstanceState.getInt("machineScore");
            player_score = savedInstanceState.getInt("humanScore");

            playerChoice = savedInstanceState.getString("humanChoice");
            cpuChoice = savedInstanceState.getString("machineChoice");

            if(playerChoice != null && cpuChoice != null) {
                playerScore.setText("Player: " + player_score + " (Played: " + playerChoice + ")");
                cpuScore.setText("Machine: " + cpu_score + " (Played: " + cpuChoice + ")");

                if(playerChoice.equals("rock")){
                    playerIcon.setImageResource(R.drawable.rock);
                } else if(playerChoice.equals("paper")){
                    playerIcon.setImageResource(R.drawable.paper);
                } else {
                    playerIcon.setImageResource(R.drawable.scissors);
                }

                if(cpuChoice.equals("rock")){
                    cpuIcon.setImageResource(R.drawable.rock);
                } else if(cpuChoice.equals("paper")){
                    cpuIcon.setImageResource(R.drawable.paper);
                } else {
                    cpuIcon.setImageResource(R.drawable.scissors);
                }
            } else {
                playerScore.setText("Player: " + player_score);
                cpuScore.setText("Machine: " + cpu_score);
            }

        }

    }

    private void makeMove() {
        int randomChoose = random.nextInt(500)%3;

        if(randomChoose == 0){
            cpuChoice = "rock";
            cpuIcon.setImageResource(R.drawable.rock);
        } else if(randomChoose == 1){
            cpuChoice = "paper";
            cpuIcon.setImageResource(R.drawable.paper);

        } else if(randomChoose == 2){
            cpuChoice = "scissors";
            cpuIcon.setImageResource(R.drawable.scissors);
        }


        if(playerChoice.equals("rock") && cpuChoice.equals("scissors")){
            playerScore.setText("Player: " + ++player_score + " (Played: " + playerChoice + ")");
            cpuScore.setText("Machine: " + cpu_score + " (Played: " + cpuChoice + ")");
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoice.equals("rock") && cpuChoice.equals("paper")){
            cpuScore.setText("Machine: " + ++cpu_score + " (Played: " + cpuChoice + ")");
            playerScore.setText("Player: " + player_score + " (Played: " + playerChoice + ")");
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoice.equals("paper") && cpuChoice.equals("rock")){
            playerScore.setText("Player: " + ++player_score + " (Played: " + playerChoice + ")");
            cpuScore.setText("Machine: " + cpu_score + " (Played: " + cpuChoice + ")");
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else if(playerChoice.equals("paper") && cpuChoice.equals("scissors")){
            cpuScore.setText("Machine: " + ++cpu_score + " (Played: " + cpuChoice + ")");
            playerScore.setText("Player: " + player_score + " (Played: " + playerChoice + ")");
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoice.equals("scissors") && cpuChoice.equals("rock")){
            cpuScore.setText("Machine: " + ++cpu_score + " (Played: " + cpuChoice + ")");
            playerScore.setText("Player: " + player_score + " (Played: " + playerChoice + ")");
            Toast.makeText(this, "You Lost!", Toast.LENGTH_SHORT).show();
        } else if(playerChoice.equals("scissors") && cpuChoice.equals("paper")){
            playerScore.setText("Player: " + ++player_score + " (Played: " + playerChoice + ")");
            cpuScore.setText("Machine: " + cpu_score + " (Played: " + cpuChoice + ")");
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
        } else {
            playerScore.setText("Player: " + player_score + " (Played: " + playerChoice + ")");
            cpuScore.setText("Machine: " + cpu_score + " (Played: " + cpuChoice + ")");
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("humanScore", player_score);
        outState.putInt("machineScore", cpu_score);
        outState.putString("humanChoice", playerChoice);
        outState.putString("machineChoice", cpuChoice);

    }
}