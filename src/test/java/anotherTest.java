import java.util.ArrayList;

import gradebook.model.*;
import gradebook.model.Class;
import static org.junit.Assert.*;

import org.junit.Test;


public class anotherTest {

    Course myCourse;
    Course preCourse;
    GradingScheme defaultScheme, curvedScheme;
    Class classOne, classTwo;
    
    @Test
    public void courseSetup() {
        defaultScheme = new StandardGradingScheme();
        curvedScheme = new CurvedGradingScheme();
        preCourse = new Course("CS", 1301, "Intro to Programming", null, defaultScheme);
        ArrayList<Course> prereq = new ArrayList<Course>();
        prereq.add(preCourse);
        
        myCourse = new Course("CS", 2340, "Objects and Design",prereq, defaultScheme);
        
        assertEquals("Objects and Design", myCourse.getName());
        assertEquals("CS", myCourse.getSubject());
        assertEquals(2340, myCourse.getNumber());
        assertEquals(defaultScheme, myCourse.getGradingScheme());
        assertEquals(prereq, myCourse.getPrerequisites(0));
    }
    
    @Test
    public void addRemoveClass() {
        classOne = new Class(defaultScheme);
        classOne = new Class(curvedScheme);
        myCourse.add(classOne);
        myCourse.add(classTwo);
        assertEquals(classOne, myCourse.getClass(0));
        myCourse.remove(classOne);
        assertEquals(null ,myCourse.getClass(0));
    }

}
