package edu.cpp.cs4200.Project1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class HammingSolver {
    private int depth;
    private int searchCost;
    private boolean isSolved;
    Integer[] gameBoard;

    private Integer[] solvedArray = {0,1,2,3,4,5,6,7,8};

    public void solve(Integer[] inBoard){
        gameBoard = inBoard;
        UI.printBoard(gameBoard);
        while(!checkIfSolved(gameBoard)){
            if(gameBoard[0] == 0){
                searchCost+=2;
                Hamming()
            }
        }
    }
    

    private void swap(int a, int b) {
        int placeholder = gameBoard[a];
        gameBoard[a] = gameBoard[b];
        gameBoard[b] = placeholder;

    }

    private boolean checkIfSolved (Integer[] gameBoard){
        if(gameBoard==solvedArray){
            return true;
        }
        return false;
    }
}
