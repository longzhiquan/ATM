package YOUHUI;

public class Text {
    public static void main(String[] args) {
        Glodcard c=new Glodcard();
        c.setUsername("SB");
        c.setMoney(100000.0);
        c.pay(300.0);
        System.out.println("剩余："+c.getMoney());
    }
}
