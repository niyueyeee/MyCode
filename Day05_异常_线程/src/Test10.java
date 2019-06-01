/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 09:56
 */
public class Test10 {
    public static void main(String[] args) {
        Person per = new Person();
        per.setXue(-1);
    }

    public static class Person {
        private String name;
        private Integer xue;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getXue() {
            return xue;
        }

        public void setXue(Integer xue) {
            if (xue < 0) {
                throw new NoxueExcepyion("不能为负数" + xue);
            }
            this.xue = xue;
        }

        public Person() {
        }

        public Person(String name, Integer xue) {
            this.name = name;
            this.xue = xue;
        }

        private static class NoxueExcepyion extends RuntimeException {
            public NoxueExcepyion() {
                super();
            }

            public NoxueExcepyion(String s) {
                super(s);
            }
        }
    }
}
