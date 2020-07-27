package scot.davidhunter.messenger.ui;

import java.util.Scanner;

public class UserInterface {

	private int ID;
	
	public static final int MAIN_MENU_ID = 1;
	public static final int CREATE_MESSAGE_BOX_ID = 2;
	public static final int READ_MESSAGE_BOX_ID = 3;
	public static final int READ_MESSAGE_ID = 4;
	public static final int SEND_MESSAGE_ID = 5;
	public static final int EXIT_ID = 0;
	
	private Scanner scanner;
	
	public UserInterface(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void display(int ID) {
		switch(ID) {
			case MAIN_MENU_ID:
				System.out.println("--- MAIN MENU ---");
				System.out.println();
				break;
			default:
				System.out.println("=============");
				System.out.println("--- ERROR ---");
				System.out.println("=============");
				System.out.println();
				break;
		}
	}
	
}
