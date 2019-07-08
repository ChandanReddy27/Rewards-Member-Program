package lab6_part2;

/**
 * Profile.java
 * @author Chandan Reddy	 
 * @author Ethan Ly
 * CIS 36B
 * Lab 3
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends User {
	public static void main(String[] args) throws IOException {
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<RewardMember> rewardMember = new ArrayList<RewardMember>();
		File names = new File("names.txt");
		Scanner input = new Scanner(names);
		String name, phone, gender, email, password, memberNumber, rewardStatus;
		while (input.hasNextLine()) {
			// read in the information for each user
			name = input.nextLine();
			gender = input.nextLine();
			phone = input.nextLine();
			email = input.nextLine();
			password = input.nextLine();
			rewardStatus = input.nextLine();
			memberNumber = input.nextLine();
			// create a new User object
			// call setter methods to assign values to user object
			User objt = new User(name, gender, phone, email, password);
			RewardMember member = new RewardMember(name, gender, phone, email, password, memberNumber);

			// insert user object into users ArrayList
			users.add(objt);
			User.updateNumUsers();
			if (rewardStatus.equals("RM")) {
				rewardMember.add(member);
				RewardMember.updateNumRewardMembers();
			}
		}
		input.close();
		input = new Scanner(System.in);
		System.out.println("Welcome! \n\nWe are proudly serving " + getNumUsers() + " users and counting!\n");
		System.out.print("Enter your email address: ");
		email = input.nextLine();
		System.out.print("Enter your password: ");
		password = input.nextLine();
		// search
		bubbleSort(users);
		int index2 = linearSearch(email, password, rewardMember);
		int index1 = binarySearch(email, password, users);

		if (index1 == -1) {
			System.out.println("\nSorry! We don't have your account on file.");
			System.out.println("Let's create an account for you!");
			System.out.print("\nEnter your name: ");
			name = input.nextLine();
			System.out.print("Enter your gender: ");
			gender = input.nextLine();
			System.out.print("Enter your 10 digit phone number (no spaces or punctuation): ");
			phone = input.nextLine();
			User newAccount = new User(name, gender, phone, email, password);
			users.add(newAccount);
			User.updateNumUsers();
			System.out.println("\nThank you, " + name + "!");
			System.out.println("Your account has now been created.\n");
			System.out.println(users.get(users.size() - 1).toString());
			System.out.print("\nWould you like to join our Reward Member program and save 10% off all purchases today?\n" + "Enter yes or no:");
      String answer = input.nextLine();
      if(answer.equalsIgnoreCase("yes")) {
       	System.out.println("\nThank you! In exchange for becoming a valued member, "
        			+ "\nwe reserve the right to collect detailed information about you "
        			+ "\nand your shopping habits and sell this information to other companies.");
        String rewardNumber = RewardMember.generateRewardNumber();
      	System.out.println("\nHere is your new member number: " + RewardMember.generateRewardNumber());
        RewardMember member = new RewardMember(name, gender, phone, email, password, rewardNumber);
        rewardMember.add(member);
        RewardMember.updateNumRewardMembers();
        System.out.println("\nHave a great day!");
      } else {
        System.out.print("\nGoodbye!");
      }
			File outFile = new File("accounts.txt");
			PrintWriter out = new PrintWriter(outFile);
			for (int i = 0; i < users.size(); i++) {
				out.print(users.get(i));
				out.print("\n");
			}

			out.close();
		} else if (index1 > -1 && index2 > -1) {
			System.out.println("\nWelcome valued reward member, " + rewardMember.get(index2).getName() + "!\n");
			System.out.println("We have the following information on file for you:");
			System.out.print(rewardMember.get(index2).toString() + "\n");
			System.out.print("\nThank you for being one of our " + RewardMember.getNumRewardMembers() + " valued reward members.");
			System.out.print("\nTo show our appreciation, enjoy 10% off all shopping today!\n");
			System.out.print("\nHave a great day!");
		} else if(index1 > -1 && index2 == -1) {
      System.out.print("Hi, " + users.get(index1).getName() + "!");
      System.out.println("We have the following information on file for you:");
			System.out.print(users.get(index1).toString());
		}
		
		File outFile = new File("accounts.txt");
		PrintWriter out = new PrintWriter(outFile);
		for (int i = 0; i < users.size(); i++) {
			out.print(users.get(i));
			out.print("\n");
		}

		out.close();
	}

	/**
	 * Searches for a user whose email and password match those currently stored in
	 * the users ArrayList
	 * 
	 * @param email    the email that was input
	 * @param password the password input
	 * @param users    the ArrayList storing customers on file
	 * @return the location of the user or -1 if not found
	 */
	public static int linearSearch(String email, String password, ArrayList<RewardMember> rewardMember) {
		for (int i = 0; i < rewardMember.size(); i++) {
			if (rewardMember.get(i).getEmail().equals(email) && rewardMember.get(i).verifyPassword(password)) {
				return i;
			}
		}
		return -1;
	}

	public static void bubbleSort(ArrayList<User> user) {
		for (int i = 0; i <= user.size() - 2; i++) {
			for (int j = 0; j <= user.size() - 2 - i; j++) {
				if (user.get(j).getEmail().compareTo(user.get(j + 1).getEmail()) >= 1) {
					User temp = user.get(j);
					user.set(j, user.get(j + 1));
					user.set(j + 1, temp);
				}
			}
		}
	}

	public static int binarySearch(String email, String password, ArrayList<User> users) {
		int low = 0;
		int high = users.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (users.get(mid).getEmail().equals(email) && users.get(mid).verifyPassword(password)) {
				return mid;
			} else if (users.get(mid).getEmail().compareTo(email) > 0 && users.get(mid).verifyPassword(password)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;

	}

}