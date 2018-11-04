package str_Bean;
@TableName(name="teacher")
public class Teacher {
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
    @ColumnName(name="name")
    private String name;
    @ColumnName(name="id")
    private int id;
}
