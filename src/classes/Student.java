package classes;

public class Student {
    int ID;
    String name;
    Student(int ID , String name){
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID:"+ID+" name:"+name;
    }
}
