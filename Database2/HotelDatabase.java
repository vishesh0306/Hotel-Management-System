package Database2;
import java.util.ArrayList;
import java.util.HashMap;

import Entity.*;
import Entity.HotelManager;
import Entity.Room;

public class HotelDatabase {
    
    public static ArrayList< Customer > customers = new ArrayList<>();
    public static ArrayList< HotelManager > hotelManagers  = new ArrayList<>();
    
    public static Admin admin;
    
    static {
    	admin = new Admin("tushar", "tushar@capg", "tushar");
    }

    static{
        hotelManagers.add(new HotelManager("Nazeer", "nazeer@capg", "nazeer"));
    }
    
//    public static HashMap<Room, Boolean> rooms = new HashMap<Room, Boolean>();
    

    public static HashMap<Room, Boolean> singleRooms = new HashMap<Room, Boolean>();
    public static HashMap<Room, Boolean> doubleRooms = new HashMap<Room, Boolean>();
    public static HashMap<Room, Boolean> tripletRooms = new HashMap<Room, Boolean>();
    
static {
    	
    	singleRooms.put(new Room("101", "Single"), true);
    	singleRooms.put(new Room("102", "Single"), true);
    	singleRooms.put(new Room("103", "Single"), true);
    	singleRooms.put(new Room("104", "Single"), true);
    	singleRooms.put(new Room("105", "Single"), true);
    	doubleRooms.put(new Room("106", "Double"), true);
    	doubleRooms.put(new Room("107", "Double"), true);
    	doubleRooms.put(new Room("108", "Double"), true);
    	doubleRooms.put(new Room("109", "Double"), true);
    	doubleRooms.put(new Room("110", "Double"), true);
    	tripletRooms.put(new Room("111", "Triplet"), true);
    	tripletRooms.put(new Room("112", "Triplet"), true);
    	tripletRooms.put(new Room("113", "Triplet"), true);
    	tripletRooms.put(new Room("114", "Triplet"), true);
    	tripletRooms.put(new Room("115", "Triplet"), true);
    	
    }

	public static int singleRoomsCount = singleRooms.size();
	public static int doubleRoomsCount = doubleRooms.size();
	public static int tripletRoomsCount = tripletRooms.size();
    
    
    public ArrayList<Room> cart = new ArrayList<Room>();
    
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    public static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();
    
    
}
