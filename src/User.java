public class User {
    String userName;
    public User(String userName){
        this.userName = userName;
    }

    public void setUserName(String userName){
        this.userName = userName;

    }
    public String getUserName(){
        if(this.userName.isEmpty()) return "NO NAME";
        return this.userName;
    }
}
