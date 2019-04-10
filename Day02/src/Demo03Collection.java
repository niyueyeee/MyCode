package Day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 09:52
 */
public class Demo03Collection {
//    public static void main(String[] args) {
////        int[] arr = {10,20,30,22,33};
////        System.out.println(zhuanHuan(arr));
////        ArrayList<Integer> list = listTest(arr);
////        System.out.println(list);
////    }
////
////    private static String zhuanHuan(int[] arr) {
////        return Arrays.toString(arr);
////
////    }
////    //    public static void main(String[] args) {
////    //        //定义int数组
////    //        int[] arr = {1, 2, 3, 4, 5};
//////    }
//////
////    public static ArrayList<Integer> listTest(int[] arr) {
////        //定义集合
////        ArrayList<Integer> list = new ArrayList<>();
////        //遍历数组，把元素依次添加到集合当中
////        for (int a : arr) {
////            list.add(a);
////        }
////        return list;
////    }
public static void main(String[] args) {
    int[] i = {10,11,12,33};
    ArrayList<Integer> list = ListTest(i);
    System.out.println(list);
}

private static ArrayList<Integer> ListTest(int[] i) {
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i1 : i) {
            objects.add(i1);
            }
        return objects;
    }
}
