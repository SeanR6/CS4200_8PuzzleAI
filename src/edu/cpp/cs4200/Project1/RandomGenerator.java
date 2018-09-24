package edu.cpp.cs4200.Project1;

import java.util.Random;

public class RandomGenerator {
    private static Random rand = new Random(System.currentTimeMillis());


    //this is the primary generator function, this will allow tiles to be swapped
    public static int generateNum(){
        return rand.nextInt(9);
    }
}
