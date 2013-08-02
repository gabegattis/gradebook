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
    Section sectionOne, sectionTwo;
    
    @Test
    public void classSetup() {
        defaultScheme = new StandardGradingScheme();
        curvedScheme = new CurvedGradingScheme();
        sectionOne = new Section(defaultScheme);
        sectionTwo = new Section(curvedScheme);
        
        
        
        //assertEquals(defaultScheme, classOne.getGradingScheme());        
    }
    
    @Test
    public void addRemoveSection() {
        ScoreCalculator normal = new ScoreCalculator();
        sThree = new Student("bob", defaultScheme, normal);
        sOne = new Student("bob", defaultScheme, normal);
        sTwo = new Student("bob", defaultScheme, normal);
        sectionOne = new Section(defaultScheme);
        sectionTwo = new Section(defaultScheme);
        sectionOne.add(sThree);
       // sThree.add(sectionTwo);
       // assertEquals(sectionOne, classThree.getSection(0));
       // sThree.remove(sectionOne);
       // assertEquals(sectionTwo , classThree.getSection(0));
    }

}
