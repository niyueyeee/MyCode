/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 09:18
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(sumPeach(1));
    }

    private static int sumPeach(int i) {
        if (i == 10) {
            return 1;
        } else {
            // 递归计算前一天的数量
            return 2 * sumPeach(i + 1) + 2;
        }
    }
}
