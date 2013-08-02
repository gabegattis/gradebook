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
        Class classTwo = new Class(defaultScheme);
        Class classThree = new Class(defaultScheme);
        Class classFour = new Class(defaultScheme);
        Class classFive = new Class(defaultScheme);
        
        myGradebook.add(classOne);
        myGradebook.add(classTwo);
        myGradebook.add(classThree);
        myGradebook.add(classFour);
        myGradebook.add(classFive);
        
        assertEquals(5, myGradebook.size());
        
        assertEquals(classOne, myGradebook.get(0));
        
        myGradebook.remove(0);
        assertEquals(classTwo, myGradebook.get(0));
        
        myGradebook.remove(classTwo);
        assertEquals(classThree, myGradebook.get(0));
        
        myGradebook.clear();
        assertEquals(0, myGradebook.size());
        
        
    }

}
