import static org.junit.Assert.*;
import gradebook.model.Class;
import gradebook.model.GradebookDb;
import gradebook.model.StandardGradingScheme;

import org.junit.Test;


public class GradebookDbTest {

    @Test
    public void test() {
        GradebookDb myGradebook = new GradebookDb();
        StandardGradingScheme defaultScheme = new StandardGradingScheme();
        Class classOne = new Class(defaultScheme);
        myGradebook.add(classOne);
        assertEquals(classOne, myGradebook.get(0));
    }

}
