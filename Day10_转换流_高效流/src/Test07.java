import java.io.*;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 08:48
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\a.txt"));
        oos.writeObject(new student("zs", "18", "nan"));
        oos.close();
    }

    static class student implements Serializable {
        private String name;
        private String age;
        private String sex;

        public student(String name, String age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

}
