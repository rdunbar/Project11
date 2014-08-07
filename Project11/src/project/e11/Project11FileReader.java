/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.e11;

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

    public Project11FileReader(final String filename, int size) {
        this.filename = filename;
        this.digits = new int[size][size];
        this.size = size;
    }

    void readFile() {

        BufferedReader input;

        try {
            input = new BufferedReader(new FileReader(filename));

            String line;
            int lineNumber = 0;
            StringTokenizer st;
            while (lineNumber < size) {
                line = input.readLine();
                st = new StringTokenizer(line);
                for (int i = 0; i < size; i++) {
                    digits[lineNumber][i] = Integer.parseInt(st.nextToken());
                }
                lineNumber++;
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    int[][] getDigits() {
        return digits;
    }

    private final String filename;
    private final int[][] digits;
    private final int size;
}
