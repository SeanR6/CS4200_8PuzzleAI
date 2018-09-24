package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;

    public Board() {
        for(int i = 0; i < 9; i++){
            gameBoard.add(i);
        }
        randomizeBoard();
    }

    public Board(Integer[] inputBoard){
         gameBoard = Arrays.asList(inputBoard);
    }



    public void solveBoth() {
        isValid();
        if (validBoard) {
            ManhattanSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
            HammingSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
        }
    }


    private void randomizeBoard(){
        Collections.sort(gameBoard);
        for(int i = 0; i < 9; i++){
            Collections.swap(gameBoard, i, RandomGenerator.generateNum());
        }
    }


    private void isValid() {
        Integer[] array = gameBoard.toArray(new Integer[gameBoard.size()]);
        validBoard = ValidCheck.isValid(array);
        UI.printValidity(validBoard);
    }


}
