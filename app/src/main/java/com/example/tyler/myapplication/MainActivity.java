package com.example.tyler.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score1;
    private int score2;

    private EditText mEditScore1;
    private Button mManualUpdate1;

    private EditText mEditScore2;
    private Button mManualUpdate2;


    private Button mTeam1ManualUpdate;
    private Button mTeam2ManualUpdate;
    private Button mTeam1Plus;
    private Button mTeam1Minus;
    private Button mTeam2Plus;
    private Button mTeam2Minus;

    private TextView mTeam1Score;
    private TextView mTeam2Score;

    private Button mImageArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTeam1Plus = findViewById(R.id.team1Minus);
        mTeam1Minus = findViewById(R.id.team1Plus);
        mTeam2Plus = findViewById(R.id.team2Minus);
        mTeam2Minus = findViewById(R.id.team2Plus);
        mTeam1ManualUpdate =findViewById(R.id.team1manualUpdate);
        mTeam2ManualUpdate =findViewById(R.id.team2ManualUpdate);
        mTeam1Score = findViewById(R.id.team1Score);
        mTeam2Score = findViewById(R.id.team2Score);

        mEditScore1 = findViewById(R.id.team1manualEntry);
        mManualUpdate1 = findViewById(R.id.team1manualUpdate);

        mEditScore2 = findViewById(R.id.team2ManualEntry);
        mManualUpdate2 = findViewById(R.id.team2ManualUpdate);

        mImageArray = findViewById(R.id.imageArray);

        final Intent intent = new Intent(this, ImageArray.class);


        mManualUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = mEditScore1.getText().toString();

                score1 = Integer.parseInt(text2);
                mTeam1Score.setText("Score: " + score1);
            }
        });

        mManualUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = mEditScore2.getText().toString();

                score2 = Integer.parseInt(text2);
                mTeam2Score.setText("Score: " + score2);
            }
        });

        mTeam1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1--;
                mTeam1Score.setText("Score: " + score1);
            }
        });
        mTeam1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1++;
                mTeam1Score.setText("Score: " + score1);
            }
        });

        mTeam2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2--;
                mTeam2Score.setText("Score: " + score2);
            }
        });
        mTeam2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2++;
                mTeam2Score.setText("Score: " + score2);
            }
        });

        mImageArray.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });



    }
}
