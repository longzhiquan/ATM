package YOUHUI;

public abstract class Card {
    private String username;
    private double money;

    /**
     * 定义一个抽象支付方法
     * 用于子类使用
     * @param money
     */
    public abstract void pay(double money);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
