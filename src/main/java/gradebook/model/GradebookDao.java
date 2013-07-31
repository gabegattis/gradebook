package gradebook.model;



/**
* The interface for the generic data access objects
* that will serve as a databases for gradebook entries
*/
public interface GradebookDao {

     void add(Object o);
     void remove(Object o);
     void remove(int index);
     int size();
     void clear();
     Object get(int index);

}
