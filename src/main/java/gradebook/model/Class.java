package gradebook.model;


/**
* Specifies a class of a course
*/

public class Class {

    private GradebookDb sections = new GradebookDb();
    private GradingScheme gradingScheme;

    public Class(GradingScheme classScheme) {
        gradingScheme = classScheme;
    }

    public double calculateGrade() {
        double overallGrade = 0.0;
        int students = 0;
        for (int i = 0; i < sections.size(); i++) {
            Section currentSection = (Section) sections.get(i);
            overallGrade = overallGrade + currentSection.calculateGrade()
                    * currentSection.getSize();
            students = students + currentSection.getSize();
        }
        double sectionAverage = overallGrade / students;
        return sectionAverage;
   }

    public void add(Section section) {
        sections.add(section);
    }

    public void remove(Section section) {
        sections.remove(section);
    }

    public Section getSection(int index) {
        return (Section) sections.get(index);
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }
    public char getLetterGrade() {
        return gradingScheme.calculateLetterGrade(calculateGrade());
    }

}
