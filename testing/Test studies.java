/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ionut
 */
public class MainTest {
    private Object doc;
    private Object dBuilder;
    
    
    int generate(String path){
        int[] Studies = new int[2];
        Studies = CV.getStudiesExperience(path);
        return Studies[0]*100+Studies[1]; 
    }
    
    @Test
    public void testGenerate() throws Exception {
        System.out.println("generate");
        String path = "C:\\Users\\gaby_\\Desktop\\F2\\Main\\Aaron-Metcalfe.xml";
        String[] args = null;
        int[] Studies = new int[2];
        Studies = CV.getStudiesExperience(path);
        int result = generate(path);
        assertEquals(Studies[0]*100+Studies[1],result);
    };
    
    @Test   
    public void getStudiesExperience () throws SAXException, IOException {         
        int degree=0;
        int studiesYears=0;
        int[]studies=new int[2];
        String path="C:\\Users\\gaby_\\Desktop\\F2\\Main\\Aaron-Metcalfe.xml";
        File fXmlFile= new File(path);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document doc = dBuilder.parse(path);
        NodeList nList = doc.getElementsByTagName("SchoolOrInstitution");
        nodeParser(nList);
        
        
    };
    public static void nodeParser(NodeList nList){
         for (int i = 0; i < nList.getLength(); i++) {
            String degreeName;
            String startDate = "";
            String endDate = "";
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 degreeName = eElement.getElementsByTagName("DegreeName").item(0).getTextContent();
                int degree = 0;
                 if (degreeName.equals("MS") | degreeName.equals("masters") | degreeName.equals("Masters") | degreeName.equals("ms")) {
                      if (degree < 4) {
                           degree = 4;
}
}
                if (degreeName.equals("BCs") | degreeName.equals("BCS") | degreeName.equals("BC") | degreeName.equals("bc") | degreeName.equals("Bachelors") | degreeName.equals("bachelors")) {
                     if (degree < 2) {
                         degree = 2;
                        }
                    }
                if (degreeName.equals("Doctorate") | degreeName.equals("PHD") | degreeName.equals("PhD") | degreeName.equals("doctorate")) {
                        if (degree < 6) {
                          degree = 6;
                      }
                    }
                NodeList startList = eElement.getElementsByTagName("StartDate");
                if (startList.getLength() != 0) {
                       startDate = eElement.getElementsByTagName("StartDate").item(0).getTextContent();
                    }
                NodeList endList = eElement.getElementsByTagName("EndDate");
                if (endList.getLength() != 0) {
                       endDate = eElement.getElementsByTagName("EndDate").item(0).getTextContent();
                   }
            }
        }
    }
}
               


    

