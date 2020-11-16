import java.util.Scanner;

	public class VictimContact extends AllPeople {

	        protected static VictimContact victimContactTable[] = new VictimContact[100];
	        protected static VictimContact HighDanger[] = new VictimContact[100];
	        protected static VictimContact LowDanger[] = new VictimContact[100];
	        private static int i=0;
	        private static int j=0;
	        private static int counter = 0;
	        protected String housemate;
	        protected String directContact;
	        protected String contactwhilesymptomsoccured;
	        protected String placeToMeet;
	        protected double Distance;
	        protected double Time;
	        protected String Worksector;
	        
	        public VictimContact(String name, String surname, String address, String email, int phonenumber, int AMKA, 
	        						String housemate, String directContact, String contactwhilesymptomsoccured,
	        						double Distance, String placeToMeet, double time, String Worksector) {
	                super(name, surname, address, email, phonenumber, AMKA);
	                this.housemate = housemate;
	                this.directContact = directContact;
	                this.contactwhilesymptomsoccured = contactwhilesymptomsoccured;
	                this.placeToMeet = placeToMeet;
	                this.Distance = Distance;
	                this.Time = time;
	                this.Worksector = Worksector;
	                if (counter == victimContactTable.length) {
	                        victimContactTable = (VictimContact[]) duplicateTable(victimContactTable.length, victimContactTable);
	                }
	                victimContactTable[counter] = this;
	                counter++;
	        }
	       
	        /*  public static void addVictimContact() {
                Scanner input = new Scanner(System.in);
                String name = input.next();
                String surname = input.next();
                String address = input.next();
                String email = input.next();
                int phonenumber = input.nextInt();
                int AMKA = input.nextInt();
                VictimContact possiblepatient = new VictimContact(name, surname, address, email, phonenumber, AMKA);
        } */
	        
	    public void highdanger() {
	    	
	    	System.out.println("The contact should abide by the following orders.");
	    	System.out.println("Firstly, staying indoors and have health supervision.");
	    	System.out.println("Secondly,.");
	    	System.out.println(".");
	    	System.out.println(".");
	    	
	    }

	    public void lowdanger() {
	    	
	    }
	    
        public void classifyContact(String Housemate, String DirectContact, String Contactwhilesymptomsoccured,
				double distance, String PlaceToMeet, double Time, String worksector) {

                if (Housemate == "yes" || DirectContact == "yes" || Contactwhilesymptomsoccured == "yes"
                		|| (distance <= 2 && Time > 15) || PlaceToMeet == "internal" || worksector == "healthdomain") {
                	 HighDanger[i] = victimContactTable[counter];
                     i++;
                     highdanger();
                } else {
                	 LowDanger[j] = victimContactTable[counter];   
                	 j++;
                	 lowdanger();
                }
                
        }

}










































	    	



	    	

	    

















