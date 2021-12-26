package team.sep.teamsep.model;

/**
 * 建立Product.
 */

public class Product {

    /**
     * 宣告Product的變數型態.
     */

    private long id;

    private String name;

    private int stock;

    private int price;

    private int quantity;

    private String picture;

    private String pay;

    private String deliver;

    private String account;

    /**
     * public Product.
     */

    public Product() {
    }

    /**
     * Product(long id, String name,int stock, int price,int quantity, String picture,String
     * pay,String deliver,String account).
     */

    public Product(long id, String name, int stock, int price, int quantity,
                   String picture, String pay, String deliver, String account) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price =  price;
        this.quantity = quantity;
        this.picture = picture;
        this.pay = pay;
        this.deliver = deliver;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstock() {
        return stock;
    }

    public void setInstock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public String  getAccount() {
        return  account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
