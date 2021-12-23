package team.sep.teamsep.model;

public class Order {

    private String pay;

    private String deliver;

    private int id;

    private String name;

    public Order() {
    }

    public Order(String pay, String deliver,int id,String name) {
        this.pay = pay;
        this.deliver = deliver;
        this.id = id;
        this.name =  name;
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

    public void setPassword(String name) {
        this.name =  name;
    }
}

