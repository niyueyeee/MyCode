package OptimizeDoudizhu;


import java.util.ArrayList;
import java.util.Random;

/*
    斗地主综合案例
    1.准备牌
    2.洗牌
        在java.util.Collections工具类中,提供了一个方法:shuffle
            static void shuffle(List<?> list) :打乱List集合中的元素顺序
    3.发牌
    4.看牌

    思考:
        1.能否自己定义shuffle方法
        2.能否把下面代码抽取成方法
        3.玩家呀,其实有固定的名字,而且它具有存储多张牌的能力
            定义一个玩家类Player
            成员变量:
                String name;
                ArrayList<String> list = new ArrayList<>();
 */
public class PokerGame {
    public static void main(String[] args) {
        //调用方法准备牌
        ArrayList<String> pokers = getPokers();

        //2.洗牌
        myShuffle(pokers);
        //3.创建ArrayList集合对象,泛型Player
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("令狐冲"));
        players.add(new Player("田伯光"));
        players.add(new Player("绿竹翁"));
        players.add(new Player("底牌"));
        //4.发牌
        //4.2使用for遍历存储牌的集合pokers进行发牌 不能使用增强for
        for (int i = 0; i < pokers.size(); i++) {
            //先获取牌
            String poker = pokers.get(i);
            if (i > 50) {//留出3张底牌
                players.get(3).getList().add(poker);
            } else {
                if (i % 3 == 0) {//索引等于0,发给玩家一
                    players.get(0).getList().add(poker);
                } else if (i % 3 == 1) {//索引等于1,发给玩家二
                    players.get(1).getList().add(poker);
                } else {//索引等于2,发给玩家三
                    players.get(2).getList().add(poker);
                }
            }
        }
        //5.看牌,遍历存储玩家的ArrayList集合
        //增强for
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getList());
        }

    }

    /*
        准备牌的方法
     */
    private static ArrayList<String> getPokers() {
        //1.准备牌
        //1.1准备存储54张牌的集合
        ArrayList<String> pokers = new ArrayList<>();
        //1.2准备存储花色的集合
        ArrayList<String> colors = new ArrayList<>();
        //1.3准备存储数字的集合
        ArrayList<String> numbers = new ArrayList<>();
        //1.4存储花色
        colors.add("♥");
        colors.add("♠");
        colors.add("♦");
        colors.add("♣");
        //1.5数字 2-10,J,Q,K,A
        //存储2-10
        for (int i = 2; i <= 10; i++) {
            numbers.add(i + "");
        }
        //存储J,Q,K,A
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        //1.6使用for拼接花色和数字,生成扑克牌存入集合
        for (String color : colors) {
            for (String num : numbers) {
                //拼接花色和数字,生成扑克
                String poker = color + num;
                //存入集合
                pokers.add(poker);
            }
        }
        //1.7存入大王/小王
        pokers.add("大王");
        pokers.add("小王");
        return pokers;
    }

    /*
        1.能否自己定义shuffle方法
     */
    public static void myShuffle(ArrayList<String> list) {
        //1.创建Random对象
        Random r = new Random();
        //2.创建新的ArrayList集合对象
        ArrayList<String> newList = new ArrayList<>();
        //3.遍历老集合
        for (int i = 0; i < list.size(); i++) {
            //3.1产生索引
            int index = r.nextInt(list.size());
            //3.2移除索引对应的元素
            String poker = list.remove(index);
            //3.3将元素添加到新集合中
            newList.add(poker);
        }
        list.addAll(newList);//把newList中的所有内容添加到list中
        //清空新集合
        newList.clear();
        newList = null;
    }
}
