package Entity;


abstract class Users {
    
    public String name;
    public String email;
    public String password;
    
    public Users(String name, String email, String pass){
        this.name = name;
        this.email = email;
        this.password = pass;
    }


}