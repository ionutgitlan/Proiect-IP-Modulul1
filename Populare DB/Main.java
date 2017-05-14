/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {

    public static void insertData(String path, int cvID) throws SQLException, SAXException, ParserConfigurationException {
        String name = CV.getName(path);
        String email = CV.getEmail(path);
        List<WorkExperience> workExperience = CV.getWorkExperience(path);

        CV.getStudiesExperience(path);
        List<String> skills = CV.getSkills(path);
        Connection con = DB.GetConn();
        int var = 0;
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("insert into curriculumvitae (id,name,email) values (?,?,?)");

        pstmt.setInt(1, cvID);
        pstmt.setString(2, name);
        pstmt.setString(3, email);
        pstmt.executeUpdate();
        for (int i = 0; i < workExperience.size(); i++) {
            pstmt = con.prepareStatement("insert into experience (cv_id,job_title,experience_years) values (?,?,?)");
            pstmt.setInt(1, cvID);
            pstmt.setString(2, workExperience.get(i).jobTitle);
            pstmt.setInt(3, workExperience.get(i).experienceYears);
            pstmt.executeUpdate();
            var += workExperience.get(i).experienceYears;
        }
        pstmt = con.prepareStatement("update curriculumvitae set experience_years = (?) where id = (?)");

        pstmt.setInt(1, var);
        pstmt.setInt(2, cvID);
        pstmt.executeUpdate();
        for (int i = 0; i < skills.size(); i++) {
            pstmt = con.prepareStatement("insert into softskills (cv_id,skill) values (?,?)");
            pstmt.setInt(1, cvID);
            pstmt.setString(2, skills.get(i));
            pstmt.executeUpdate();
        }
        pstmt.close();
    }

    private static void getFiles(final File folder) throws IOException, SAXException, ParserConfigurationException, SQLException {
        int cvID = 10;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getFiles(fileEntry);
            } else {
                String path = folder.toString();
                path += "\\" + fileEntry.getName();
                System.out.println(path);
                insertData(path, cvID);
                cvID++;
            }
        }
    }

    public static void main(final String[] args) throws IOException, SAXException, ParserConfigurationException, SQLException {
        final File folder = new File("E:\\Downloads\\IP\\");
        getFiles(folder);
        DB.closeConnection();
    }

}
