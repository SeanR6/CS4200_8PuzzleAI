package edu.cpp.cs4200.Project1;

public class Main {

    public static void main(String[] args) {
	    //first we need to verify the algorithm using the data we were given
        //Then we need to randomly generate and run 1000 valid cases
        //we can check for solvability using inversions
        //keep track of depth
        //range of data that should be tested is 2 <= d <= 24
        //once tested ui should be implemented for a user to be able to generate a single random valid puzzle and show
        //  steps to solve the puzzle for each heuristic, along with solution depth and search cost for each heuristic
        //
        //A second option should be implemented such that a user inputs a puzzle to be solved
        //look at data sheet for input format, then display the same things as the randomly generated puzzle
        //input/output and handle exceptions gracefully

        //h(n)1 is number of misplaced tiles i.e hamming
        //h(n)2 is the sum of the distances of the tiles from their goal positions i.e manhattan
        //  for manhattan distance, translate array into a 3x3 board
        //g(n) is number of moves made so far

        //TODO keep in mind search costs, which are the number of nodes created
        //^^each node depth will have its own set of costs, try maybe an array of the depth
        //   then each of those will have a n=2 array for h1 and then h2, so that they can be easily compared

        //tests:
        Integer[] board = new Integer[]{0,5,7,6,8,1,2,4,3};
        Board gameBoard = new Board(board);
        gameBoard.solveHamming();
    }
}
