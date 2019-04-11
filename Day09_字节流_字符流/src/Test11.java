import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 09:40
 */
public class Test11 {
    public static void main(String[] args) throws IOException {

        // 1.定义学生类, 定义存学生的集合
        ArrayList<Student> list = new ArrayList<>();
        // 2.通过3次循环，完成如下操作
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            // 键盘输入学生的信息，
            System.out.print("请输入第" + i + "名学生的学号：");
            String id = sc.nextLine();
            System.out.print("请输入第" + i + "名学生的姓名：");
            String name = sc.nextLine();
            System.out.print("请输入第" + i + "名学生的性别：");
            String sex = sc.nextLine();
            System.out.print("请输入第" + i + "名学生的年龄：");
            String age = sc.nextLine();
            // 把信息封装到Student对象中
            Student s = new Student(id,name,sex,age);
            // 把Student对象存到集合里
            list.add(s);
        }
        // 3.将所有学员信息存储到文件Student.txt中。
        FileWriter out = new FileWriter("d:/a.txt", true);
        // 每名学员信息存储一行，多个属性值中间用逗号隔开。
        for (int i = 0; i < list.size(); i++) {
            // 1.获取集合中每一个学生对象
            Student s = list.get(i);
            // 2.获取对象中的每一个属性值,多个属性值中间用逗号隔开
            String line = s.getId() + "," + s.getName() + "," + s.getSex() + "," + s.getAge();
            // 3.按照指定的格式把对象的属性值，写入到文件中
            out.write(line);
            out.write(System.lineSeparator());
        }
        out.close();// 关闭流
    }

    private static class Student {
        private String id;
        private String name;
        private String sex;
        private String age;

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public Student(String id, String name, String sex, String age) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Student() {
        }
    }
}



