package edu.cpp.cs4200.Project1;

public class ValidCheck {
    public static boolean isValid(Integer[] tile){
        int inversions = 0;
        for(int i = 0; i < 9; i++){
            if(tile[i] != 0){
                for(int j = i+1; j < 9; j++){
                    if (tile[i] > tile[j] && tile[j] != 0){
                        ++inversions;
                    }
                }
            }
        }

        if(inversions % 2 == 0){
            return true;
        }

        //change later, here to get rid of errors
        return false;
    }
}
