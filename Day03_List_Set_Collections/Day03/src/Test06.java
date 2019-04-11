

import java.util.Objects;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 08:35
 */
public class Test06 {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Test06{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test06 test06 = (Test06) o;
        return age == test06.age &&
                Objects.equals(name, test06.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

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

    public Test06(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Test06() {
    }
}
