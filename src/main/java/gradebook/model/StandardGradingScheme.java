package gradebook.model;


/**
* An example of the most common grading scheme.
*/
public class StandardGradingScheme implements GradingScheme {

    private final double a = 90.0;
    private final double b = 80.0;
    private final double c = 70.0;
    private final double d = 60.0;

    public StandardGradingScheme() {

    }

    public char calculateLetterGrade(double grade) {
        char letterGrade;

        if (grade >= a) {
            letterGrade = 'A';
        } else if (grade >= b) {
            letterGrade = 'B';
        } else if (grade >= c) {
            letterGrade = 'C';
        } else if (grade >= d) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
    }

}
