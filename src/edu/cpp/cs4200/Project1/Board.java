package edu.cpp.cs4200.Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Integer> gameBoard = new ArrayList();
    private boolean validBoard;
    private int[] hammingSearchCost = new int[25];
    private int[] hammingSearchIterations = new int[25];
    private int[] manhattanSearchCost = new int[25];
    private int[] manhattanSearchIterations = new int[25];

    public Board() {
        for(int i = 0; i < 9; i++){
            gameBoard.add(i);
        }
        randomizeBoard();
    }

    public Board(Integer[] inputBoard){
         gameBoard = Arrays.asList(inputBoard);
    }


    public void solveHamming(){
             SolutionData output = HammingSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
             hammingSearchCost[output.depth] = hammingSearchCost[output.depth] + output.searchCost;
             int hammingIteration = hammingSearchIterations[output.depth];
             hammingSearchIterations[output.depth] = ++hammingIteration;

    }

    public void solveManhattan() {
            SolutionData output = ManhattanSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
            manhattanSearchCost[output.depth] = manhattanSearchCost[output.depth] + output.searchCost;
            int manhattanIteration = manhattanSearchIterations[output.depth];
            manhattanSearchIterations[output.depth] = ++manhattanIteration;

    }

    public void solveBoth() {
        isValid();
        if (validBoard) {
            ManhattanSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
            HammingSolution.solve(gameBoard.toArray(new Integer[gameBoard.size()]));
        }
    }


    public void runIterations() {
        for (int i = 0; i < 500; i++) {
            randomizeBoard();
            isValid();
            if (validBoard) {
                solveManhattan();
                solveHamming();
                continue;
            }
            --i;
        }
        System.out.printf("%-22s%-22s%-22s%-22s", "depth", "Iterations", "Hamming", "Manhattan");
        System.out.println();
        for (int i = 2; i < hammingSearchIterations.length; i += 1) {
            if (hammingSearchIterations[i] != 0) {
                int hammingCost = hammingSearchCost[i] / hammingSearchIterations[i];
                int manhattanCost = manhattanSearchCost[i] / hammingSearchIterations[i];
                //System.out.println(i + " | " + (hammingSearchCost[i] + " | " + hammingSearchIterations[i] + " | " + manhattanSearchCost[i]));
                System.out.printf("%-22s%-22s%-22s%-22s", i, hammingSearchIterations[i], hammingCost, manhattanCost);
                System.out.println();
            } else {
                System.out.printf("%-22s%-22s%-22s%-22s", i, 0, 0, 0);
                System.out.println();
            }
        }
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
        UI.printValidity(validBoard);
    }

    public void generateNewBoard(){
        randomizeBoard();
    }

    public void printBoard(){
        UI.printBoard(gameBoard);
    }

}
