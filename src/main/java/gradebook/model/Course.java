package gradebook.model;

import java.util.ArrayList;


/**
* Specifies a university course.
*/
public class Course {

    private GradebookDb classes = new GradebookDb();
    private String subject;
    private int number;
    private String name;
    private ArrayList<Course> prerequisites;
    private GradingScheme gradingScheme;

    public Course(String aSubject, int courseNumber, String courseName,
            ArrayList<Course> coursePrerequisites,
            GradingScheme courseGradingScheme) {
        subject = aSubject;
        number = courseNumber;
        name = courseName;
        prerequisites = coursePrerequisites;
        gradingScheme = courseGradingScheme;
    }

    public void add(Class newClass) {
        classes.add(newClass);
    }

    public void remove(Class aClass) {
        classes.remove(aClass);
    }

    public Class getClass(int index) {
        return (Class) classes.get(index);
    }

    public String getSubject() {
        return subject;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Course getPrerequisites(int index) {
        return prerequisites.get(index);
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public double calculateGrade() {
        double overallGrade = 0.0;
        for (int i = 0; i < classes.size(); i++) {
            overallGrade = overallGrade
                    + ((Class) classes.get(i)).calculateGrade();
        }
        double courseAverage = overallGrade / classes.size();
        return courseAverage;
    }

    public char getLetterGrade() {
        return gradingScheme.calculateLetterGrade(calculateGrade());
    }

}
