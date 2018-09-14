package edu.cpp.cs4200.Project1;

import java.util.List;

public class UI {
    //this class allows for interaction with the user. Gets input and prints output. Allows for the other files
    //      to be much cleaner
    static void printBoard(List<Integer> board){
        System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
        System.out.println(board.get(3) + " " + board.get(4) + " " + board.get(5));
        System.out.println(board.get(6) + " " + board.get(7) + " " + board.get(8));
        System.out.println("-------------------");
    }

    static void printBoard(Integer[] board){
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
        System.out.println("-------------------");
    }

    static void printValidity(boolean isValid){
        if(isValid){
            System.out.println("The puzzle is valid");
        }else{
            System.out.println("The puzzle is invalid");
        }
    }
}
