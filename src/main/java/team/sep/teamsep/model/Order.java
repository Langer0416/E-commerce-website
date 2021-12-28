package team.sep.teamsep.model;

/**
 * 建立Order.
 */

public class Order {

    /**
     * 宣告Order的變數型態.
     */
    private String account;

    private String pay;

    private String deliver;

    private int id;

    private String name;

    private Integer money;

    /**
     * public Order.
     */

    public Order() {
    }

    /**
     * public Order(String account,String pay, String deliver,int id,String name).
     */

    public Order(String account, String pay, String deliver, int id, String name,Integer money) {
        this.account = account;
        this.pay = pay;
        this.deliver = deliver;
        this.id = id;
        this.name =  name;
        this.money =  money;
    }
    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account =account;
    }

    public String getpay() { return pay; }

    public void setpay(String pay) {
        this.pay = pay;
    }

    public String getdeliver() {
        return deliver;
    }

    public void setdeliver(String deliver) {
        this.deliver = deliver;
    }

    public int getid(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name =  name;
    }

    public Integer getmoney() {
        return money;
    }

    public void setmoney(Integer money) {
        this.money = money;
    }
}

