import static org.junit.Assert.*;
import gradebook.model.Class;
import gradebook.model.Course;
import gradebook.model.CurvedGradingScheme;
import gradebook.model.GradingScheme;
import gradebook.model.StandardGradingScheme;

import java.util.ArrayList;

import org.junit.Test;


public class CourseTest {

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
        assertEquals(prereq.get(0), myCourse.getPrerequisites(0));
    }
    
    @Test
    public void addRemoveClass() {
        ArrayList<Course> prereq = new ArrayList<Course>();
        prereq.add(preCourse);
        myCourse = new Course("CS", 2340, "Objects and Design", prereq, defaultScheme);
        classOne = new Class(defaultScheme);
        classTwo = new Class(curvedScheme);
        myCourse.add(classOne);
        myCourse.add(classTwo);
        assertEquals(classOne, myCourse.getClass(0));
        myCourse.remove(classOne);
        assertEquals(classTwo ,myCourse.getClass(0));
    }

}
