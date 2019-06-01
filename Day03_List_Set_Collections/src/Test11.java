package Day03;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 09:49
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        sc.next();
        LinkedHashSet<Character> lin = new LinkedHashSet<>();
        System.out.println("请输入:");
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
//        for (char aChar : chars) {
//            System.out.print(aChar+" ");
//        }
        for (char aChar : chars) {
            lin.add(aChar);
        }
//        for (char aChar : chars) {
//            if (!lin.contains(aChar)){
//                lin.add(String.valueOf(aChar));
//            }
//        }
        for (Character s : lin) {
            System.out.print(s + " ");
        }
    }
}
