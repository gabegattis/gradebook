package gradebook.model;



/**
*  A single student
*/
public class Student {
    private String name;
    private GradingScheme gradingScheme;
    private GradebookDb gradeItems = new GradebookDb();
    private ScoreCalculator scoreCalculator;

    public Student(String studentName, GradingScheme studentScheme,
            ScoreCalculator studentScoreCalculator) {
        name = studentName;
        gradingScheme = studentScheme;
        scoreCalculator = studentScoreCalculator;
    }

    public String getName() {
        return name;
    }

    public double calculateGrade() {
        return scoreCalculator.calculateGrade(gradeItems);
    }

    public char calculateLetterGrade() {
        return gradingScheme.calculateLetterGrade(calculateGrade());
    }

    public void add(GradebookItem gradebookItem) {
        gradeItems.add(gradebookItem);
    }

    public void remove(GradebookItem gradebookItem) {
        gradeItems.remove(gradebookItem);
    }

    public GradebookItem getItem(int index) {
      return (GradebookItem) gradeItems.get(index);
    }

    public GradebookDb getGradeItems() {
        return gradeItems;
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public ScoreCalculator getScoreCalculator() {
        return scoreCalculator;
    }
}
