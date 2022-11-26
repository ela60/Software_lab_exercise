import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

	public static BufferedReader getBufferedReader () {
				try 
				{
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					return bufferedReader;
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				return null;
	}
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals("a")) {
			if (args.length != 1) {
				System.out.println("please enter valid arg");
			} else {
				System.out.println("Loading data ...");
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					String reaString = bufferedReader.readLine();
					String i[] = reaString.split(",");
					for (String j : i) {
						System.out.println(j);

					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			}
		} else if (args[0].equals("r")) {
			if (args.length != 1) {
				System.out.println("valid arg");
			} else {
				System.out.println("Loading data ...");
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					String readString = bufferedReader.readLine();
					String i[] = readString.split(",");
					int y = (int) ((double) Math.random() * (int) i.length);
					System.out.println(i[y]);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			}
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
				String inputString = args[0].substring(1);
				Date newdDate = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd = dateFormat.format(newdDate);
				bufferedWriter.write(", " + inputString + "\nList last updated on " + fd);
				bufferedWriter.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String r = bufferedReader.readLine();
				String i[] = r.split(",");
				boolean done = false;
				String inpuString = args[0].substring(1);
				for (int idx = 0; idx < i.length && !done; idx++) {
					if (i[idx].equals(inpuString)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String newdate = bufferedReader.readLine();
				char a[] = newdate.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char c : a) {
					if (c == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + a.length);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	}
}