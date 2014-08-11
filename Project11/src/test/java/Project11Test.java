/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.java;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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
    private final ByteArrayOutputStream _out;

    /**
     * Constructor.
     */
    public Project11Test() {
        _out = new ByteArrayOutputStream();
    }

    /**
     * Set up system _output.
     * @throws UnsupportedEncodingException ex
     */
    @Before
    public final void setUp() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(_out, false, "US-ASCII"));
    }

    /**
     * Pull down system _output.
     */
    @After
    public final void tearDown() {
        System.setOut(null);
    }

    /**
     * Test of main method, of class Project11.
     * @throws UnsupportedEncodingException ex
     */
    @Test
    public final void testMainWithNoArgs() throws UnsupportedEncodingException {
        String[] args = {};
        Project11.main(args);
        Assert.assertTrue(
                _out.toString("US-ASCII").matches("Invalid number of arguments\n"));
    }

    /**
     * Test normal operation.
     * @throws UnsupportedEncodingException ex
     */
    @Test
    public final void testCorrectOperation() throws UnsupportedEncodingException {
        String[] args = {"src/test/resources/Input", "20"};
        Project11.main(args);
        Assert.assertEquals("70600674\n", _out.toString("US-ASCII"));
    }

    /**
     * Input number doesn't match file.
     * @throws UnsupportedEncodingException ex
     */
    @Test
    public final void testArrayEntrySizeTooSmall() throws UnsupportedEncodingException {
        String[] args = {"src/test/resources/Input", "19"};
        Project11.main(args);
        Assert.assertEquals("Error reading file\n", _out.toString("US-ASCII"));
    }

    /**
     * Input number doesn't match file.
     * @throws UnsupportedEncodingException ex
     */
    @Test
    public final void testArrayEntrySizeTooBig() throws UnsupportedEncodingException {
        String[] args = {"src/test/resources/Input", "21"};
        Project11.main(args);
        Assert.assertEquals("Error reading file\n", _out.toString("US-ASCII"));
    }
}
