package Day02;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 01:37
 */
public class Student {

    //    public static void main(String[] args) {
//
//     Student1("张三", 23, "男");
//    }
//
//    private static void Student1(String s, int i, String d) {
//        priv
//    }
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student() {
    }

    private String sex;

}
