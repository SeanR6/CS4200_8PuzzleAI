package edu.cpp.cs4200.Project1;

public class Node {
    Integer[] gameBoard;
    int weight;
    int depth;
    int hueristic;
    Node parent;

    public Node(Integer[] board, int heuristicIn, int depthIn, Node p){
        gameBoard = board;
        hueristic = heuristicIn;
        weight = heuristicIn + depthIn;
        depth = depthIn;
        parent = p;
    }



}
