package Test04;

/**
 * @authro niyueyeee
 * @create 2019-01-24 上午 09:38
 */
public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗在吃东西....");
    }

    @Override
    public void sleep() {
        System.out.println("狗在睡觉....");
    }
}
