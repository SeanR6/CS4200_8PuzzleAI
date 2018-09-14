package edu.cpp.cs4200.Project1;

import java.util.Random;

public class RandomGenerator {
    static Random rand = new Random(System.currentTimeMillis());

    //this is made just in case I need more detailed number generation
    public static int generateNum(int low, int high){
        return rand.nextInt((high-low) + 1) + low;
    }

    //this is the primary generator function, this will allow tiles to be swapped
    public static int generateNum(){
        return rand.nextInt(9);
    }
}
