package gradebook.model;

/**
*  A object for grouping students into sections.
*/
public class Section {

    private GradebookDb students = new GradebookDb();
    private GradingScheme gradingScheme;

    public Section(GradingScheme sectionScheme) {
        gradingScheme = sectionScheme;
    }

    public double calculateGrade() {
        double overallGrade = 0.0;
        for (int i = 0; i < students.size(); i++) {
            overallGrade = overallGrade
                    + ((Student) students.get(i)).calculateGrade();
        }
        double sectionAverage = overallGrade / students.size();
        return sectionAverage;
    }

    public char getLetterGrade() {
        return gradingScheme.calculateLetterGrade(calculateGrade());
    }

    public void add(Student student) {
        students.add(student);
    }

    public void remove(Student student) {
        students.remove(student);
    }

    public Student getStudent(int index) {
        return (Student) students.get(index);
    }

    public int getSize() {
        return students.size();
    }

}
