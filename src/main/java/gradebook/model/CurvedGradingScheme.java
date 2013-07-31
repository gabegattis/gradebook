package gradebook.model;

/**
* An example of a more generous, curved grading scheme.
*/
public class CurvedGradingScheme implements GradingScheme {

    private final double a = 87.5;
    private final double b = 75.0;
    private final double c = 62.5;
    private final double d = 50.0;

    public CurvedGradingScheme() {

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
