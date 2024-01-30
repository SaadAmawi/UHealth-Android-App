package com.example.finalproject;

public class TrueFalse {
    private int mQuestionID;
    private boolean mAnswer;
    public TrueFalse (int questionResourceID,boolean trueOrFalse) {
        mQuestionID= questionResourceID;
        mAnswer=trueOrFalse;
    }

    public int getmQuestionID() {
        return mQuestionID;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
