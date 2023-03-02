import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMsystem {
    /**
     * ATM入口类
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Account> accounts=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=============ATM系统===============");
            System.out.println("1.账户登录");
            System.out.println("2.账户注册");


            System.out.println("请输入您的操作");
            int commend = sc.nextInt();
            switch (commend) {
                case 1:
                    //登录
                    loin(accounts,sc);
                    break;
                case 2:
                    //注册
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("对不起，您输入的操作不存在！！");

            }
        }
    }

    /**
     * 登录功能
     * @param accounts 所有账户信息
     * @param sc  扫描器
     */
    private static void loin(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("==================系统登陆操作======================");
        if(accounts.size()==0){
            System.out.println("对不起，当前系统中没有帐户，请先开户！");
            return;
        }
        while (true) {
            System.out.println("请您输入登陆卡号：");
            String cardId=sc.next();
            Account acc =getaccountcardId(cardId,accounts);
            if(acc!=null){
                while (true) {
                    System.out.println("请输入密码：");
                    String passWord=sc.next();
                    if(acc.getPassword().equals(passWord)){
                        //登陆成功！
                        System.out.println("恭喜您，"+acc.getUserName()+"成功登录了，您的卡号为："+acc.getCardId());
                        choseusercommend(sc,acc);
                        return;
                    }else {
                        System.out.println("对不起，您输入的密码有误！");
                    }
                }
            }else {
                System.out.println("对不起，不存在该卡号！");
            }
        }
    }

    /**
     * 展示登陆后的操作页面
     */
    private static void choseusercommend(Scanner sc,Account acc) {
        System.out.println("================用户操作页===================");
        while (true) {
            System.out.println("请选则您的操作：");
            System.out.println("1.查询\t\t 2.存款\t\t 3.取款\t\t 4.转账\t\t 5.修改密码 \t\t6.退出\t\t 7.注销当前账户");
            int commend=sc.nextInt();
            switch (commend){
                case 1:
                  //查询
                    showAccount(acc);
                    break;
                case 2:
                    //存款
                    depositmoneny(acc,sc);
                    break;
                case 3:
                    //取款
                    drowmoney(acc,sc);
                    break;
                case 4:
                    //转账
                    break;
                case 5:
                    //修改密码
                    break;
                case 6:
                    //退出
                    System.out.println("退出成功，期待您的下次光临！");
                    return;
                case 7:
                    //注销
                    break;
                default:
                    System.out.println("您输入的操作命令不正确！");
            }
        }
    }

    /**
     * 取款
     * @param acc//当前用户
     * @param sc
     */
    private static void drowmoney(Account acc, Scanner sc) {
//判断余额是否超过100
        if(acc.getMoney()<100){
            System.out.println("对不起，您的余额不足100元，无法取钱");
            return;
        }
        while (true) {
            System.out.println("请您输入存款金额：");
            double money=sc.nextDouble();
            if(money>acc.getQuotemaney()){
                System.out.println("对不起，您此次的取款金额超过了限额，每次最多可以取"+acc.getQuotemaney());
            }else {
            if(money>acc.getMoney()){
                System.out.println("余额不足~");
            }else {
                System.out.println("恭喜您，成功取得"+money+"元");
                acc.setMoney(acc.getMoney()-money);
                showAccount(acc);
                return;
            }
            }
        }
    }

    /**
     * 存钱进用户中
     * @param acc//当前用户对象
     * @param sc
     */
    private static void depositmoneny(Account acc, Scanner sc) {
        System.out.println("请您输入存入的金额：");
        double Money=sc.nextDouble();
        acc.setMoney(acc.getMoney() + Money);
        System.out.println("恭喜你，成功存入"+Money+"元！当前账户信息如下：");
        showAccount(acc);
    }

    /**
     * 展现账户信息
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("================账户信息如下===================");
        System.out.println("卡号："+acc.getCardId());
        System.out.println("用户："+acc.getUserName());
        System.out.println("余额："+acc.getMoney());
        System.out.println("限额："+acc.getQuotemaney());

    }

    /**
     * 用户开户功能
     * @param accounts
     */

    private static void register(ArrayList<Account> accounts,Scanner sc) {
        Account account=new Account();
        System.out.println("请您输入用户名称：");
        String username= sc.next();
        account.setUserName(username);

        while (true) {
            System.out.println("请您输入密码");
            String password = sc.next();
            System.out.println("请您确认密码");
            String okpassword = sc.next();
            if (password.equals(okpassword)) {
                account.setPassword(okpassword);
                break;//密码已经录入
            } else {
                System.out.println("您的两次输入不一致，请重新输入！");
            }
        }

        System.out.println("请您输入每次限额：");
        double quotemoney=sc.nextDouble();
        account.setQuotemaney(quotemoney);

        String CardId=getCardId(accounts);
        account.setCardId(CardId);

        accounts.add(account);
        System.out.println("恭喜你，"+username+"您已经开户成功，您的开户卡号为："+CardId+"请妥善保管");
    }

    /**
     * 为账户生产8位随机卡号
     * @return
     */

    private static String getCardId(ArrayList<Account> accounts) {
        Random r=new Random();
        while (true){
            String CarId="";
            for (int i = 0; i <8 ; i++) {
                CarId+=r.nextInt(10);
            }
            //判断是否重复
            Account acc=getaccountcardId(CarId,accounts);
            if(acc==null){
                return CarId;
            }
        }
    }

    private static Account getaccountcardId(String carId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc=accounts.get(i);
            if(acc.getCardId().equals(carId)){
                return acc;
            }
        }
        return null;
    }
}
