package com.innoventes.jukebox.test.matrix;

import java.util.Scanner;

public class TurnMatrixBy90 {

    public static void main(String[] args) {
        int[][] inputMatrix = new int[3][3];
        int[][] outputMatrix = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("Enter element" + i + "," + j  +" :");
                inputMatrix[i][j] = scanner.nextInt();
            }
        }
        printMatrix(inputMatrix);
        System.out.println("output matrix \n");
        int i = 0;
        while (i < 3){
            for(int c = 2; c >= 0; c--) {
                for (int r = 0; r < 3; r++) {
                    outputMatrix[r][c] = inputMatrix[i][r];
                }
                i++;
            }
        }
        printMatrix(outputMatrix);
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }
}
