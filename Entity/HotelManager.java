package Entity;

public class HotelManager extends Users{

	public HotelManager(String name, String email, String password) {
		super(name, email, password);

	}
	
	public boolean equals(HotelManager hm) {
		return this.email.equals(hm.email);
	}
	
	public String toString() {
		return this.name + "\t" + this.email;
	}
    
}
