/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.java;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.java.project.e11.Project11;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author robert
 */
public class Project11Test {

    /**
     * Read from command line.
     */
    private final ByteArrayOutputStream out;

    /**
     * Constructor.
     */
    public Project11Test() {
        out = new ByteArrayOutputStream();
    }

    /**
     * Set up system output.
     */
    @Before
    public final void setUp() {
        System.setOut(new PrintStream(out));
    }

    /**
     * Pull down system output.
     */
    @After
    public final void tearDown() {
        System.setOut(null);
    }

    /**
     * Test of main method, of class Project11.
     */
    @Test
    public final void testMainWithNoArgs() {
        String[] args = {};
        Project11.main(args);
        Assert.assertTrue(
                out.toString().matches("Invalid number of arguments\n"));
    }

    /**
     * Test normal operation.
     */
    @Test
    public final void testCorrectOperation() {
        String[] args = {"src/test/resources/Input", "20"};
        Project11.main(args);
        Assert.assertEquals("70600674\n", out.toString());
    }

    /**
     * Input number doesn't match file.
     */
    @Test
    public final void testArrayEntrySizeTooSmall() {
        String[] args = {"src/test/resources/Input", "19"};
        Project11.main(args);
        Assert.assertEquals("Error reading file\n", out.toString());
    }

    /**
     * Input number doesn't match file.
     */
    @Test
    public final void testArrayEntrySizeTooBig() {
        String[] args = {"src/test/resources/Input", "21"};
        Project11.main(args);
        Assert.assertEquals("Error reading file\n", out.toString());
    }
}
