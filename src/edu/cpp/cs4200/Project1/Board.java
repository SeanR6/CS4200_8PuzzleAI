package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static edu.cpp.cs4200.Project1.MoveTile.*;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;
    private int[] hammingSearchCost = new int[25];
    private int[] hammingSearchIterations = new int[25];
    private int[] hammingIterations = new int[25];

    public Board() {
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
             HammingData output = HammingSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
             hammingSearchCost[output.depth] = hammingSearchCost[output.depth] + output.searchCost;
             int hammingIters = hammingSearchIterations[output.depth];
             hammingSearchIterations[output.depth] = ++hammingIters;
         }
    }

    //practice with 100 first
    public void runIterations() {
        for (int i = 0; i < 1000; i++) {
            randomizeBoard();
            solveHamming();
        }
        for (int i = 2; i < hammingSearchIterations.length; i += 1) {
            if (hammingSearchIterations[i] != 0) {
                System.out.println(i + " | " + (hammingSearchCost[i] + " |" + hammingSearchIterations[i]));
            } else {
                System.out.println(i + " | " + 0);
            }
        }
    }

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
        //UI.printValidity(validBoard);
    }

    public void generateNewBoard(){
        randomizeBoard();
    }

    public void printBoard(){
        UI.printBoard(gameBoard);
    }

}
