import static org.junit.Assert.*;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.StandardGradingScheme;

import org.junit.Test;


public class GradebookItemTest {

    @Test
    public void test() {
        GradebookCategory exams = new GradebookCategory("Exams", 0.4);
        GradebookItem examOne = new GradebookItem("Exam One", 90.0, exams);
        
        assertEquals("Exam One", examOne.getName());
        assertEquals(90.0, examOne.getGrade(), 0.00001);
        assertEquals(exams, examOne.getGradebookCategory());
    }

}
