package com.example.android.slotmachine;

/**
 * Created by william on 4/9/15.
 */
public class SpinnersData {

    private char[] spinner_array_01;
    private char[] spinner_array_02;
    private char[] spinner_array_03;

    public char[] getSpinner_array_01() {
        return spinner_array_01;
    }

    public char[] getSpinner_array_02() {
        return spinner_array_02;
    }

    public char[] getSpinner_array_03() {
        return spinner_array_03;
    }



    private int acumulated_credits;

    private int playing_credits;

    private static SpinnersData ourInstance = new SpinnersData();

    public static SpinnersData getInstance() {
        return ourInstance;
    }

    private SpinnersData() {

        spinner_array_01 = new char[]{'7','B','3','B','2','B','2','B','1','B','1','B','1','B','C','B','C'};
        spinner_array_02 = new char[]{'7','B','3','B','2','B','2','B','1','B','1','B','1','B','C','B','C'};
        spinner_array_03 = new char[]{'7','B','3','B','2','B','2','B','1','B','1','B','1','B','C','B','C'};

    }
}
