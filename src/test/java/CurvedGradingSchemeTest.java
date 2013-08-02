import static org.junit.Assert.*;
import gradebook.model.CurvedGradingScheme;
import gradebook.model.CustomGradingScheme;

import org.junit.Test;


public class CurvedGradingSchemeTest {

    @Test
    public void test() {
        CurvedGradingScheme normal = new CurvedGradingScheme();
        assertEquals('A', normal.calculateLetterGrade(95));
        assertEquals('B', normal.calculateLetterGrade(85));
        assertEquals('C', normal.calculateLetterGrade(70));
        assertEquals('D', normal.calculateLetterGrade(60));
        assertEquals('F', normal.calculateLetterGrade(45));
        assertEquals('A', normal.calculateLetterGrade(87.5));
        assertEquals('B', normal.calculateLetterGrade(75));
        assertEquals('C', normal.calculateLetterGrade(62.5));
        assertEquals('D', normal.calculateLetterGrade(50));
        assertEquals('F', normal.calculateLetterGrade(40));
    }

}
