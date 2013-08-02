import static org.junit.Assert.*;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.ScoreCalculator;
import gradebook.model.Section;
import gradebook.model.StandardGradingScheme;
import gradebook.model.Student;
import gradebook.model.Class;
import gradebook.model.Course;

import org.junit.Test;


public class bigTest {

    @Test
    public void test() {
        GradebookCategory exams = new GradebookCategory("Exams", 0.5);
        GradebookItem examOne = new GradebookItem("Exam One", 100, exams);
        GradebookItem examOnez = new GradebookItem("Exam One", 0, exams);
        
        GradebookCategory homework = new GradebookCategory("homework", 0.2);
        GradebookItem homeworkOne = new GradebookItem("Homework One", 100.0, homework);
        GradebookItem homeworkOnez = new GradebookItem("Homework One", 0, homework);
        
        GradebookCategory quiz = new GradebookCategory("quiz", 0.3);
        GradebookItem quizOne = new GradebookItem("quiz One", 100.0, quiz);
        GradebookItem quizOnez = new GradebookItem("quiz One", 0, quiz);
        
        StandardGradingScheme defaultScheme = new StandardGradingScheme();
        ScoreCalculator normal = new ScoreCalculator();
        Student s100 = new Student("bob", defaultScheme, normal);
        Student s50 = new Student("bob", defaultScheme, normal);
        Student s0 = new Student("bob", defaultScheme, normal);
        
        s0.add(homeworkOnez);
        s0.add(quizOnez);
        s0.add(examOnez);
        
        s50.add(homeworkOnez);
        s50.add(quizOnez);
        s50.add(examOnez);
        s50.add(homeworkOne);
        s50.add(quizOne);
        s50.add(examOne);
        
        s100.add(homeworkOne);
        s100.add(quizOne);
        s100.add(examOne);
        
        Section sectionOne = new Section(defaultScheme);
        Section sectionTwo = new Section(defaultScheme);
        Section sectionThree = new Section(defaultScheme);
        
        sectionOne.add(s0);
        sectionOne.add(s0);
        sectionOne.add(s100);
        assertEquals(33.3333333, sectionOne.calculateGrade(), 0.001);
        
        sectionTwo.add(s0);
        sectionTwo.add(s100);
        sectionTwo.add(s100);
        assertEquals(66.666666, sectionTwo.calculateGrade(), 0.001);
        
        sectionThree.add(s50);
        assertEquals(50, sectionThree.calculateGrade(), 0.001);
        
        Class c1 = new Class(defaultScheme);
        Class c2 = new Class(defaultScheme);
        
        c1.add(sectionTwo);
        c1.add(sectionOne);
        
        assertEquals(50, c1.calculateGrade(), 0.001);
        
        c2.add(sectionOne);
        
        Course aCourse = new Course("CS", 1234, "Intro to Foos and Bars", null, defaultScheme);
        aCourse.add(c1);
        aCourse.add(c2);
        
        assertEquals(41.66666, aCourse.calculateGrade(), 0.001);
    }

}
