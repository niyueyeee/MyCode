package OptimizeDoudizhu;
import java.util.ArrayList;

/*
    定义一个玩家类Player
            成员变量:
                String name;
                ArrayList<String> list = new ArrayList<>();
 */
public class Player {//User
    private String name;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }


}
