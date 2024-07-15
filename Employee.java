package mainfiles;

public abstract class Employee {
    private String name;
    private int id;
    private String joiningDate;

    public Employee(String name, int id, String joiningDate) {
        this.name = name;
        this.id = id;
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", joining date=" + joiningDate + ", salary=" + calculateSalary() + "]";
    }
}
