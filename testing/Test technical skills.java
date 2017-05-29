/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Relu
 */
public class MainTest {

    @Test
    public void testValueTechnicalSkillGeneral() throws Exception {
        String skill = "I am a Java and C# developer";
        String cautare = "general";
        int expResult = 37;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueTechnicalSkillWeb() throws Exception {
        String skill = "I am a Java and C# developer";
        String cautare = "web";
        int expResult = 10;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueTechnicalSkillOop() throws Exception {
        String skill = "I am a Java and C# developer";
        String cautare = "oop";
        int expResult = 36;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);

        result = Main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueTechnicalSkillEmpty() throws Exception {
        String skill = "";
        String cautare = "general";
        int expResult = 0;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);

        result = Main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }

    public void testValueTechnicalSkillCamelCase() throws Exception {
        String skill = "I aM a JaVa aNd C# dEvElOpEr!";
        String cautare = "general";
        int expResult = 37;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);

        result = Main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }
    
    public void testValueTechnicalSkillComa() throws Exception {
        String skill = "I am a Java, C# developer!";
        String cautare = "general";
        int expResult = 37;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);

        result = Main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }
    
    public void testValueTechnicalSkillNoSpace() throws Exception {
        String skill = "I am a JavaC# developer!";
        String cautare = "general";
        int expResult = 37;
        Main main = new Main();
        int result = main.technicalSkillsVallue(skill, cautare);

        result = Main.technicalSkillsVallue(skill, cautare);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain() throws Exception {
        Main.main(null);
        assertEquals(0, 0);
    }
}
