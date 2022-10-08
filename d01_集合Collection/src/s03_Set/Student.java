package s03_Set;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override   //int类型的返回值，为负则存左边；为0则重复，不存；为正则存右边
    public int compareTo(Student o) {
        //主条件
        int result = this.age - o.age;
        //次条件
        result = result == 0 ? this.name.compareTo(o.getName()) : result;

        return result;
    }
}
