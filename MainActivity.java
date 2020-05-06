package com.example.braintainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button gobutton;
    ArrayList<Integer> list= new ArrayList<>();
    int locationofcorrectanswer;
    TextView result;
    int score=0;
    int noq=0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumtexview;
    TextView scoreTextView;
    TextView timerTextView; Button playagain;
    ConstraintLayout gamelayout;
    public void start(View view)
    {
        gobutton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        playagain(findViewById(R.id.timerTextView));


    }
    public void playagain(View view)
    {
        score=0;
        noq=0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noq));
        newquestion();
        playagain.setVisibility(View.INVISIBLE);
        result.setText("");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playagain.setVisibility(View.VISIBLE);


            }
        }.start();

    }
    public void newquestion()
    {

        Random rand= new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        sumtexview.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationofcorrectanswer= rand.nextInt(4);
        list.clear();

        for(int i=0;i<4;i++)
        {
            if(i==locationofcorrectanswer)
                list.add(a+b);
            else {
                int wronganswer=rand.nextInt(40);
                while(wronganswer==a+b)
                {
                    wronganswer=rand.nextInt(40);
                }
                list.add(wronganswer);
            }
        }
        button0.setText(Integer.toString(list.get(0)));
        button1.setText(Integer.toString(list.get(1)));
        button2.setText(Integer.toString(list.get(2)));
        button3.setText(Integer.toString(list.get(3)));




    }
    public void chooseAnswer(View view)
    {
        noq++;

        if(Integer.toString(locationofcorrectanswer).equals(view.getTag().toString()))
        {
            result.setText("Correct!");
            score++;

        }else{
            result.setText("Wrong :(");
        }
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noq));
        newquestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gobutton= findViewById(R.id.goButton);

        button0= findViewById(R.id.button0);
        button1= findViewById(R.id.button1);
        button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);

        sumtexview= findViewById(R.id.sumTextView);
        result=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        playagain= findViewById(R.id.playagainbutton);
        gamelayout=findViewById(R.id.newconstraint);

        timerTextView= findViewById(R.id.timerTextView);
        playagain(findViewById(R.id.timerTextView));
        gobutton.setVisibility(View.VISIBLE);
        gamelayout.setVisibility(View.INVISIBLE);




    }
}
