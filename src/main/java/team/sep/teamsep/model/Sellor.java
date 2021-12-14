package team.sep.teamsep.model;

public class Sellor {

  private String account;

  private String name;

  private int number;

  private String password;

  public Sellor() {
  }

  public Sellor(String account, String name,int number,String password) {
    this.account = account;
    this.name = name;
    this.number = number;
    this.password =  password;
  }

  public String getAccount() { return account; }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber(){
    return number;
  }

  public void setNumber(int number){
    this.number = number;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password =  password;
  }
}
