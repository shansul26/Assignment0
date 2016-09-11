package com.example.shannonsullivan.assignment0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int mFibSeqNum = 20;
    private int mFibNum;
    private String mFibNumString;
    private TextView mFibNumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize mFibNumString
        mFibNumString = new String();

        //get the text view to display the fibonacci number on
        mFibNumTextView = (TextView) findViewById(R.id.text_fib_sum);

        try {
            //calculate the fibonacci number to display
            mFibNum = calculateFibonacciNumber(mFibSeqNum);

            //format the string for display
            mFibNumString = String.format(getResources().getString(R.string.fibNum), mFibSeqNum, mFibNum);

        }
        catch(IllegalArgumentException e) {
            //this will happen if mFibNum is negative
            mFibNumString = e.toString();
        }
        catch(Exception e) {
            //not sure what would happen here
            return;
        }

        //update the view with the text to display
        mFibNumTextView.setText(mFibNumString);
    }

    /* Takes an integer i and calculates the i-th fibonacci number and
  	* returns this number
	* @param i - the i-th fib number to calculate
    * @return fibNumber - the calculated fib number
    * @throws IllegalArgumentException - if i is less than 0
    */
    private int calculateFibonacciNumber(int i){
        //check to make sure i is a valid number
        if(i<0){
            String errorMessage = String.format(getResources().getString(R.string.fibNumException), i);
            throw new IllegalArgumentException(errorMessage);
        }
        //set up for calculating the sequence
        int prevFibNum = 0;
        int fibNum = 1;
        for(int num=1; num < i; num++) {
            //add the previous number in the sequence to the current number to get the next number
            fibNum += prevFibNum;

            //recalculate the previous number
            prevFibNum = fibNum - prevFibNum;
        }
        return fibNum;
    }
}
