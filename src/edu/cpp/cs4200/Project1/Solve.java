package edu.cpp.cs4200.Project1;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solve {
    Integer[] gameBoard;
    Integer[] origionalBoard;
    Integer[] solvedBoard = new Integer[]{0,1,2,3,4,5,6,7,8};
    //TODO figure out the proper comparator
    PriorityQueue<Nodes> Q = new PriorityQueue<>();

    public void solve(Integer[] board){
        gameBoard = board;
        origionalBoard = gameBoard;

    }
}
