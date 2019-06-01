import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 08:58
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //1.1 定义集合,用来存储54张扑克 牌盒
        ArrayList<String> pokers = new ArrayList<>();
        //1.2 定义存储String集合
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> nums = new ArrayList<>();
        //1.3 存储花色和数字
        //存储花色
        colors.add("♥");
        colors.add("♠");
        colors.add("♦");
        colors.add("♣");
        //存储数字: 2-10 J,Q,K,A
        for (int i = 2; i <= 10; i++) {
            nums.add(i + " ");
        }
        nums.add("j");
        nums.add("q");
        nums.add("k");
        nums.add("A");
        //1.4 遍历花色和数字集合,拼接扑克存储到 牌盒
        //遍历花色
        for (String color : colors) {
            for (String num : nums) {
                String s = color + num;
                pokers.add(s);
            }

        }
        //1.5 存储大小王
        pokers.add("大王");
        pokers.add("小王");

        //2. 洗牌
        Collections.shuffle(pokers);
        //3. 发牌
        //3.1 创建3个玩家集合和1个底牌集合
        ArrayList<Object> p1 = new ArrayList<>();
        ArrayList<Object> p2 = new ArrayList<>();
        ArrayList<Object> p3 = new ArrayList<>();
        ArrayList<Object> DiPai = new ArrayList<>();
        //3.2 遍历牌盒,根据扑克的编号进行发牌
        //注意: 此处遍历只能使用普通for + 索引的方式
        //3.3 获取当前扑克

        //3.4 先流底牌

        //3.4 根据扑克的编号进行发牌
        for (int i = 0; i < pokers.size(); i++) {
            String poker = pokers.get(i);
            if (i > 50) {
                DiPai.add(poker);
            } else if (i % 3 == 0) {
                p1.add(poker);
            } else if (i % 3 == 1) {
                p2.add(poker);
            } else {
                p3.add(poker);
            }
        }


        //4.看牌
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(DiPai);

    }
}
