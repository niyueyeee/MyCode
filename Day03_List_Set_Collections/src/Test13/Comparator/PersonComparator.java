package Day03.Test13.Comparator;

import java.util.Comparator;

/**
 * @authro niyueyeee
 * @create 2019-01-10 上午 10:53
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getScore() > o2.getScore()) {
            return -1;
        } else if (o1.getScore() < o2.getScore()) {
            return 1;
        } else {
            if (o1.getAge() > o2.getAge()) {
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
