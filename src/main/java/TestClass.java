import assignment1package.CourseProgramme;
import assignment1package.Lecturer;
import assignment1package.Student;
import assignment1package.Module;
import org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.List;

public class TestClass
{
    public static void main(String[] args)
    {
        //creates 5 students with mock data
        Student s1 = new Student("Filipp", "Ruskih", 23, DateTime.parse("1999-06-06"), 19345561);
        Student s2 = new Student("Sam", "Mc", 24, DateTime.parse("1998-09-12"), 19871831);
        Student s3 = new Student("Gearoid", "Ryan", 19, DateTime.parse("2000-12-31"), 20358192);
        Student s4 = new Student("Kim", "Kiely", 24, DateTime.parse("1998-01-12"), 18880201);
        Student s5 = new Student("Ciara", "Oshea", 21, DateTime.parse("2000-10-24"), 20474774);
        //adds the 5 student to an ArrayList
        ArrayList<Student> students = new ArrayList<Student>(List.of(s1, s2, s3, s4, s5));

        //creating 5 modules that the students will be assigned to
        Module m1 = new Module("Machine Learning", "CT4101", students);
        Module m2 = new Module("Euclidean and Non Euclidean Geometry", "MA3101", students);
        Module m3 = new Module("Advanced Professional Skills", "CT436", students);
        Module m4 = new Module("Systems Modelling and Simulation", "CT561", students);
        Module m5 = new Module("Software Engineering III", "CT417", students);

        //adding the modules to an ArrayList
        ArrayList<Module> modules = new ArrayList<Module>(List.of(m1, m2, m3, m4, m5));

        //creating 3 courses to which the modules will be assigned to
        CourseProgramme c1 = new CourseProgramme("CSIT", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        CourseProgramme c2 = new CourseProgramme("BUS", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        CourseProgramme c3 = new CourseProgramme("SCI", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        //adding the courses to their list
        ArrayList<CourseProgramme> courseProgrammes = new ArrayList<CourseProgramme>(List.of(c1, c2, c3));

        // *********** NOTHING MENTIONED ABOUT TESTING THIS COME BACK TO IT AT THE END *************
        //creating lecturers that will be in charge of the modules
        Lecturer l1 = new Lecturer("John", "Burns", 55, DateTime.parse("1969-07-07"), 1234);
        Lecturer l2 = new Lecturer("Frank", "Glavin", 35, DateTime.parse("1983-07-07"), 4321);
        //adding the lecturers to their ArrayList
        ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>(List.of(l1, l2));

        //Adding courses to students
        s1.setCourse(new ArrayList<CourseProgramme>(List.of(c1)));
        s2.setCourse(new ArrayList<>(List.of(c2)));
        s3.setCourse(new ArrayList<CourseProgramme>(List.of(c1, c3)));

        //Adding modules to students
        s1.setModules(new ArrayList<Module>(List.of(m1, m2)));
        s2.setModules(new ArrayList<Module>(List.of(m1, m3)));
        s3.setModules(new ArrayList<Module>(List.of(m3, m4)));

        //Adding students to modules
        m1.setStudent(new ArrayList<Student>(List.of(s1, s2)));
        m2.setStudent(new ArrayList<Student>(List.of(s1)));
        m3.setStudent(new ArrayList<Student>(List.of(s2, s3)));
        m4.setStudent(new ArrayList<Student>(List.of(s3)));

        //Adding courses to modules
        m1.setCourseProgramme(new ArrayList<>(List.of(c1)));
        m2.setCourseProgramme(new ArrayList<>(List.of(c1, c3)));
        m3.setCourseProgramme(new ArrayList<>(List.of(c1)));
        m4.setCourseProgramme(new ArrayList<>(List.of(c1)));

        //Adding students to courses
        c1.setStudent(new ArrayList<Student>(List.of(s1, s3)));
        c2.setStudent(new ArrayList<Student>(List.of(s2)));
        c3.setStudent(new ArrayList<Student>(List.of(s1, s3)));

        //Adding modules to courses
        c1.setModule(new ArrayList<Module>(List.of(m1, m2, m3, m4)));
        //c2.setModule(new ArrayList<Module>(List.of(m1)));
        c3.setModule(new ArrayList<Module>(List.of(m2)));

        //l1.setLecturer(new ArrayList<Lecturer>(List.of(s1, s2)));

        System.out.println("\nStudent Data");
        for (Student s : students)
        {
            System.out.println("Name: " + s.getName() + " " + s.getSurname());
            System.out.println("Age: " + s.getAge());
            System.out.println("DOB: " + s.getDob().toString("yyyy-MM-dd"));
            System.out.println("ID: " + s.getId());
            System.out.println("Username: " + s.getUsername());
            System.out.println("Courses: ");
            for (CourseProgramme c : s.getCourse())
            {
                System.out.println(" " + c.getCourseName());
            }
            System.out.println("Modules: ");
            for (Module m : s.getModules())
            {
                System.out.println(" " + m.getModuleName());
            }
            /*System.out.println("Lecturers: ");
            for(Lecturer l: s.getLecturer())
            {
                System.out.println(" "+l.getLecturerName());
            }*/
            System.out.println("\n");
        }
    }
}

