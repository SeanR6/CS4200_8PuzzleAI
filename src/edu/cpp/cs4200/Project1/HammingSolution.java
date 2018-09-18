package edu.cpp.cs4200.Project1;

import java.util.*;

public class HammingSolution {
    private static int depth;
    private static int solutionSize;

    public static void solve(Integer[] board){
        Node nodeStart = new Node(board, getHamming(board), 0, null);
        Node finalSolution = new Node(null, Integer.MAX_VALUE, Integer.MAX_VALUE, null );
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
            ++depth;
            successors = generateSuccessors(nodeCurrent);

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
                }else{
                    openList.add(successor);
                }
            }
            closedList.add(nodeCurrent);
        }

        //node current should be guaranteed to tbe the smallest node
        printSolution(nodeCurrent);
    }

    private static void printSolution(Node nodeCurrent) {
        Queue<Node> printQueue = new LinkedList<>();
        Node currentNode = nodeCurrent;
        while(!printQueue.peek().parent.equals(null)){
            printQueue.add(currentNode);
            currentNode = currentNode.parent;
        }
        while(!printQueue.isEmpty()){
            UI.printBoard(printQueue.poll().gameBoard);
        }
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
        List solutionList = new ArrayList();
        solutionList = Arrays.asList(solutionArray);
        solutionList.remove(solutionList.indexOf(0));

        return gameBoard.equals(solutionList.toArray());
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
