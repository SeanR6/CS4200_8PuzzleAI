package edu.cpp.cs4200.Project1;

import java.util.*;

public class Solve {
    //TODO sample objects to create static function delete later
    //Integer[] gameBoard;
    //Integer[] tempBoard;

    static Integer[][] solvedBoard = new Integer[][]{{0,1,2,3,4,5,6,7,8}, {1,0,2,3,4,5,6,7,8}, {1,2,0,3,4,5,6,7,8}, {1,2,3,0,4,5,6,7,8}, {1,2,3,4,0,5,6,7,8},{1,2,3,4,5,0,6,7,8},{1,2,3,4,5,6,0,7,8},{1,2,3,4,5,6,7,0,8}, {1,2,3,4,5,6,7,8,0}};
    static HammingData invalidBoard = new HammingData(0, 0);
    //int turnsTaken;
    //search cost is number of nodes created
    //int searchCost;
    //Should in theory sort each object by it's weight might need to change to -weight maybe?
    //the index of these arrays are the depth of the solution, the time is the number of nodes created
    //then divide the total by the number solved at that depth

    public static HammingData solveHamming(Integer[] board){
        Integer[] gameBoard = board;
        Integer[] tempBoard;
        Integer[] parent = new Integer[9];

        PriorityQueue<Nodes> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        boolean validTest = true;
        int turnsTaken = 0;
        int searchCost = 0;

        HammingData data = invalidBoard;
        //print initial state of the board
        UI.printBoard(gameBoard);
        while(!checkIfFinished(gameBoard) && turnsTaken <= 24) {
            validTest = true;
            turnsTaken++;
            //if the empty space is in the first corner
            if (gameBoard[0] == 0) {
                //tile 1,1----------------------------------------------------
                searchCost += 2;
                //first option
                tempBoard = swap(gameBoard.clone(), 0, 1);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 0, 3);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if(gameBoard[1] == 0) {
                //tile 1,2-------------------------------------------------------------
                searchCost += 3;
                //first option
                tempBoard = swap(gameBoard.clone(), 1, 0);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 1, 2);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //third option
                tempBoard = swap(gameBoard.clone(), 1, 4);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if (gameBoard[2] == 0) {
                //tile 1,3------------------------------------------------------
                searchCost += 2;
                //first option
                tempBoard = swap(gameBoard.clone(), 2, 1);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 2, 5);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if(gameBoard[3] == 0) {
                //tile 2,1-------------------------------------------------------------
                searchCost += 3;
                //first option
                tempBoard = swap(gameBoard.clone(), 3, 0);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 3, 4);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //third option
                tempBoard = swap(gameBoard.clone(), 3, 6);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if(gameBoard[4] == 0) {
                //tile 2,2-------------------------------------------------------------
                searchCost += 4;
                //first option
                tempBoard = swap(gameBoard.clone(), 4, 1);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 4, 3);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //third option
                tempBoard = swap(gameBoard.clone(), 4, 5);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //fourth option
                tempBoard = swap(gameBoard.clone(), 4, 7);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if(gameBoard[5] == 0) {
                //tile 2,3-------------------------------------------------------------
                searchCost += 3;
                //first option
                tempBoard = swap(gameBoard.clone(), 5, 2);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 5, 4);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //third option
                tempBoard = swap(gameBoard.clone(), 5, 8);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if (gameBoard[6] == 0) {
                //tile 3,1------------------------------------------------------
                searchCost += 2;
                //first option
                tempBoard = swap(gameBoard.clone(), 6, 3);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 6, 7);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if(gameBoard[7] == 0) {
                //tile 3,2-------------------------------------------------------------
                searchCost += 3;
                //first option
                tempBoard = swap(gameBoard.clone(), 7, 6);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 7, 4);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //third option
                tempBoard = swap(gameBoard.clone(), 7, 8);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }else if (gameBoard[8] == 0) {
                //tile 3,1------------------------------------------------------
                searchCost += 2;
                //first option
                tempBoard = swap(gameBoard.clone(), 8, 7);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
                //second option
                tempBoard = swap(gameBoard.clone(), 8, 5);
                Q.add(new Nodes(tempBoard, getHamming(tempBoard) + turnsTaken, turnsTaken, gameBoard.clone()));
            }
            if(parent == Q.peek().gameBoard){
                Q.poll();
            }
            gameBoard = Q.peek().gameBoard;
            turnsTaken = Q.poll().depth;
            UI.printBoard(gameBoard);
            System.out.println("------------------DEPTH = " + turnsTaken);
            System.out.println("------------------COST = " + searchCost);

            if(turnsTaken > 24){
                System.out.println("Puzzle turns taken is greater than 24, skipping this iteration");
                validTest = false;
            }
            //TODO check for max allowable number of iterations == 24 and print out if there is an error
            //TODO remember to print after each iteration
        }
        //TODO remember to return hamming data stuff
        if(validTest == true){
            data = new HammingData(turnsTaken, searchCost);
            System.out.println("Solved");
        }
        return data;

        //TODO remember to calculate and print the average times
    }

    private static boolean checkIfFinished(Integer[] gameBoard) {
        if(Arrays.equals(gameBoard, solvedBoard[0])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[1])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[2])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[3])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[4])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[5])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[6])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[7])){
            return true;
        }else if(Arrays.equals(gameBoard, solvedBoard[8])){
            return true;
        }else{
            return false;
        }
    }

    //this might permanently change the array, might need to change later
    public static Integer[] swap(Integer[] board, int a, int b){
        int placeHolder;
        placeHolder = board[a];
        board[a] = board[b];
        board[b] = placeHolder;
        return board;
    }

    public static int getHamming(Integer[] boardInput){
        //allows the zero to be completely ignored
        List<Integer> board = new ArrayList<>(Arrays.asList(boardInput));
        int index = board.indexOf(0);
        board.remove(index);

        //returns the heuristic for manhattan
        int count = 0;
        if(board.get(0) != 1){
            ++count;
        }
        if(board.get(1) != 2){
            ++count;
        }
        if(board.get(2) != 3){
            ++count;
        }
        if(board.get(3) != 4){
            ++count;
        }
        if(board.get(4) != 5){
            ++count;
        }
        if(board.get(5) != 6){
            ++count;
        }
        if(board.get(6) != 7){
            ++count;
        }
        if(board.get(7) != 8){
            ++count;
        }
        return count;
    }
}
