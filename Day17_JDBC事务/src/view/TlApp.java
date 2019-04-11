package view;

import service.TlAccountService;

/**
 * @authro niyueyeee
 * @create 2019-02-13 上午 09:23
 */
public class TlApp {
    public static void main(String[] args) {
        try {
            String outUser="jack";
            String inUser="rose";
            Integer money = 100;
            TlAccountService tlAccountService = new TlAccountService();
            tlAccountService.transfer(outUser,inUser,money);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
