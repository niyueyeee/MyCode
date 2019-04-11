import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 08:02
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        shuru();
        yanzheng();
    }

    private static void yanzheng() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day10\\src\\data.txt"));
        System.out.println("输入验证码:");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        String s = sc.nextLine();
        String b = null;
        while ((b = br.readLine()) != null) {
            strings.add(b);
        }
        br.close();
        if (strings.contains(s)) {
            System.out.println("y");

        } else {
            System.out.println("n");
        }
    }

    private static void shuru() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day10\\src\\data.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.println("输入三次:");
        for (int i = 0; i < 3; i++) {
            bw.write(sc.nextLine());
            bw.newLine();
            if (i == 2) break;
            System.out.println("next:");
        }

        bw.close();
    }
}
