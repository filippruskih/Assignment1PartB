import assignment1package.CourseProgramme;
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
        Module m6 = new Module("Astrophysics", "AS3117", students);
        Module m7 = new Module("Economics", "EC422", students);

        //adding the modules to an ArrayList
        ArrayList<Module> modules = new ArrayList<Module>(List.of(m1, m2, m3, m4, m5, m6, m7));

        //creating 3 courses to which the modules will be assigned to
        CourseProgramme c1 = new CourseProgramme("CSIT", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        CourseProgramme c2 = new CourseProgramme("BUS", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        CourseProgramme c3 = new CourseProgramme("ART", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-09-05"), DateTime.parse("2023-09-04"));
        //adding the courses to their list
        ArrayList<CourseProgramme> courseProgrammes = new ArrayList<CourseProgramme>(List.of(c1, c2, c3));

        //Adding courses to students
        s1.setCourse(new ArrayList<CourseProgramme>(List.of(c1)));
        s2.setCourse(new ArrayList<CourseProgramme>(List.of(c3)));
        s3.setCourse(new ArrayList<CourseProgramme>(List.of(c2)));
        s4.setCourse(new ArrayList<CourseProgramme>(List.of(c1)));
        s5.setCourse(new ArrayList<CourseProgramme>(List.of(c3)));

        //Adding modules to students
        s1.setModules(new ArrayList<Module>(List.of(m1, m2, m4, m5)));
        s2.setModules(new ArrayList<Module>(List.of(m1, m2, m6)));
        s3.setModules(new ArrayList<Module>(List.of(m3, m7)));
        s4.setModules(new ArrayList<Module>(List.of(m1, m2, m4, m5)));
        s5.setModules(new ArrayList<Module>(List.of(m1, m2, m6)));

        //Adding students to modules
        m1.setStudent(new ArrayList<Student>(List.of(s1, s2, s4, s5)));
        m2.setStudent(new ArrayList<Student>(List.of(s1, s2, s4, s5)));
        m3.setStudent(new ArrayList<Student>(List.of(s3)));
        m4.setStudent(new ArrayList<Student>(List.of(s1, s4)));
        m5.setStudent(new ArrayList<Student>(List.of(s1, s4)));
        m6.setStudent(new ArrayList<Student>(List.of(s2, s5)));
        m7.setStudent(new ArrayList<Student>(List.of(s3)));

        //Adding courses to modules
        m1.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c1, c3)));
        m2.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c1, c3)));
        m3.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c2)));
        m4.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c1)));
        m5.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c1)));
        m6.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c3)));
        m7.setCourseProgramme(new ArrayList<CourseProgramme>(List.of(c2)));

        //Adding students to courses
        c1.setStudent(new ArrayList<Student>(List.of(s1, s4)));
        c2.setStudent(new ArrayList<Student>(List.of(s3)));
        c3.setStudent(new ArrayList<Student>(List.of(s2, s5)));

        //Adding modules to courses
        c1.setModule(new ArrayList<Module>(List.of(m1, m2, m4, m5)));
        c2.setModule(new ArrayList<Module>(List.of(m3, m7)));
        c3.setModule(new ArrayList<Module>(List.of(m1, m2, m6)));

        System.out.println("\nStudent Data");
        for (Student s : students)
        {
            System.out.println("Name: " + s.getName() + " " + s.getSurname());
            System.out.println("Age: " + s.getAge());
            System.out.println("DOB: " + s.getDob().toString("yyyy-MM-dd"));
            System.out.println("ID: " + s.getId());
            System.out.println("Username: " + s.getUsername());
            System.out.println("Course student is in: ");
            for (CourseProgramme c : s.getCourse())
            {
                System.out.println("\t" + c.getCourseName());
            }
            System.out.println("Modules taking: ");
            for (Module m : s.getModules())
            {
                System.out.println("\t"+ m.getModuleID() +" - " + m.getModuleName());
            }
            System.out.println("  ");
        }

        System.out.println("\nModule Data");
        for (Module m : modules)
        {
            System.out.println("Module: "+ m.getModuleID()+ " - " + m.getModuleName());
            System.out.println("Module is in ");
            for (CourseProgramme c : m.getCourseProgramme())
            {
                System.out.println("\t" + c.getCourseName());
            }
            System.out.println("Students that are taking this module: ");
            for (Student s : m.getStudent())
            {
                System.out.println("\t" + s.getName()+" "+s.getSurname());
            }
            System.out.println(" ");
        }

        System.out.println("\nCourse Data");
        for (CourseProgramme c : courseProgrammes)
        {
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Modules in "+ c.getCourseName());
            for (Module m : c.getModule())
            {
                System.out.println("\t"+ m.getModuleID() +" - "+ m.getModuleName());
            }
            System.out.println("Students in "+ c.getCourseName());
            for (Student s : c.getStudent())
            {
                System.out.println("\t" + s.getName()+" "+s.getSurname()+ " ("+ s.getUsername()+")");
            }
            System.out.println("Academic start date: " + c.getStartDate().toString("yyyy-MM-dd"));
            System.out.println("Academic end date: " + c.getEndDate().toString("yyyy-MM-dd"));
            System.out.println(" ");
        }
    }
}

