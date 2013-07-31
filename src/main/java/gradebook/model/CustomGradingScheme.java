package gradebook.model;

/**
* A customizable scheme for assigning letter grades.
*/
public class CustomGradingScheme implements GradingScheme {

    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public CustomGradingScheme(double aCutoff, double bCutoff,
            double cCutoff, double dCutoff) {
        a = aCutoff;
        b = bCutoff;
        c = cCutoff;
        d = dCutoff;
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
