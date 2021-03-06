package edu.cpp.cs4200.Project1;

import java.util.*;

import static edu.cpp.cs4200.Project1.MoveTile.*;

public class HammingSolution {
    private static int depth;
    private static int solutionSize;
    private static Integer[] emptyParent = new Integer[]{0,0,0,0,0,0,0,0,0,0};
    private static Node emptyNodeParent = new Node(emptyParent, Integer.MAX_VALUE, Integer.MAX_VALUE, null);

    public static void solve(Integer[] board) {
        Node nodeStart = new Node(board, getHamming(board), 0, emptyNodeParent);
        depth = 0;
        solutionSize = 0;
        Node finalNode = null;
        List<Node> closedList = new ArrayList<>();
        boolean finished = false;

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        openList.add(nodeStart);
        Node q;
        Queue<Node> children;
        while (!openList.isEmpty() && depth < 23) {
            q = openList.poll();
            depth = q.depth;
            children = generateSuccessors(q);

            while(!children.isEmpty()){
                Node child = children.poll();
                if(checkIfFinished(child.gameBoard)){
                    finalNode = child;
                    finished = true;
                    break;
                }
                int index = containsBoard(child, openList);
                if(index < openList.size()){
                    Iterator<Node> iter = openList.iterator();
                    Node item = null;
                    while(index > 0){
                        item = iter.next();
                        index--;
                    }
                    if(child.weight < item.weight){
                        openList.remove(item);
                        openList.add(child);
                        continue;
                    }else {
                        continue;
                    }
                }
                index = containsBoard(child, closedList);
                Node item = null;
                if(index < closedList.size()){
                    item = closedList.get(index);
                    if(child.weight < item.weight){
                        closedList.remove(index);
                        openList.add(child);
                        continue;
                    }else{
                        continue;
                    }
                }
                openList.add(child);
            }
            if (finished) {
                break;
            }
            closedList.add(q);
        }

        if (depth < 23) {
            //node current should be guaranteed to the the smallest node
            SolutionData output = new SolutionData(printSolution(finalNode), solutionSize);
            return;
        }

        new SolutionData(0, 0);
    }


    private static int containsBoard(Node in, PriorityQueue<Node> q) {
        Iterator<Node> i = q.iterator();
        int index = 0;
        while(i.hasNext()){
            index++;
            //use comparator function here
            if(comparator(in.gameBoard, i.next().gameBoard)){
                break;
            }
        }
        return index;
    }

    private static int containsBoard(Node in, List<Node> list) {
        Iterator<Node> i = list.iterator();
        int index = 0;
        while(i.hasNext()){
            index++;
            //use comparator function here
            if(comparator(in.gameBoard, i.next().gameBoard)){
                index--;
                break;
            }
        }
        return index;
    }

    private static boolean comparator(Integer[] a, Integer[] b) {
        for(int i = 0; i < 9; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    private static int printSolution(Node nodeCurrent) {
        Stack<Node> printStack = new Stack<>();
        Node currentNode = nodeCurrent;
        int treeDepth = 0;
        while(!currentNode.gameBoard.equals(emptyParent)){
            printStack.push(currentNode);
            currentNode = currentNode.parent;
            treeDepth++;
        }
        while(!printStack.isEmpty()){
            printStack.pop();
        }
        System.out.println("Hamming solution size " + solutionSize);
        return treeDepth;
    }

    private static Queue<Node> generateSuccessors(Node nodeCurrent) {
        Integer[] currentBoard = nodeCurrent.gameBoard;
        Queue<Node> output = new LinkedList<>();
        Integer[] tempBoard;
        if(currentBoard[0] == 0){
            tempBoard = moveRight(currentBoard.clone(), 0);
            solutionSize++;
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 0);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[1] == 0){
            solutionSize += 2;
            tempBoard = moveRight(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[2] == 0){
            solutionSize++;
            tempBoard = moveDown(currentBoard.clone(), 2);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 2);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[3] == 0){
            solutionSize += 2;
            tempBoard = moveRight(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[4] == 0){
            solutionSize += 3;
            tempBoard = moveRight(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[5] == 0){
            solutionSize += 2;
            tempBoard = moveLeft(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[6] == 0){
            solutionSize++;
            tempBoard = moveUp(currentBoard.clone(), 6);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 6);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[7] == 0){
            solutionSize += 2;
            tempBoard = moveLeft(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }else if(currentBoard[8] == 0){
            solutionSize++;
            tempBoard = moveUp(currentBoard.clone(), 8);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 8);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth + 1, nodeCurrent));
            }
        }
        return output;
    }

    private static boolean checkIfFinished(Integer[] gameBoard) {
        Integer[] solutionArray = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        return Arrays.equals(solutionArray, gameBoard);
    }

    private static int getHamming(Integer[] board) {


        //returns the heuristic for manhattan
        int count = 0;
        if (board[0] != 0) {
            ++count;
        }
        if (board[1] != 1) {
            ++count;
        }
        if (board[2] != 2) {
            ++count;
        }
        if (board[3] != 3) {
            ++count;
        }
        if (board[4] != 4) {
            ++count;
        }
        if (board[5] != 5) {
            ++count;
        }
        if (board[6] != 6) {
            ++count;
        }
        if (board[7] != 7) {
            ++count;
        }
        if (board[8] != 8) {
            ++count;
        }
        return count;
    }
}
