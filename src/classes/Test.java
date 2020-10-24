package classes;

import java.util.ArrayList;
import java.util.List;

public class Test {
    List<String> arr1 =  new ArrayList<>();
    List arr2 = new ArrayList();

    public static void main(String[] args) {
        new Test();
    }
    public Test(){
//        arr1.add("56");
//        System.out.println(arr1.get(0));
//        arr2.add("78");
//        //String animal = arr2.get(0);//Required type:String ; Provided:Object
//        String animal = (String) arr2.get(0);//вниз по иерархии

    //////////////////////////

        MyArrayList<Student> students = new MyArrayList<>();
        students.getLength();
        System.out.println(students.getCountOfElements());
        students.add(new Student(14,"G"));
        students.get(0);
        students.getLength();
        System.out.println(students.getCountOfElements());
        students.add(new Student(14,"G"));

    }
}
