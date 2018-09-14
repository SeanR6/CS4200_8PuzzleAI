package com.company;

public class ValidCheck {
    public static boolean isValid(int[] tile){
        int inversions = 0;
        for(int i = 0; i < 9; i++){
            if(tile[i] > i && tile[i] != 0){
                for(int j = i; j < 9; j++){
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
