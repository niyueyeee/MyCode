package Day02;

import Day02.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 01:50
 */
public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("张三",18,"男");
        Student s2 = new Student("李四",19,"男");
        Student s3 = new Student("王五",11,"男");
        ArrayList<Student> obj = new ArrayList<>();
        obj.add(s1);
        obj.add(s2);
        obj.add(s3);
        System.out.println(arrlist(obj));
    }

    private static String arrlist(ArrayList<Student> obj) {
        int i = 0;
        int index = 0;
        for (int i1 = 0; i1 < obj.size(); i1++) {
            if (obj.get(i1).getAge()>i){
                index = i1;
                i=obj.get(i1).getAge();
            }

        }
        return obj.get(index).setName("小猪佩奇");
    }
}
