import static org.junit.Assert.*;
import gradebook.model.GradebookCategory;

import org.junit.Test;


public class GradebookCategoryTest {

    @Test
    public void test() {
        double testWeight = 0.4;
        GradebookCategory tests = new GradebookCategory("tests", testWeight);
        
        assertEquals("tests", tests.getName());
        assertEquals(testWeight, tests.getWeight(), 0.00001);
    }

}
