package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;

    public Board(){
        for(int i = 0; i < 9; i++){
            gameBoard.add(i);
        }
        randomizeBoard();
    }

    private void randomizeBoard(){
        for(int i = 0; i < 9; i++){
            Collections.swap(gameBoard, i, RandomGenerator.generateNum());
        }
    }

    public void isValid(){
        Integer[] array = gameBoard.toArray(new Integer[gameBoard.size()]);
        validBoard = ValidCheck.isValid(array);
    }

    public void printBoard(){
        System.out.println(gameBoard.get(0) + " " + gameBoard.get(1) + " " + gameBoard.get(2));
        System.out.println(gameBoard.get(3) + " " + gameBoard.get(4) + " " + gameBoard.get(5));
        System.out.println(gameBoard.get(6) + " " + gameBoard.get(7) + " " + gameBoard.get(8));

        if(validBoard == true){
            System.out.println("The board is valid");
        }else{
            System.out.println("The board is invalid");
        }
    }
}
