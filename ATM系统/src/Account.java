public class Account {
    /**
     * 账户类
     */
    private String cardId;
    private String userName;//用户
    private String password;//密码
    private double money;//余额
    private double quotemaney;//每次取现限度



    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotemaney() {
        return quotemaney;
    }

    public void setQuotemaney(double quotemaney) {
        this.quotemaney = quotemaney;
    }
}
