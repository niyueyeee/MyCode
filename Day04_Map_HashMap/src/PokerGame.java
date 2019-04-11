import java.util.*;

/**
 * @authro niyueyeee
 * @create 2019-01-10 下午 08:47
 */
public class PokerGame {
    public static void main(String[] args) {
        //1.准备牌
        //1.1 创建Map集合对象(牌盒),存储54张扑克,键: Integer 编号 值: String 扑克
        HashMap<Integer, String> pokers = zunbei();
        //2.洗牌
        ArrayList<Integer> list = xipai(pokers);
        //3.发牌
        List<Integer> p1 = new ArrayList<>();//玩家一
        List<Integer> p2 = new ArrayList<>();//玩家二
        List<Integer> p3 = new ArrayList<>();//玩家三
        List<Integer> bottom = new ArrayList<>();//底牌
        fapai(list, p1, p2, p3, bottom);
        //4.看牌

        kanpai(p1,"玩家1",pokers);
        kanpai(p2,"玩家2",pokers);
        kanpai(p3,"玩家3",pokers);
        kanpai(bottom,"底牌",pokers);
    }














    private static void fapai(ArrayList<Integer> list, List<Integer> p1, List<Integer> p2, List<Integer> p3, List<Integer> bottom) {
        for (int i = 0; i < list.size(); i++) {
            //获取当前扑克编号
            Integer num = list.get(i);
            //3.3 根据每个编号的索引%3的结果,发给不同的玩家
            //先留出3张底牌
            if(i>50) {
                bottom.add(num);
            } else {
                if(i%3==0) {
                    p1.add(num);
                } else if(i%3==1) {
                    p2.add(num);
                } else {
                    p3.add(num);
                }

            }
        }
    }

    private static ArrayList<Integer> xipai(HashMap<Integer, String> pokers) {
        Set<Integer> set = pokers.keySet();
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);
        return list;
    }

    private static HashMap<Integer, String> zunbei() {
        HashMap<Integer, String> pokers = new HashMap<>();
        //1.2 创建2个List集合对象,分别存储花色和数字
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> nums = new ArrayList<>();
        Collections.addAll(colors, "♥", "♠", "♦", "♣");
        Collections.addAll(nums, "3-4-5-6-7-8-9-10-j-q-k-A-2".split("-"));
        int index = 0;
        for (String num : nums) {
            for (String color : colors) {
                String poker = color + num;
                pokers.put(index++,poker);
            }
        }
        pokers.put(index++,"小王");
        pokers.put(index,"大王");
        return pokers;
    }

    private static void kanpai(List<Integer> p, String string, HashMap<Integer, String> pokers) {
        Collections.sort(p);
        System.out.print(string+":");
        //4.2 遍历玩家手里的编号
        for (Integer num : p) {
            //4.3 存储54张扑克的Map集合对象调用get方法,传递编号作为键,获取对应的值(扑克)
            String poker = pokers.get(num);
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
