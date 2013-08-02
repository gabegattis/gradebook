import static org.junit.Assert.*;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookDb;
import gradebook.model.GradebookItem;
import gradebook.model.ScoreCalculator;

import org.junit.Test;


public class ScoreCalculatorTest {

    @Test
    public void test() {
        GradebookCategory exams = new GradebookCategory("Exams", 0.5);
        GradebookItem examOne = new GradebookItem("Exam One", 90.0, exams);
        GradebookItem examTwo = new GradebookItem("Exam Two", 95.0, exams);
        GradebookItem examThree = new GradebookItem("Exam Three", 80.0, exams);
        
        GradebookCategory homework = new GradebookCategory("homework", 0.2);
        GradebookItem homeworkOne = new GradebookItem("Homework One", 100.0, homework);
        GradebookItem homeworkTwo = new GradebookItem("Homework Two", 90.0, homework);
        GradebookItem homeworkThree = new GradebookItem("Homework Three", 92.0, homework);
        
        GradebookCategory quiz = new GradebookCategory("quiz", 0.3);
        GradebookItem quizOne = new GradebookItem("quiz One", 100.0, quiz);
        GradebookItem quizTwo = new GradebookItem("quiz One", 80.0, quiz);
        GradebookItem quizThree = new GradebookItem("quiz One", 95.0, quiz);
        
        GradebookDb myGradebook = new GradebookDb();
        myGradebook.add(examOne);
        myGradebook.add(examTwo);
        myGradebook.add(examThree);

        myGradebook.add(homeworkOne);
        myGradebook.add(homeworkTwo);
        myGradebook.add(homeworkThree);

        myGradebook.add(quizOne);
        myGradebook.add(quizTwo);
        myGradebook.add(quizThree);
        
        ScoreCalculator normal = new ScoreCalculator();
        ScoreCalculator drop = new ScoreCalculator(exams, null, null);
        ScoreCalculator replace = new ScoreCalculator(null, exams, null);
        ScoreCalculator add = new ScoreCalculator(null, null, exams);
        
        double score = normal.calculateGrade(myGradebook);
        double scoreDrop = drop.calculateGrade(myGradebook);
        double scoreReplace = replace.calculateGrade(myGradebook);
        double scoreAdd = add.calculateGrade(myGradebook);
        
        assertEquals(90.4666666666, score, 0.001);
        assertEquals(92.5499999999, scoreDrop, 0.001);
        assertEquals(91.8555555555, scoreReplace, 0.001);
        assertEquals(91.925, scoreAdd, 0.001);
    }

}
