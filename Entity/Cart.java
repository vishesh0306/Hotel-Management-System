package Entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {

	public ArrayList<Room> customersCart = new ArrayList<>();
	
	
	public String toString() {
		String ans = "";
		int singleRoomCount = 0;
		int doubleRoomCount = 0;
		int tripletRoomCount = 0;
		
		double money = 0;
		
		Iterator<Room> itr = customersCart.iterator();
		while(itr.hasNext()) {
			Room room = itr.next();
			if(room.type.equals("single")) {
				singleRoomCount++;
				money += Room.singleRoomPrice;
			}
			else if(room.type.equals("double")) {
				doubleRoomCount++;
				money += Room.doubleRoomPrice;
			}
			else if(room.type.equals("triplet")) {
				tripletRoomCount++;
				money += Room.tripletRoomPrice;
			}
		}
		
		if(money == 0) {
			return "Cart is empty";
		}
		
		if(singleRoomCount > 0) {
			ans += "Single Room: " + singleRoomCount + "\n";
		}
		
		if(doubleRoomCount > 0) {
			ans += "double Room: " + doubleRoomCount + "\n";
		}
		if(tripletRoomCount > 0) {
			ans += "Triplet Room: " + tripletRoomCount + "\n";
		}
		ans += "Total Cost: " + money;
		
		return ans;
		
	}
}
