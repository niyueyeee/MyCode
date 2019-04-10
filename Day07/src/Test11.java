/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 02:57
 */
public class Test11 {
    public static void main(String[] args) {
        showLongTime(() -> {
            System.out.println(System.currentTimeMillis());
        });
    }

    static void showLongTime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }

    @FunctionalInterface
    public interface CurrentTimePrinter {
        void printCurrentTime();
    }
}
