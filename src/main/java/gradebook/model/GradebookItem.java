package gradebook.model;

/**
*  A single assignment for a particular student.
*/
public class GradebookItem {

    private String name;
    private GradebookCategory gradebookCategory;
    private double grade;

    public GradebookItem(String itemName,
            double itemGrade, GradebookCategory itemCategory) {
        name = itemName;
        gradebookCategory = itemCategory;
        grade = itemGrade;
    }

    String getName() {
        return name;
    }

    GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    double getGrade() {
        return grade;
    }

}

