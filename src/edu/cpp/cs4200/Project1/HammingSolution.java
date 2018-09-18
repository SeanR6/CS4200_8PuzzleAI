package edu.cpp.cs4200.Project1;

import java.util.*;

public class HammingSolution {
    private static int depth;
    private static int solutionSize;
    private static Integer[] emptyParent = new Integer[]{0,0,0,0,0,0,0,0,0,0};
    private static Node emptyNodeParent = new Node(emptyParent, Integer.MAX_VALUE, Integer.MAX_VALUE, null);

    public static void solve(Integer[] board){
        Node nodeStart = new Node(board, getHamming(board), 0, emptyNodeParent);
        Node finalSolution = new Node(null, Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 10, null);
        Queue<Node> successors;
        depth = 0;
        solutionSize = 0;
        Node nodeCurrent = null;
        List<Node> closedList = new ArrayList<>();

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        openList.add(nodeStart);


        while(!openList.isEmpty()){
            nodeCurrent = openList.poll();

            if(checkIfFinished(nodeCurrent.gameBoard)){
                if(finalSolution.weight > nodeCurrent.weight){
                    finalSolution = nodeCurrent;
                }
                break;
            }

            //create function: Generate successors, add to list, don't add parent successor
            depth = nodeCurrent.depth + 1;
            successors = generateSuccessors(nodeCurrent);
        //issue with comparing gameboards, it looks like it checks for an id
            //also look for adding to closed and open list, there are duplicates which shouldnt be there
            while(!successors.isEmpty()){
                Node successor = successors.poll();
                if(openList.contains(successor.gameBoard)){
                    Iterator<Node> boardInList = openList.iterator();
                    while(boardInList.hasNext()){
                        Node listBoard = boardInList.next();
                        if(listBoard.gameBoard.equals(successor.gameBoard) && listBoard.weight < successor.weight){
                            continue;
                        }
                    }
                }else if(closedList.contains(successor.gameBoard)){
                    int index = closedList.indexOf(successor.gameBoard);
                    if(closedList.get(index).weight < successor.weight){
                        continue;
                    }
                    closedList.remove(index);
                    openList.add(successor);
                    solutionSize++;
                }else{
                    openList.add(successor);
                    solutionSize++;
                }
            }
            closedList.add(nodeCurrent);
        }

        //node current should be guaranteed to tbe the smallest node
        printSolution(nodeCurrent);
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
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 0);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[1] == 0){
            tempBoard = moveRight(currentBoard.clone(), 1);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 1);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 1);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[2] == 0){
            tempBoard = moveDown(currentBoard.clone(), 2);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 2);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[3] == 0){
            tempBoard = moveRight(currentBoard.clone(), 3);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 3);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 3);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[4] == 0){
            tempBoard = moveRight(currentBoard.clone(), 4);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 4);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 4);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 4);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[5] == 0){
            tempBoard = moveLeft(currentBoard.clone(), 5);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveDown(currentBoard.clone(), 5);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 5);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[6] == 0){
            tempBoard = moveUp(currentBoard.clone(), 6);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 6);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[7] == 0){
            tempBoard = moveLeft(currentBoard.clone(), 7);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveRight(currentBoard.clone(), 7);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveUp(currentBoard.clone(), 7);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
        }else if(currentBoard[8] == 0){
            tempBoard = moveUp(currentBoard.clone(), 7);
            if(tempBoard != nodeCurrent.parent.gameBoard){
                output.add(new Node(tempBoard, getHamming(tempBoard), depth, nodeCurrent));
            }
            tempBoard = moveLeft(currentBoard.clone(), 7);
            if(tempBoard != nodeCurrent.parent.gameBoard){
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
        List solutionList = new ArrayList(Arrays.asList(solutionArray));
        List gameList = new ArrayList(Arrays.asList(gameBoard));
        gameList.remove(gameList.indexOf(0));

        return gameList.equals(solutionList);
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
