/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.project.e11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author robert
 */
public class Project11FileReader {

    /**
     * Constructor.
     * @param fname_ file address
     * @param sze_ _size of array to be processed
     */
    public Project11FileReader(final String fname_, final int sze_) {
        this._filename = fname_;
        this._size = sze_;
        this._digits = new int[_size][_size];
    }

    /**
     * Reads in file data.
     * @return correct operation
     */
    final boolean readFile() {

        BufferedReader input;
        boolean errorCheck = true;

        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(_filename), "US-ASCII"));

            String line;
            int lineNumber = 0;
            StringTokenizer st;
            String token;
            while ((line = input.readLine()) != null) {
                if (lineNumber == _size) {
                    errorCheck = false;
                    break;
                }
                st = new StringTokenizer(line);
                int i = 0;
                while (st.hasMoreElements()) {
                    if (i == _size) {
                        errorCheck = false;
                        break;
                    }
                    _digits[lineNumber][i] = Integer.parseInt(st.nextToken());
                    i++;
                }
                if (i != _size) {
                    errorCheck = false;
                    break;
                }
                lineNumber++;
            }
            if (lineNumber != _size) {
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
     * @return _digits array
     */
    final int[][] getDigits() {
        return _digits;
    }

    /**
     * Location of file to read.
     */
    private final String _filename;
    /**
     * Array build from file.
     */
    private final int[][] _digits;
    /**
     * Size of array to read.
     */
    private final int _size;
}
