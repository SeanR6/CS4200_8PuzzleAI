package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;
    private int[] hammingSearchCost = new int[25];
    private int[] hammingIterations = new int[25];
    //TODO create temporary program that runs 100 iterations of each, then modify to fit the descriptions of the project
    Board(){
        for(int i = 0; i < 9; i++){
            gameBoard.add(i);
        }
        randomizeBoard();
    }

    public Board(Integer[] inputBoard){
         gameBoard = Arrays.asList(inputBoard);
    }
    //used for basic program, not the 1000 iterations test
    public void solveHamming(){
         isValid();
         if(validBoard) {
             HammingSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
         }
    }
    //TODO generate new function that allows us to generate a board using n number of moves such that we can have
        //a definite depth, consider complete randomization though
    private void randomizeBoard(){
        Collections.sort(gameBoard);
        for(int i = 0; i < 9; i++){
            Collections.swap(gameBoard, i, RandomGenerator.generateNum());
        }
    }

    public void isValid(){
        Integer[] array = gameBoard.toArray(new Integer[gameBoard.size()]);
        validBoard = ValidCheck.isValid(array);
        UI.printValidity(validBoard);
    }

    public void generateNewBoard(){
        randomizeBoard();
    }

    public void printBoard(){
        UI.printBoard(gameBoard);
    }
}
