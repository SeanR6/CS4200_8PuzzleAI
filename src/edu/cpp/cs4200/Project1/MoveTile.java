package edu.cpp.cs4200.Project1;

class MoveTile {
    static Integer[] moveDown(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i + 3];
        inBoard[i + 3] = temp;
        return inBoard;
    }

    static Integer[] moveRight(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i + 1];
        inBoard[i + 1] = temp;
        return inBoard;
    }

    static Integer[] moveUp(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i - 3];
        inBoard[i - 3] = temp;
        return inBoard;
    }

    static Integer[] moveLeft(Integer[] inBoard, int i) {
        int temp = inBoard[i];
        inBoard[i] = inBoard[i - 1];
        inBoard[i - 1] = temp;
        return inBoard;
    }
}
