package com.cst2335.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cst2335.quizapp.ModelClass.Question;
import com.cst2335.quizapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //  controls
    TextView txCounter, txTimer, txQuestion;
    Button bOpt1, bOpt2, bOpt3, bOpt4;


    //  list for questions
    ArrayList<Question> questionList = new ArrayList<>();

    int counter = 0;
    CountDownTimer cdTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  find view
        txQuestion = findViewById(R.id.txQuestion);
        txCounter = findViewById(R.id.txCounter);
        txTimer = findViewById(R.id.txTimer);

        bOpt1 = findViewById(R.id.bOpt1);
        bOpt2 = findViewById(R.id.bOpt2);
        bOpt3 = findViewById(R.id.bOpt3);
        bOpt4 = findViewById(R.id.bOpt4);

        //  load data here
        questionList.add(new Question("JavaFx BorderPane will divide the screen into a maximum of _________.",
                "2 components", "4 components",
                "6 components", "none of the above", "none of the above"));

        questionList.add(new Question("What goes on four feet in the morning, two feet at noon, and three feet in the evening?",
                "A person", "Whatever, I choose death",
                "A glorious apache helicopter", "A Canadian lynx", "A person"));

        questionList.add(new Question("Which casket contains Portia's picture? ",
                "gold casket: Who chooseth me shall gain what many men desire.",
                "silver casket: Who chooseth me shall get as much as he deserves.",
                "lead casket: Who chooseth me must give and hazard all he hath.",
                "Instagram", "Instagram"));


        loadQuestions(counter);

        //  timer
        txTimer.setText("10 seconds");
        cdTimer = new CountDownTimer(10 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                txTimer.setText(millisUntilFinished / 1000 + " seconds ");
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time's up!", Toast.LENGTH_LONG).show();
            }
        }.start();


    }


    public void loadQuestions(int n) {
        final Question que = questionList.get(n);

        //  question down counter
        txCounter.setText((n + 1) + "/" + questionList.size());

        txTimer.setText("" + 10);
        if (cdTimer != null) {
            cdTimer.start();
        }


        txQuestion.setText("#" + (n + 1) + " " + que.getQuestion());
        txQuestion.setText(que.getQuestion());

        bOpt1.setText("" + que.getOpt1());
        bOpt2.setText("" + que.getOpt2());
        bOpt3.setText("" + que.getOpt3());
        bOpt4.setText("" + que.getOpt4());

        //  btn 1
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bOpt1.getText().equals(que.getCorrectOpt())) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if (counter < (questionList.size() - 1)) {
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "Quiz Complete", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //  btn 2
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bOpt2.getText().equals(que.getCorrectOpt())) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if (counter < (questionList.size() - 1)) {
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "Quiz Complete", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //  btn 3
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bOpt3.getText().equals(que.getCorrectOpt())) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if (counter < (questionList.size() - 1)) {
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "Quiz Complete", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //  btn 4
        bOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bOpt4.getText().equals(que.getCorrectOpt())) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if (counter < (questionList.size() - 1)) {
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "Quiz Complete", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
