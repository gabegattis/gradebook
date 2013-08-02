import static org.junit.Assert.*;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.ScoreCalculator;
import gradebook.model.StandardGradingScheme;
import gradebook.model.Student;

import org.junit.Test;


public class StudentTest {

    @Test
    public void test() {
        StandardGradingScheme defaultScheme = new StandardGradingScheme();
        ScoreCalculator normal = new ScoreCalculator();
        Student sOne = new Student("bob", defaultScheme, normal);
        
        assertEquals("bob", sOne.getName());
        assertEquals(defaultScheme, sOne.getGradingScheme());
        assertEquals(normal, sOne.getScoreCalculator());
        
        GradebookCategory exams = new GradebookCategory("Exams", 0.5);
        GradebookItem examOne = new GradebookItem("Exam One", 90.0, exams);
        GradebookItem examTwo = new GradebookItem("Exam Two", 90.0, exams);
        
        sOne.add(examOne);
        sOne.add(examTwo);
        assertEquals(examOne, sOne.getItem(0));
        sOne.remove(examOne);
        assertEquals(examTwo, sOne.getItem(0));
        
        
    }

}
