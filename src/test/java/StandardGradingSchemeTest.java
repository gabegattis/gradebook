import static org.junit.Assert.*;
import gradebook.model.CustomGradingScheme;
import gradebook.model.StandardGradingScheme;

import org.junit.Test;


public class StandardGradingSchemeTest {

    @Test
    public void test() {
        StandardGradingScheme normal = new StandardGradingScheme();
        assertEquals('A', normal.calculateLetterGrade(95));
        assertEquals('B', normal.calculateLetterGrade(85));
        assertEquals('C', normal.calculateLetterGrade(75));
        assertEquals('D', normal.calculateLetterGrade(65));
        assertEquals('F', normal.calculateLetterGrade(55));
        assertEquals('A', normal.calculateLetterGrade(90));
        assertEquals('B', normal.calculateLetterGrade(80));
        assertEquals('C', normal.calculateLetterGrade(70));
        assertEquals('D', normal.calculateLetterGrade(60));
        assertEquals('F', normal.calculateLetterGrade(50));
    }

}
