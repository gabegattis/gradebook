package gradebook.model;

import java.util.ArrayList;

/**
* A set of algorithms for computing a student's numerical grade
* in various ways.
*
*/
public class ScoreCalculator {
    private GradebookCategory dropLowestGradeInCategory;
    private GradebookCategory replaceLowestGradeWithAverageInCategory;
    private GradebookCategory add100ToCategory;
    private final double perfectScore = 100;
    private double lowest;
    private final double lowestDefault = 1000;


    public ScoreCalculator(GradebookCategory dropLowestGradeInThisCategory,
            GradebookCategory replaceLowestGradeWithAverageInThisCategory,
            GradebookCategory add100ToThisCategory) {
        dropLowestGradeInCategory = dropLowestGradeInThisCategory;
        replaceLowestGradeWithAverageInCategory =
                replaceLowestGradeWithAverageInThisCategory;
        add100ToCategory = add100ToThisCategory;
        lowest = lowestDefault;
    }

    public double calculateGrade(GradebookDb gradeItems) {
        GradebookDb studentGradeItems = gradeItems;
        if (add100ToCategory != null) {
            GradebookItem extraCredit =
                    new GradebookItem("Extra Credit", perfectScore,
                            add100ToCategory);
            studentGradeItems.add(extraCredit);
        }
        if (dropLowestGradeInCategory != null) {
            studentGradeItems = dropLowest(studentGradeItems);
        }
        if (replaceLowestGradeWithAverageInCategory != null) {
            studentGradeItems = replaceLowest(studentGradeItems);
        }
        return calculate(studentGradeItems);
    }

    private GradebookDb dropLowest(GradebookDb gradeItems) {
        lowest = lowestDefault;
        int lowestGradeIndex = 0;
        for (int i = 0; i < gradeItems.size(); i++) {
            GradebookCategory currentCategory =
                    ((GradebookItem) gradeItems.get(i)).getGradebookCategory();
            if (currentCategory == dropLowestGradeInCategory) {
                if (((GradebookItem) gradeItems.get(i)).getGrade() < lowest) {
                    lowest = ((GradebookItem) gradeItems.get(i)).getGrade();
                    lowestGradeIndex = i;
                }
            }
        }
        gradeItems.remove(lowestGradeIndex);
        return gradeItems;
    }

    private GradebookDb replaceLowest(GradebookDb gradeItems) {
        lowest = lowestDefault;
        int lowestGradeIndex = 0;
        int itemsInCategory = 0;
        double categoryOverallGrade = 0.0;
        for (int i = 0; i < gradeItems.size(); i++) {
            GradebookCategory currentCategory =
                    ((GradebookItem) gradeItems.get(i)).getGradebookCategory();
            if (currentCategory == dropLowestGradeInCategory) {
                itemsInCategory++;
                categoryOverallGrade = categoryOverallGrade
                        + ((GradebookItem) gradeItems.get(i)).getGrade();
                if (((GradebookItem) gradeItems.get(i)).getGrade() < lowest) {
                    lowest = ((GradebookItem) gradeItems.get(i)).getGrade();
                    lowestGradeIndex = i;
                }
            }
        }
        categoryOverallGrade = categoryOverallGrade
                - ((GradebookItem) gradeItems.get(lowestGradeIndex)).getGrade();
        double average = categoryOverallGrade / (itemsInCategory - 1);
        GradebookItem copy = new GradebookItem("replace", average,
                replaceLowestGradeWithAverageInCategory);
        gradeItems.remove(lowestGradeIndex);
        gradeItems.add(copy);

        return gradeItems;
    }

    private double calculate(GradebookDb gradeItems) {
        double overallGrade = 0.0;
        ArrayList<GradebookCategory> categories =
                new ArrayList<GradebookCategory>();

        for (int i = 0; i < gradeItems.size(); i++) {
            GradebookCategory currentCategory
                    = ((GradebookItem)
                            gradeItems.get(i)).getGradebookCategory();
            if (!(categories.contains(currentCategory))) {
                categories.add(currentCategory);
            }
        }

        for (int i = 0; i < categories.size();  i++) {
            double categoryGrade = 0.0;
            double categoryWeight = 0.0;
            for (int j = 0; j < gradeItems.size(); j++) {
                if (((GradebookItem) gradeItems.get(i)).getGradebookCategory()
                        == categories.get(i)) {
                    categoryGrade = categoryGrade
                            + ((GradebookItem) gradeItems.get(i)).getGrade();
                }
            }
            double categoryAverage = categoryGrade / gradeItems.size();
            overallGrade = overallGrade  +  categoryAverage * categoryWeight;
        }
        return overallGrade;
    }
}
