package gradebook.model;

/**
*  A single assignment for a particular student.
*/
public class GradebookItem implements Cloneable {

    private String name;
    private GradebookCategory gradebookCategory;
    private double grade;

    public GradebookItem(String itemName,
            double itemGrade, GradebookCategory itemCategory) {
        name = itemName;
        gradebookCategory = itemCategory;
        grade = itemGrade;
    }

    public String getName() {
        return name;
    }

    public GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    public double getGrade() {
        return grade;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            return null;
        }
    }

}

