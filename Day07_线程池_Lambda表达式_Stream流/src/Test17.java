import java.util.Arrays;

/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 03:38
 */
public class Test17 {
    public static void main(String[] args) {
        //在测试类中定义一个学生数组，存储学生信息。
        Students[] arr = {
                new Students("zhangS", 88.88),
                new Students("liS", 77.77),
                new Students("zhaoL", 99.99),
                new Students("wangW", 66.66),
                new Students("qiX", 67.77)
        };
        //使用Lambda省略格式写法对学生数组按照考试成绩由高到低进行排序。
        Arrays.sort(arr, (s1, s2) -> (int) (s1.getSroce() - s2.getSroce()));
        for (Students students : arr) {
            System.out.println(students);
        }
    }

    public static class Students {
        private String name;
        private double sroce;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSroce() {
            return sroce;
        }

        public void setSroce(double sroce) {
            this.sroce = sroce;
        }

        public Students(String name, double sroce) {
            this.name = name;
            this.sroce = sroce;
        }

        @Override
        public String toString() {
            return "Students{" +
                    "name='" + name + '\'' +
                    ", sroce=" + sroce +
                    '}';
        }

        public Students() {
        }
    }
}
