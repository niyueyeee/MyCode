package Day03.Test13.Comparator;

/**
 * @authro niyueyeee
 * @create 2019-01-10 上午 09:54
 */
public class Person {
    private String name;
    private int age;
    private float score;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Person(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Person() {
    }


}
