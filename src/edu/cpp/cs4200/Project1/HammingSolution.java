package edu.cpp.cs4200.Project1;

import java.util.*;

public class HammingSolution {
    private static int depth;
    private static int solutionSize;
    private static Integer[] emptyParent = new Integer[]{0,0,0,0,0,0,0,0,0,0};
    private static Node emptyNodeParent = new Node(emptyParent, Integer.MAX_VALUE, Integer.MAX_VALUE, null);

    public static Node solve(Integer[] board){
        Node nodeStart = new Node(board, getHamming(board), 0, emptyNodeParent);
        Node finalSolution = new Node(null, Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 10, null);
        Queue<Node> successors;
        depth = 0;
        solutionSize = 0;
        Node finalNode = null;
        List<Node> closedList = new ArrayList<>();
        boolean finished = false;

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        openList.add(nodeStart);
        Node q;
        Queue<Node> children;
        while(!openList.isEmpty()){
            q = openList.poll();
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
                    }//TODO fix weight comparison, it is always being set to 6
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
            if(finished == true){
                break;
            }
            closedList.add(q);
        }



        //node current should be guaranteed to the the smallest node
        printSolution(finalNode);
        return nodeStart;
    }



    static int containsBoard(Node in, PriorityQueue<Node> q){
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

    static int containsBoard(Node in, List<Node> list){
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

    static boolean comparator(Integer[] a, Integer[] b){
        for(int i = 0; i < 9; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    private static void printSolution(Node nodeCurrent) {
        Stack<Node> printStack = new Stack<>();
        Node currentNode = nodeCurrent;
        while(!currentNode.gameBoard.equals(emptyParent)){
            printStack.push(currentNode);
            currentNode = currentNode.parent;
        }
        while(!printStack.isEmpty()){
            UI.printBoard(printStack.pop().gameBoard);
        }
        System.out.println("Solution depth " + (depth - 1));
        System.out.println("Solution size " + solutionSize);
    }

    private static Queue<Node> generateSuccessors(Node nodeCurrent) {
        Integer[] currentBoard = nodeCurrent.gameBoard;
        Queue<Node> output = new LinkedList<>();
        Integer[] tempBoard;
        if(currentBoard[0] == 0){
            tempBoard = moveRight(currentBoard.clone(), 0);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 0);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[1] == 0){
            tempBoard = moveRight(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 1);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[2] == 0){
            tempBoard = moveDown(currentBoard.clone(), 2);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 2);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[3] == 0){
            tempBoard = moveRight(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 3);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[4] == 0){
            tempBoard = moveRight(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 4);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[5] == 0){
            tempBoard = moveLeft(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 5);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[6] == 0){
            tempBoard = moveUp(currentBoard.clone(), 6);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 6);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[7] == 0){
            tempBoard = moveLeft(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[8] == 0){
            tempBoard = moveUp(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 7);
            if(!Arrays.equals(tempBoard, nodeCurrent.parent.gameBoard)){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }
        return output;
    }

    private static Integer[] moveDown(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i+3];
        inBoard[i+3] = temp;
        return inBoard;
    }

    private static Integer[] moveRight(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i+1];
        inBoard[i+1] = temp;
        return inBoard;
    }

    private static Integer[] moveUp(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i-3];
        inBoard[i-3] = temp;
        return inBoard;
    }

    private static Integer[] moveLeft(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i-1];
        inBoard[i-1] = temp;
        return inBoard;
    }

    private static boolean checkIfFinished(Integer[] gameBoard) {
        Integer[] solutionArray = {1,2,3,4,5,6,7,8};
        List gameList = new ArrayList(Arrays.asList(gameBoard));
        gameList.remove(gameList.indexOf(0));

        return Arrays.equals(solutionArray, gameList.toArray());
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
