package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class UserMap {

    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<>();
        list.add(new Student("Rahul", 101));
        list.add(new Student("Raman", 110));
        list.add(new Student("Rajesh", 102));
        list.add(new Student("Rakesh", 120));

        list.sort(null);
        System.out.println(list);

    }
}

class Student implements Comparable<Student> {
    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "rollNumber:" + rollNumber + " name:" + name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Student student) {

        return Double.compare(this.getRollNumber(), student.getRollNumber());
    }

}

class SortedMapDemo {

    public static void main(String[] args) {
        SortedMap<Student, Integer> sortedMap = new TreeMap<>(
                (a, b) -> a.getRollNumber() - b.rollNumber
//                (a,b)->{
//            if(a.length()>b.length()){
//                return -1;
//            }
//            else if(a.length()<b.length()){
//               return 1;
//            }
//            else{
//                return a.compareTo(b);
//            }
//        }
        );

//        sortedMap.put("qwidub",5);
//        sortedMap.put("sdhj",50);
//        sortedMap.put("qwhj",1);

        sortedMap.put(new Student("Rahul", 101), 10);
        sortedMap.put(new Student("Raman", 110), 1);
        sortedMap.put(new Student("Rajesh", 102), 20);
        sortedMap.put(new Student("Rakesh", 120), 2);

        System.out.println(sortedMap);
    }


}

class SortedListOfMapDemo {

    public static void main(String[] args) {
        SortedMap<Student, Integer> sortedMap = new TreeMap<>(
                (a, b) -> a.getRollNumber() - b.rollNumber
//                (a,b)->{
//            if(a.length()>b.length()){
//                return -1;
//            }
//            else if(a.length()<b.length()){
//               return 1;
//            }
//            else{
//                return a.compareTo(b);
//            }
//        }
        );

//        sortedMap.put("qwidub",5);
//        sortedMap.put("sdhj",50);
//        sortedMap.put("qwhj",1);

        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        list.add(new HashMap<>() {{
            put("colum", 101);
        }});
        list.add(new HashMap<>() {{
            put("colum", 110);
        }});
        list.add(new HashMap<>() {{
            put("colum", 102);
        }});
        list.add(new HashMap<>() {{
            put("colum", 120);
        }});

        list.sort((a, b) -> b.get("colum") - a.get("colum"));
        System.out.println(list);
    }


}
