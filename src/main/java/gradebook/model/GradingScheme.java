package gradebook.model;

/**
 *  An interface for implementing various schemes for
 *  assigning letter grades based on a numerical grade
 *
 *  This feature allows for schemes such as grade curving
 *   and extra credit.
 */
public interface GradingScheme {

    char calculateLetterGrade(double grade);

}

