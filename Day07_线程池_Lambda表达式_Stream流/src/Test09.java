/**
 * @authro niyueyeee
 * @create 2019-01-15 下午 09:48
 */
public class Test09 {
    public static void main(String[] args) {
        invokeDirect(()->{
            System.out.println("导演拍电影啦!");
        });
    }

    private static void invokeDirect(Director director) {
        director.makeMovie();
    }


    public interface Director {
        void makeMovie();
    }
}
