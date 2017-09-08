package com.alibaraneser.catchthedaffy;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textTime;
    TextView textScore;
    int score;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageList;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textTime = (TextView) findViewById(R.id.textTime);
                textTime.setText("Time : " + millisUntilFinished / 1000 + " Second!");
            }

            @Override
            public void onFinish() {

                textTime = (TextView) findViewById(R.id.textTime);
                textTime.setText("Game Over!");

                handler.removeCallbacks(runnable);
                score = -1;

            }
        }.start();


        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);

        imageList = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hide();
    }

    public void increaseScore(View view) {
        if (score != -1) {
            score++;
            textScore = (TextView) findViewById(R.id.textScore);
            textScore.setText("Score : " + score);
        }
    }

    public void hide() {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView images : imageList) {
                    images.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();

                imageList[random.nextInt(9)].setVisibility(View.VISIBLE);

                handler.postDelayed(runnable, 1000);
            }
        };

        handler.post(runnable);


    }
}
