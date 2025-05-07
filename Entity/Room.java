package Entity;

import java.util.Objects;

public class Room {

	public String roomNo;
	public double price;
	public String type;
	
	public static double singleRoomPrice = 1000;
	public static double doubleRoomPrice = 1800;
	public static double tripletRoomPrice = 2500;
	
	public Room(String roomNo, String type){
		this.roomNo = roomNo;
		this.type = type.toLowerCase();
		
		if(this.type.equals("Single".toLowerCase())) {
			this.price = singleRoomPrice;
		}
		else if(this.type.equals("Double".toLowerCase())) {
			this.price = doubleRoomPrice;
		}
		else if(this.type.equals("Triplet".toLowerCase())) {
			this.price = tripletRoomPrice;
		}
	}
	
	public String toString() {
		return this.roomNo + "\t" + this.type + "\t" + this.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, roomNo, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(roomNo, other.roomNo) && Objects.equals(type, other.type);
	}


	
	
	
//	public boolean equals(Room r) {
//		return this.roomNo.equals(r.roomNo);
//	}
//	
//	public int hashCode() {
//        return Objects.hash(this.roomNo);
//    }
	
}
