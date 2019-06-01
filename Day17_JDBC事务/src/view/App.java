package view;

import service.AccountService;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 10:10
 */
public class App {
    public static void main(String[] args) {
        try {
            String outUser = "jack";
            String inUser = "rose";
            Integer money = 100;
            AccountService accountService = new AccountService();
            accountService.transfer(outUser, inUser, money);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
