/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ip.IP;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Chirila Loredana, Juravle Oana
 */
public class IPtest {

    protected String skill1, skill2, skill3, skill4;
    protected String path = "E:\\FCS\\Y2\\S2\\IP\\PIP\\Dictionar.txt";

    @Before
    public void setUp() {
        skill1 = "hr agile";
        skill2 = "administrative assistant";
        skill3 = "admin";
        skill4 = "3";
    }
    @Test
    public void testClassExists() {
            try {
                Class.forName("ip.IP");
            } catch(ClassNotFoundException e) {
                Assert.fail("Should create a class called 'IP'.");
            }
     }

    @Test
    public void testSumForTwoKeys() throws IOException {
        IP ip = new IP();
        int result1 = ip.softskillsValoare(skill1, path);
        assertTrue(result1 == 14);
    }

    @Test
    public void testSumForOneKey() throws IOException {
        IP ip = new IP();
        int result2 = ip.softskillsValoare(skill2, path);
        assertTrue(result2 == 4);
    }

    @Test
    public void testSumShortcutKey() throws IOException {
        IP ip = new IP();
        int result3 = ip.softskillsValoare(skill3, path);
        assertFalse(result3 == 4);
    }

    @Test
    public void testSumInexistentKey() throws IOException {
        IP ip = new IP();
        int result4 = ip.softskillsValoare(skill4, path);
        assertTrue(result4 == 0);
    }
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
