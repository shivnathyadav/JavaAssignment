package Assignment12;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    int id;
    String firstname;
    int age;
    String gender;
    String engDepartment;
    int year_of_enrollment;
    Double perTillDate;

    public Student(  int id, String firstname, int age, String gender,String engDepartment,int year_of_enrollment,double perTillDate){
        this.id=id;
        this.firstname=firstname;
        this.age=age;
        this.gender=gender;
        this.engDepartment=engDepartment;
        this.year_of_enrollment=year_of_enrollment;
        this.perTillDate=perTillDate;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getYear_of_enrollment() {
        return year_of_enrollment;
    }

    public String getFirstname() {
        return firstname;
    }

    public Double getPerTillDate() {
        return perTillDate;
    }

    public int getId() {
        return id;
    }
}

class StreamApi{
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>() ;

        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        //1st Problem
        HashMap<String , Integer> countDepartment = new HashMap<>();
        for (int i = 0; i <studentList.size() ; i++) {
            countDepartment.put(studentList.get(i).getEngDepartment(),i);
        }
        System.out.println("All the Departments:");


        for(Map.Entry<String,Integer> student : countDepartment.entrySet()){
            System.out.println(student.getKey());
        }

        //2nd Problem
        System.out.println("All the student names after 2018");
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getYear_of_enrollment()>2018){
                System.out.println(studentList.get(i).getFirstname());
            }
        }

        //3rd Problem
        System.out.println("All the details of males from sci department:");
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getEngDepartment().equalsIgnoreCase("Computer Science" ) && studentList.get(i).getGender().equalsIgnoreCase("Male")){
                System.out.println("FirstName: "+studentList.get(i).getFirstname()+ ", Student Id: "+studentList.get(i).getId() + ", Stduent Age:"+studentList.get(i).getAge() + ", Year Of Enrollment:  "+studentList.get(i).getYear_of_enrollment() + " Percentage Maintained: "+studentList.get(i).getPerTillDate());
            }
        }

        //4rth Problem
        System.out.println("Grouped by Gender");

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.counting())));

        //5th Problem

        System.out.println("Average Age of Males and Females ");

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge))));

        //6th Problem

        System.out.println("details of highest student having highest percentage");

        Optional<Student> highest=studentList.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getPerTillDate)));
        System.out.println(highest.get().getFirstname()+" has highest percentage");

        //7th Problem

        System.out.println("Count the number of Student in each Department");

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment,Collectors.counting())));

        //8th Problem

        System.out.println("Average Percentage of each Department");

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment,Collectors.averagingDouble(Student::getPerTillDate))));

        //9th Problem

        System.out.println("detail of Youngest male from Electronic Department");

        Optional<Student> youngest = studentList.stream().filter((Student student)->student.getEngDepartment()=="Electronic").collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println(youngest.get().getFirstname()+ " is youngest male in Electronic department");

        //10th Problem

        System.out.println("Count number of Male and Female in CS Department");

        System.out.println(studentList.stream().filter(((Student student)->student.getEngDepartment()=="Computer Science")).collect(Collectors.groupingBy(Student::getGender ,Collectors.counting())));


    }
}
