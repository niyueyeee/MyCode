package Day03.Test13.Comparable;


import java.util.Arrays;

/**
 * @authro niyueyeee
 * @create 2019-01-10 上午 10:34
 */
public class Test {
    public static void main(String[] args) {
        Person[] stu = {
                new Person("liusan", 20, 90.0f),
                new Person("lisi", 22, 90.0f),
                new Person("wangwu", 20, 99.0f),
                new Person("sunliu", 22, 100.0f)};
        Arrays.sort(stu);
        for (Person s : stu) {
            System.out.println(s);
        }
    }
}

