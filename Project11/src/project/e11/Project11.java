/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.e11;

/**
 *
 * @author robert
 */
public class Project11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Project11FileReader r = new Project11FileReader("src/Files/Input", 20);
        r.readFile();
        digits = r.getDigits();
        int product = bestPath(digits);
        System.out.println(product);
    }
    
    private static int bestPath(int[][] digits) {
        int size = digits.length;
        int bestPath = 0;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (horizontal(i, j, size) > bestPath) bestPath = horizontal(i, j, size);
                if (vertical(i, j, size) > bestPath) bestPath = vertical(i, j, size);
                if (diagonalR(i, j, size) > bestPath) bestPath = diagonalR(i, j, size);
                if (diagonalL(i, j, size) > bestPath) bestPath = diagonalL(i, j, size);
            }
        }
        return bestPath;
    }
    
    private static int horizontal(int i, int j, int size) {
        int total = -1;
        if (j < size - STRING_LENGTH) {
            total = digits[i][j] * digits[i][j+1] * digits[i][j+2] * digits[i][j+3];
        }
        return total;
    }
    
    private static int vertical(int i, int j, int size) {
        int total = -1;
        if (i < size - STRING_LENGTH) {
            total = digits[i][j] * digits[i+1][j] * digits[i+2][j] * digits[i+3][j];
        }
        return total;
    }
    
    private static int diagonalR(int i, int j, int size) {
        int total = -1;
        if (i < size - STRING_LENGTH && j < size - STRING_LENGTH) {
            total = digits[i][j] * digits[i+1][j+1] * digits[i+2][j+2] * digits[i+3][j+3];
        }
        return total;
    }
    
    private static int diagonalL(int i, int j, int size) {
        int total = -1;
        if (i >= STRING_LENGTH-1 && j < size - STRING_LENGTH) {
            total = digits[i][j] * digits[i-1][j+1] * digits[i-2][j+2] * digits[i-3][j+3];
        }
        return total;
    }
    
    private static int STRING_LENGTH = 4;
    private static int[][] digits;
}
