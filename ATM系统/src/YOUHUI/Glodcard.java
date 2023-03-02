package YOUHUI;

public class Glodcard extends Card {

    @Override
    public void pay(double money) {
        System.out.println("您当前消费："+money);
        System.out.println("您当前卡片余额："+getMoney());
        //优惠价
        double rs=money*0.8;
        System.out.println("您实际需要支付："+rs);
        //更新余额
        setMoney(getMoney()-rs);
    }
}
