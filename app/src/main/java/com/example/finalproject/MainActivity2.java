package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;
    int mscore;
    TextView counter;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_10, false),





    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        counter = (TextView) findViewById(R.id.counter);
        TrueFalse firstQuestion = mQuestionBank[mIndex];
        mQuestion = mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"True pressed");
                checkAnswer(true);
                updateQuestion();

            }
        };
        mTrueButton.setOnClickListener(myListener);
        mFalseButton.setOnClickListener (new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"False pressed");
                //Toast t = Toast.makeText(getApplicationContext(),"False Button Pressed", Toast.LENGTH_LONG);
                // t.show();
                checkAnswer(false);
                updateQuestion();
            }
        });

    }
    private void updateQuestion(){
        mIndex= (mIndex+1)% mQuestionBank.length;
        mQuestion = mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);
        if (mIndex ==0) {
            Toast.makeText(getApplicationContext(), "You have scored " + mscore + "correct answers", Toast.LENGTH_LONG).show();
            mscore = 0;
        }
    }
    private void checkAnswer(boolean userSelection){
        boolean  correctAnswer = mQuestionBank[mIndex].ismAnswer();
        if (userSelection == correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast, Toast.LENGTH_LONG).show();
            mscore=mscore+1;
            counter.setText(Integer.toString(mscore));
        }else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast, Toast.LENGTH_LONG).show();
        }
    }
}
