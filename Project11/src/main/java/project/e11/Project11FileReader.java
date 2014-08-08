/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.project.e11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author robert
 */
public class Project11FileReader {

    /**
     * Constructor.
     * @param fname file address
     * @param sze size of array to be processed
     */
    public Project11FileReader(final String fname, final int sze) {
        this.filename = fname;
        this.size = sze;
        this.digits = new int[size][size];
    }

    /**
     * Reads in file data.
     * @return correct operation
     */
    final boolean readFile() {

        BufferedReader input;
        boolean errorCheck = true;

        try {
            input = new BufferedReader(new FileReader(filename));

            String line;
            int lineNumber = 0;
            StringTokenizer st;
            String token;
            while ((line = input.readLine()) != null) {
                if (lineNumber == size) {
                    errorCheck = false;
                    break;
                }
                st = new StringTokenizer(line);
                int i = 0;
                while (st.hasMoreElements()) {
                    if (i == size) {
                        errorCheck = false;
                        break;
                    }
                    digits[lineNumber][i] = Integer.parseInt(st.nextToken());
                    i++;
                }
                if (i != size) {
                    errorCheck = false;
                    break;
                }
                lineNumber++;
            }
            if (lineNumber != size) {
                errorCheck = false;
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return errorCheck;
    }

    /**
     * Returns array read from file.
     * @return digits array
     */
    final int[][] getDigits() {
        return digits;
    }

    /**
     * Location of file to read.
     */
    private final String filename;
    /**
     * Array build from file.
     */
    private final int[][] digits;
    /**
     * Size of array to read.
     */
    private final int size;
}
