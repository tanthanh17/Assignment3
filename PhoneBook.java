package Assessment3;

import java.io.*;
import java.util.*;

public class PhoneBook {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		boolean conti = true;

		// Creating ArrayList and setting the file paths
		ArrayList<Record> records = new ArrayList<>();
		ArrayList<String> result = new ArrayList<String>();
		String recordsFile = "C:\\Users\\Admin\\OneDrive\\Máy tính\\Assessment3\\PhoneBookFile.txt";
		String resultFile = "C:\\Users\\Admin\\OneDrive\\Máy tính\\Assessment3\\Result.txt";

		// Object creation and loading records from file
		PhonebookManager phonebookManager = new PhonebookManager();
		phonebookManager.loadRecords(recordsFile, records);

		while (conti) {
			phonebookManager.loadQuery(records, result);
			phonebookManager.updateRecordFile(recordsFile, records);

			System.out.println("------------Do you want to continue? y/n---------------" + "\n");
			String co = sc.nextLine();
			if (co.equalsIgnoreCase("y")) {
				conti = true;
			} else {
				phonebookManager.updateResultFile(resultFile, result);
				System.out.println("----------------Record saved in Result.txt!---------------");
				conti = false;
			}
		}
	}
}
