package gradebook.model;

import java.util.ArrayList;

/**
*  An implementation of the data access object using
*  ArrayList as the storage object
*/
public class GradebookDb implements GradebookDao {

    private ArrayList<Object> db;

    public GradebookDb() {
        db = new ArrayList<Object>();
    }

    public void add(Object o) {
        db.add(o);
    }

    public void remove(Object o) {
        db.remove(o);
    }

    public void remove(int index) {
        db.remove(index);
    }

     public int size() {
        return db.size();
    }

    public void clear() {
        db.clear();
    }

    public Object get(int index) {
        return db.get(index);
    }
}
