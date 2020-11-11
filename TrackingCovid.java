package Ergasia;

import java.util.Scanner;

public class TrackingCovid19 {

private static int suspiciousCases = 0;
private static int allHealthyPeople = 10430106;
private static int afterHealthyPeople = 0;
private static int beforeHealthyPeople = 0;

public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    printMenu();
    int answer = input.nextInt();
    if (answer == 1) {
    	Patients.addPatient();
    } else if (answer == 2) {

    } else if (answer ==3) {

    } else if (answer == 4) {

    } else {

    }

}

public static void printMenu() {
    System.out.println("1. Add a patient.");
    System.out.println("2. Add a suspicious case.");
    System.out.println("3. Move someone from a patient to a healthy person, if he/she has get the virus over.");
    System.out.println("4. Say if a suspicious case is positive or negative to the test.");
    System.out.println("5. Show all the results until now.");
    System.out.print("Choose an option: ");
}
}
