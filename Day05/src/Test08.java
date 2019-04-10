package Day05;

/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 09:27
 */
public class Test08 {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setScore(100);
        stu.setScore(-100);
    }

    private static class Student {
        private String name;
        private double score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            if (score < 0) {
                throw new NoScoreException(":分数不能为负数" + score);
            }
            this.score = score;
        }

        public Student() {
        }

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }


    }

    public static class NoScoreException extends RuntimeException {
        public NoScoreException() {
            super();
        }

        public NoScoreException(String message) {
            super(message);
        }
    }
}
