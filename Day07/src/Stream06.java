import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 07:33
 */
public class Stream06 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("陈玄风");
        one.add("梅超风");
        one.add("陆乘风");
        one.add("曲灵风");
        one.add("武眠风");
        one.add("冯默风");
        one.add("罗玉风");
        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("俞莲舟");
        two.add("俞岱岩");
        two.add("张松溪");
        two.add("张翠山");
        two.add("殷梨亭");
        two.add("莫声谷");
//        one.stream().filter(s -> s.length()==3).forEach(System.out::println);
//        one.stream().filter(s -> s.length()==3).limit(6).forEach(System.out::println);
//        two.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
//        two.stream().filter(s -> s.startsWith("张")).skip(1).forEach(System.out::println);
        Stream.concat(one.stream().filter(s -> s.length()==3).limit(6),two.stream().filter(s -> s.startsWith("张")).skip(1)).forEach(System.out::println);
//        Stream.concat(one.stream().filter(s -> s.length()==3).limit(6),two.stream().filter(s -> s.startsWith("张")).skip(1)).map(Student::new).forEach(System.out::println);
    }
    public class Student {
        private String name;

        public Student() {
        }

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return " Student {name='" + name + "'}";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}

