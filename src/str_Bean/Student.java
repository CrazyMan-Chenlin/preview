package str_Bean;
@TableName(name="Student")
public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    @ColumnName(name="name")
    private String name;
    @ColumnName(name="id")
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Student() {

    }
}
