package Ergasia;

import java.util.Scanner;

public class Patients {
	
	 private Patients patient;
	 private static String name;
	 private static String surname;
	 private static int id;
	 
	 public Patients() {
	    	
	 }
	    
	 public Patients(String name, String surname, int id) {
		 this.patient = this;
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
		 Patients patient = new Patients(name, surname, id);
		 toStringPatient();
		 //���� ������ � ����� ������� ��� ����������
	 }
	    
	 public static void toStringPatient() {
		 System.out.printf("Name : %s \nSurname : %s \nid : %d \n", name, surname, id);   
	 }
	 
	 public static void tracking() {
		 // ������� �� �� ������������
	 }

}
