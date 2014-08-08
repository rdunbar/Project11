/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import main.java.project.e11.Project11;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robert
 */
public class Project11Test {
    
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    public Project11Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
    }

    /**
     * Test of main method, of class Project11.
     */
    @Test
    public void testMainWithNoArgs() {
        String[] args = {};
        Project11.main(args);
        assertTrue(out.toString().matches("Invalid number of arguments\n"));
    }
    
    @Test
    public void testCorrectOperation() {
        String[] args = {"src/test/resources/Input", "20"};
        Project11.main(args);
        assertEquals("70600674\n", out.toString());
    }
    
    @Test
    public void testArrayEntrySizeTooSmall() {
        String[] args = {"src/test/resources/Input", "19"};
        Project11.main(args);
        assertEquals("Error reading file\n", out.toString());
    }
    
    @Test
    public void testArrayEntrySizeTooBig() {
        String[] args = {"src/test/resources/Input", "21"};
        Project11.main(args);
        assertEquals("Error reading file\n", out.toString());
    }
}
