import static org.junit.Assert.*;
import gradebook.model.Class;
import gradebook.model.Course;
import gradebook.model.CurvedGradingScheme;
import gradebook.model.GradingScheme;
import gradebook.model.Section;
import gradebook.model.StandardGradingScheme;

import java.util.ArrayList;

import org.junit.Test;


public class ClassTest {

    
    GradingScheme defaultScheme, curvedScheme;
    Class classOne, classTwo, classThree;
    Section sectionOne, sectionTwo;
    
    @Test
    public void classSetup() {
        defaultScheme = new StandardGradingScheme();
        curvedScheme = new CurvedGradingScheme();
        classOne = new Class(defaultScheme);
        classTwo = new Class(curvedScheme);
        
        
        
        assertEquals(defaultScheme, classOne.getGradingScheme());        
    }
    
    @Test
    public void addRemoveSection() {
        classThree = new Class(defaultScheme);
        sectionOne = new Section(defaultScheme);
        sectionTwo = new Section(defaultScheme);
        classThree.add(sectionOne);
        classThree.add(sectionTwo);
        assertEquals(sectionOne, classThree.getSection(0));
        classThree.remove(sectionOne);
        assertEquals(sectionTwo , classThree.getSection(0));
    }

}
