
package team.sep.teamsep.model;

public class ShopCar {

    private String account;

    private int id;

    private int price;

    private String picture;

    private  int instock;

    private int quantity;

    public ShopCar() {
    }

    public ShopCar(String account, int id, int price,String picture,int instock, int quantity) {
        this.account = account;
        this.id = id;
        this.price=price;
        this.picture=picture;
        this.instock=instock;
        this.quantity=quantity;
    }

    public String getAccount() { return account; }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public String getpicture() { return picture; }

    public void setpicture(String picture) {
        this.picture = picture;
    }

    public int getinstock() {
        return instock;
    }

    public void setinstock(int instock) {
        this.instock = instock;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

}

