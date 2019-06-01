package com.itheima.constant;

/*
存放常量
 */
public interface Constant {
    /*
    激活未激活
     */
    public static final int JI_HUO = 1;
    public static final int WEI_JI_HUO = 0;

    /*
      成功  失败
     */
    public static final int SUCCESS = 1;
    public static final int FAILS = 0;
    public static final int LOGOUT = 2;
    public static final int NO_LOGIN = 3;
    /*
      是否热门
     */
    public static final int IS_HOT = 1;
    public static final int IS_NOT_HOT = 0;

    /*
      是否下架
     */
    public static final int XIA_JIA = 1;
    public static final int WEI_XIA_JIA = 0;

    /*
    订单状态
       0:未付款 1:已付款 2:已发货 3.已完成
     */
    public static final int WEI_FU_KUAN = 0;
    public static final int YI_FU_KUAN = 1;
    public static final int YI_FA_HUO = 2;
    public static final int YI_WAN_CHENG = 3;
}
