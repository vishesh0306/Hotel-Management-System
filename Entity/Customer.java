package Entity;


public class Customer extends Users{

    public int age;
    public Cart myCart; 
    public boolean haveCurrentRooms;

    public Customer(String name,  String email, String pass, int age){
        super(name, email, pass);
        this.age = age;
        myCart = new Cart();
    }

    
    public String toString(){

        return this.name + "\t" + this.email + "\t" + this.age;
    
    }
    
    public boolean equals(Customer cus) {
    	return this.email.equals(cus.email);
    }

}
