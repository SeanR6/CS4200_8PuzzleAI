package edu.cpp.cs4200.Project1;

import java.util.Arrays;
import java.util.Scanner;

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

        //^^each node depth will have its own set of costs, try maybe an array of the depth
        //   then each of those will have a n=2 array for h1 and then h2, so that they can be easily compared


        //for running large number of iterations
        //Board b = new Board();
        //b.runIterations();

        boolean programVar = true;
        char userInput;
        Scanner input = new Scanner(System.in);
        Scanner entry = new Scanner(System.in);
        while (programVar) {
            UI.printMainPrompt();
            userInput = input.next().charAt(0);
            if (userInput == 'r' || userInput == 'R') {
                UI.randomGen();
                Board board = new Board();
                board.solveBoth();
            } else if (userInput == 'c' || userInput == 'C') {
                UI.boardEntryPrompt();
                Integer[] userBoard = new Integer[9];
                for (int i = 0; i < 9; i++) {
                    UI.boardSpacePrompt(i);
                    char numberIn = entry.next().charAt(0);
                    int number = numberIn - '0';
                    if (number >= 0 && number <= 8 && !(Arrays.asList(userBoard).contains(number))) {
                        userBoard[i] = number;
                    } else {
                        System.out.println("Invalid input, or number already used");
                        i--;
                    }
                }
                Board board = new Board(userBoard);
                board.solveBoth();
            } else if (userInput == 'e' || userInput == 'E') {
                UI.exitText();
                programVar = false;
            } else {
                UI.printEntryError();
            }
            System.out.println("\n--------------------------\n");
        }
        input.close();
        entry.close();
    }
}
