import java.io.IOException;
import java.util.*;
public class MainDriver {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        
        while(flag) {
        
	        System.out.println("=================== Welcome to Java Hotel ==================");
	        System.out.println("Press 1: Visit Admin Portal \nPress 2: Visit Hotel Manager Portal \nPress 3: Visit User Portal \nPress 4. Exit");
	        	String choice = sc.next();
	
	            switch(choice) {
	  
	                case "1" -> AdminDriver.adminPortal(sc);
	                case "2" -> HotelManagerDriver.managerPortal(sc);
	                case "3" -> CustomerDriver.customerPortal(sc);
	                case "4" -> System.exit(0);
	                default -> System.out.println("Invalid choice...");
	            
	        }
	
	    }
    }
        

}