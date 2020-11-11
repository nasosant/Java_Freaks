

import java.util.Scanner;

public class AllPeople {
	
	 private AllPeople person;
	 private static String name;
	 private static String surname;
	 private static int id;
	 
	 public AllPeople() {
	    	
	 }
	    
	 public AllPeople(String name, String surname, int id) {
		 this.person = this;
		 this.name = name;
		 this.surname = surname;
		 this.id = id;
	 }
	 
	 public static void addPatient() {
		 Scanner input = new Scanner(System.in);
		 System.out.print("Enter the Name of the patient: ");
		 String name = input.next();
		 System.out.print("Enter the surname: ");
		 String surname = input.next();
		 System.out.print("Enter the id number: ");
		 int id = input.nextInt();
		 input.nextLine();
		 AllPeople patient = new AllPeople(name, surname, id);
		 toStringAllPeople();
		 //���� ������ � ����� ������� ��� ����������
	 }
	    
	 public static void toStringAllPeople() {
		 System.out.printf("Name : %s \nSurname : %s \nid : %d \n", name, surname, id);   
	 }
	 
	 public static void tracking() {
		 // ������� �� �� ������������
	 }

}
