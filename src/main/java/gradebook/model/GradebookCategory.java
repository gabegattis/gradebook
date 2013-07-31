package gradebook.model;

/**
* Specifies the category of a gradebook item(test, quiz, homework, etc.)
*/
public class GradebookCategory {

    private String name;
    private double weight;

    public GradebookCategory(String categoryName, double categoryWeight) {
        name = categoryName;
        weight = categoryWeight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
