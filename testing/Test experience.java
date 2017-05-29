
import org.junit.Test;
import static org.junit.Assert.*;

public class CVTest {
    
    @Test
    public void testGetWorkExperienceValueGeneral() {
        String job = "I am a manager";
        int experienceYears = 10;
        int expResult = 210;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result = CV.getWorkExperienceValue(job, experienceYears,path);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetWorkExperienceValueManagerProgrammer(){
        String job="I am a manager and a programmer";
        int experienceYears= 5;
        int expResult=340;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result=CV.getWorkExperienceValue(job,experienceYears,path);
        assertEquals(expResult,result,0.0);
    }
    
    @Test
    public void testGetWorkExperienceValueNoSpace(){
        String job="Iamamanagerandaprogrammer";
        int experienceYears= 5;
        int expResult=340;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result=CV.getWorkExperienceValue(job,experienceYears,path);
        assertEquals(expResult,result,0.0);
    }
    
    @Test
    public void testGetWorkExperienceValueRandomCases(){
        String job="I aM a maNaGer aNd A proGrAmMer";
        int experienceYears= 5;
        int expResult=340;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result=CV.getWorkExperienceValue(job,experienceYears,path);
        assertEquals(expResult,result,0.0);
    }
    
    @Test
    public void testGetWorkExperienceValueInvalidExperience(){
        String job="I am a painter";
        int experienceYears= 12;
        int expResult=12;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result=CV.getWorkExperienceValue(job,experienceYears,path);
        assertEquals(expResult,result,0.0);
    }
    
    @Test
    public void testGetWorkExperienceValueEmpty() {
        String job = "";
        int experienceYears = 0;
        int expResult = 0;
        String path="C:\\Users\\Dell\\Desktop\\top-jobs.txt";
        float result = CV.getWorkExperienceValue(job, experienceYears,path);
        assertEquals(expResult, result, 0.0);
    }
    
}
