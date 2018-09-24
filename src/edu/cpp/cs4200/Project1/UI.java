package edu.cpp.cs4200.Project1;

public class UI {
    //this class allows for interaction with the user. Gets input and prints output. Allows for the other files
    //      to be much cleaner

    static void printBoard(Integer[] board){
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
        System.out.println("--------------------------");
    }


    static void printValidity(boolean isValid){
        if(isValid){
            System.out.println("The puzzle is valid");
        }else{
            System.out.println("The puzzle is invalid");
        }
    }

    public static void printMainPrompt() {
        System.out.println("Enter r to generate a random board, c to enter custom board, or e to exit");
        System.out.println("Note: A puzzle is not guaranteed to be solvable, or solvable in a reasonable time");
        System.out.println("If the puzzle takes 25 moves or more the puzzle is skipped and you will be re-prompted");
    }

    public static void printEntryError() {
        System.out.println("Invalid entry, try again");
    }

    public static void exitText() {
        System.out.println("Program exiting now...");
    }

    public static void randomGen() {
        System.out.println("Generating random puzzle...");
    }

    public static void boardEntryPrompt() {
        System.out.println("Please enter your puzzle one number at a time in order of left to right then up to down");
        System.out.println("i.e (1,1) then (1,2) then (1,3) then (2,1) etc.");
        System.out.println("only numbers 0-8 will be accepted, where 0 is the blank space");
    }

    public static void boardSpacePrompt(int i) {
        System.out.println("Please enter the number for space number " + (i + 1) + ": ");
    }
}
