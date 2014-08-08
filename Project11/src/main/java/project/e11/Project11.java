/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.project.e11;


/**
 *
 * @author robert
 */
public final class Project11 {

    /**
     * Not called.
     */
    private Project11() {
    }

    /**
     * @param args_ the command line arguments
     */
    public static void main(final String[] args_) {
        if (args_.length != 2) {
            System.out.println("Invalid number of arguments");
            //System.exit(0);
        } else {
            size = Integer.parseInt(args_[1]);
            Project11FileReader r =
                    new Project11FileReader(args_[0], size);
            if (r.readFile()) {
                digits = r.getDigits();
                int product = bestPath();
                System.out.println(product + "");
            } else {
                System.out.println("Error reading file");
            }
        }
    }

    /**
     * Calculates the path of length _STRING_LENGTH with the greatest product.
     * @return integer
     */
    private static int bestPath() {
        int bestPath = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (horizontal(i, j) > bestPath) {
                    bestPath = horizontal(i, j);
                }
                if (vertical(i, j) > bestPath) {
                    bestPath = vertical(i, j);
                }
                if (diagonalR(i, j) > bestPath) {
                    bestPath = diagonalR(i, j);
                }
                if (diagonalL(i, j) > bestPath) {
                    bestPath = diagonalL(i, j);
                }
            }
        }
        return bestPath;
    }

    /**
     * Returns horizontal product starting from position [i][j].
     * @param indI_ index
     * @param indJ_ index
     * @return product
     */
    private static int horizontal(final int indI_, final int indJ_) {
        int i = indI_;
        int j = indJ_;
        int total = -1;
        if (j < size - _STRING_LENGTH) {
            total = digits[i][j++] * digits[i][j++]
                    * digits[i][j++] * digits[i][j];
        }
        return total;
    }

    /**
     * Returns vertical product starting from [i][j].
     * @param indI_ index
     * @param indJ_ index
     * @return product
     */
    private static int vertical(final int indI_, final int indJ_) {
        int i = indI_;
        int j = indJ_;
        int total = -1;
        if (i < size - _STRING_LENGTH) {
            total = digits[i++][j] * digits[i++][j]
                    * digits[i++][j] * digits[i][j];
        }
        return total;
    }

    /**
     * Returns right diagonal product starting from [i][i].
     * @param indI_ index
     * @param indJ_ index
     * @return product
     */
    private static int diagonalR(final int indI_, final int indJ_) {
        int i = indI_;
        int j = indJ_;
        int total = -1;
        if (i < size - _STRING_LENGTH && j < size - _STRING_LENGTH) {
            total = digits[i++][j++] * digits[i++][j++]
                    * digits[i++][j++] * digits[i][j];
        }
        return total;
    }

    /**
     * Returns left diagonal product starting from [i][i].
     * @param indI_ index
     * @param indJ_ index
     * @return product
     */
    private static int diagonalL(final int indI_, final int indJ_) {
        int i = indI_;
        int j = indJ_;
        int total = -1;
        if (i >= _STRING_LENGTH - 1 && j < size - _STRING_LENGTH) {
            total = digits[i--][j++] * digits[i--][j++]
                    * digits[i--][j++] * digits[i][j];
        }
        return total;
    }

    /**
     * Length of product list.
     */
    private static final int _STRING_LENGTH = 4;

    /**
     * Array of digits.
     */
    private static int[][] digits;
    /**
     * size of array.
     */
    private static int size;
}
