package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;

    Board(){
        for(int i = 0; i < 9; i++){
            gameBoard.add(i);
        }
        randomizeBoard();
    }

    private void randomizeBoard(){
        Collections.sort(gameBoard);
        for(int i = 0; i < 9; i++){
            Collections.swap(gameBoard, i, RandomGenerator.generateNum());
        }
    }

    public void isValid(){
        Integer[] array = gameBoard.toArray(new Integer[gameBoard.size()]);
        validBoard = ValidCheck.isValid(array);
    }

    public void printBoard(){
        UI.printBoard(gameBoard);
    }
}
