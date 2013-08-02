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


    public ScoreCalculator() {

    }

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
        GradebookDb studentGradeItems = new GradebookDb();
        for (int i = 0; i < gradeItems.size(); i++) {
            studentGradeItems.add(gradeItems.get(i));
        }
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
        GradebookDb studentGradeItems = gradeItems;
        lowest = lowestDefault;
        int lowestGradeIndex = 0;
        for (int i = 0; i < studentGradeItems.size(); i++) {
            GradebookCategory currentCategory =
             ((GradebookItem) studentGradeItems.get(i)).getGradebookCategory();
            if (currentCategory == dropLowestGradeInCategory) {
                if (((GradebookItem) studentGradeItems.get(i)).getGrade()
                        < lowest) {
                    lowest
                    = ((GradebookItem) studentGradeItems.get(i)).getGrade();
                    lowestGradeIndex = i;
                }
            }
        }
        studentGradeItems.remove(lowestGradeIndex);
        return studentGradeItems;
    }

    private GradebookDb replaceLowest(GradebookDb gradeItems) {
        GradebookDb studentGradeItems = gradeItems;
        lowest = lowestDefault;
        int lowestGradeIndex = 0;
        int itemsInCategory = 0;
        double categoryOverallGrade = 0.0;
        for (int i = 0; i < studentGradeItems.size(); i++) {
            GradebookCategory currentCategory =
             ((GradebookItem) studentGradeItems.get(i)).getGradebookCategory();
            if (currentCategory == replaceLowestGradeWithAverageInCategory) {
                itemsInCategory++;
                categoryOverallGrade = categoryOverallGrade
                       + ((GradebookItem) studentGradeItems.get(i)).getGrade();
                if (((GradebookItem) studentGradeItems.get(i)).getGrade()
                        < lowest) {
                    lowest
                    = ((GradebookItem) studentGradeItems.get(i)).getGrade();
                    lowestGradeIndex = i;
                }
            }
        }

        double average = categoryOverallGrade / (itemsInCategory);
        GradebookItem copy = new GradebookItem("replace", average,
                replaceLowestGradeWithAverageInCategory);
        studentGradeItems.remove(lowestGradeIndex);
        studentGradeItems.add(copy);

        return studentGradeItems;
    }

    private double calculate(GradebookDb gradeItems) {
        GradebookDb studentGradeItems = gradeItems;
        double overallGrade = 0.0;
        ArrayList<GradebookCategory> categories =
                new ArrayList<GradebookCategory>();

        for (int i = 0; i < studentGradeItems.size(); i++) {
            GradebookCategory currentCategory
                    = ((GradebookItem)
                            studentGradeItems.get(i)).getGradebookCategory();
            if (!(categories.contains(currentCategory))) {
                categories.add(currentCategory);
            }
        }

        for (int i = 0; i < categories.size();  i++) {
            double categoryGrade = 0.0;
            double categoryWeight = categories.get(i).getWeight();
            int categorySize = 0;
            for (int j = 0; j < studentGradeItems.size(); j++) {
                if (((GradebookItem)
                        studentGradeItems.get(j)).getGradebookCategory()
                        == categories.get(i)) {
                    categorySize++;
                    categoryGrade = categoryGrade
                       + ((GradebookItem) studentGradeItems.get(j)).getGrade();
                }
            }
            double categoryAverage = categoryGrade / categorySize;
            overallGrade = overallGrade  +  categoryAverage * categoryWeight;
        }
        return overallGrade;
    }
}
