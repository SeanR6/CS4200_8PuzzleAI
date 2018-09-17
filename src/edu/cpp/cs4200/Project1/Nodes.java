package edu.cpp.cs4200.Project1;

public class Nodes {
    Integer[] gameBoard;
    int weight;
    int depth;
    Integer[] parent;

    public Nodes(Integer[] board, int cost, int d, Integer[] p){
        gameBoard = board;
        weight = cost;
        depth = d;
        parent = p;
    }



}
