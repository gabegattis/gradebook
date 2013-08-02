import static org.junit.Assert.*;
import gradebook.model.Class;
import gradebook.model.CurvedGradingScheme;
import gradebook.model.GradingScheme;
import gradebook.model.ScoreCalculator;
import gradebook.model.Section;
import gradebook.model.StandardGradingScheme;
import gradebook.model.Student;

import org.junit.Test;


public class SectionTest {

    GradingScheme defaultScheme, curvedScheme;
    Student sOne, sTwo, sThree;
    Section sectionOne;
    
    @Test
    public void classSetup() {
        defaultScheme = new StandardGradingScheme();
        sectionOne = new Section(defaultScheme);
        
        
        
        assertEquals(defaultScheme, sectionOne.getGradingScheme());        
    }
    
    @Test
    public void addRemoveSection() {
        ScoreCalculator normal = new ScoreCalculator();
        sThree = new Student("bob", defaultScheme, normal);
        sOne = new Student("bob", defaultScheme, normal);
        sTwo = new Student("bob", defaultScheme, normal);
        
        sectionOne = new Section(defaultScheme);
        sectionOne.add(sOne);
        sectionOne.add(sTwo);
        sectionOne.add(sThree);
        
        assertEquals(3, sectionOne.getSize());
        assertEquals(sOne, sectionOne.getStudent(0));
        sectionOne.remove(sOne);
        assertEquals(sTwo, sectionOne.getStudent(0));
        
    }

}
