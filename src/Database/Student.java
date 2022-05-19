package Database;

public class Student {
    //encapsulation for the variables to be used by getter and setter function
    private String name;
    private String surname;
    private int age;
    private int year;
    private String studentNumber;

    //Constructor method
    public Student(String n, String sur, int a, int y, String s)
    {
        name = n;
        surname = sur;
        age = a;
        year = y;
        studentNumber = s;
    }

    //getter and setter function for name
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }
    //getter and setter function for surname
    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String sur)
    {
        surname = sur;
    }
    //getter and setter function for age
    public int getAge()
    {
        return age;
    }
    public void setAge(int a)
    {
        age = a;
    }
    //getter and setter function for year
    public int getYear()
    {
        return year;
    }
    public void setYear(int y)
    {
        year = y;
    }
    //getter and setter function for Student number
    public String getStudentNumber()
    {
        return studentNumber;
    }
    public void setStudentNumber(String s)
    {
        studentNumber = s;
    }
}
