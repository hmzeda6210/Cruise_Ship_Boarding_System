
import java.util.Scanner; 
import java.util.Arrays;
        
public class w1804929_arrays_only {

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
    
 
    /* Creating the array of Strings  */
   
    String [] Cabins = new String[]{"","","","","","","","","","","",""};
    
    
    while(true){
       
        /* Printing the menu */
        System.out.println("MENU\n");
        
   
        System.out.print("A.  Add a customer to a cabin.\n");
        System.out.print("V. View all cabins.\n");
        System.out.print("E. Display Empty cabins.\n");
        System.out.print("D. Delete customer from cabin.\n");
        System.out.print("F. Find cabin from customer name.\n");
        System.out.print("S. Store program data into file.\n");
        System.out.print("L. Load program data from file.\n");
        System.out.print("O. View passengersOrdered alphabetically by name.\n");
        System.out.println("Q. Exit program.\n");
        
        

        
        
        System.out.println("\nEnter Your Menu Choice: ");
        
        
        String option;
        Scanner in = new Scanner (System.in); 
        option = in.next();
        
        
        /* Analising all cases */
        if (option.equals("A")) {
            System.out.println("Enter first name: ");
            String name= in.next();
            System.out.println("Which cabin?");
            int cabinnum = in.nextInt();
        w1804929_arrays_only.addcustomer(Cabins,name,cabinnum); 
        }
        else if (option.equals("V")){
        w1804929_arrays_only.view(Cabins);
        }
        else if (option.equals("E")) {
        w1804929_arrays_only.emptycabins(Cabins);    
        }
        else if (option.equals("D")) {
            System.out.println("Which cabin you want to delete?: ");
            int del = in.nextInt();
        w1804929_arrays_only.deletecustomer(Cabins,del); 
        }
        else if (option.equals("F")) {
            System.out.println("Inser name");
            String find = in.next();
        w1804929_arrays_only.findcustomer(Cabins , find);    
        }
        else if (option.equals("Q")){
        w1804929_arrays_only.end();
            break;
                 
        }
        
 

    }        
    }
    
     /* Method for the voice menu A */
    public static void addcustomer(String[] cabins, String name, int index  ){
    
    cabins[index]= name;
  
    }
    
    /* Method for V */
    public static void view(String[] Cabins ){
        for (int i = 0; i<12; i++) {
            System.out.println("Cabin " + (i+1) + ": " + Cabins[i]);   
        }
    }
           
    /* Method for E */
    public static void emptycabins (String[] Cabins) {
    for (int i = 0; i<12; i++) {
        if (Cabins[i].equals("")== true )
        {
            System.out.println("Cabin " + (i+1) + " is empty");
        } 
            
    }
    }
    
    /* Method for D */
    public static void deletecustomer (String[] Cabins, int del) {
        
        if (Cabins[del].equals("")== true)
        {
            System.out.println("Cabin is alredy empty ");
            
        }
        else {
            Cabins[del]= "";
        
            System.out.println("Cabin has been deleted");
        }
        
        
    }
    
    /* Method for F */
    public static void findcustomer (String[] Cabins, String find) {
        boolean found = false;
        int i = 0;
        while  (!found && i<12 ){
        if (Cabins[i].equals(find) == true){
            found = true;
            System.out.println("Customer found at cabin " + (i + 1));
            
        }  
        i++;
        }
        if (!found) {
            System.out.println("Customer not found");
        }
    }
    
    /* Method for Q */
    public static void end() {
        System.out.println("\nPROGRAM IS ENDING");
    } 
    

}

