
import java.io.*;
import java.util.*;
//Imported necessary packages

public class Prog {

	public static void main(String[] args) {
		BufferedReader reader; //Taken reader for file access
		
		Scanner yearObj = new Scanner(System.in); //yearObj for taking year from user
		Scanner genderObj = new Scanner(System.in); //genderObj for taking gender from user
		Scanner nameObj = new Scanner(System.in); //nameObj for taking name from user
		
		String[] splitted; //string array for storing splitted items from particular line
		
		boolean found = false; //if record found
		String rank = ""; //at which position record found
		try {
			
			System.out.println("Enter the year: ");
			String year = yearObj.nextLine(); //taking year and store in year variable
			
			System.out.println("Enter the gender: ");
			String genderString = genderObj.nextLine(); //taking gender and store in genderString variable
			char gender=genderString.charAt(0);  //converting genderString to character
			
			System.out.println("Enter the name: ");
			String name = nameObj.nextLine(); //taking name in name variable

			String yearPath = "babynamesranking2001_2010/babynamesranking" + year + ".txt"; //creating file name based on entered year
			
			reader = new BufferedReader(new FileReader(yearPath)); //opened reader and passed file name for accessing file
			
			if(gender == 'M'||gender == 'F') { //checking weather the user has enter Male or Female
				
				String line = reader.readLine(); //Reading first line of file
				
				while (line != null) { //running while loop until file end  
					
					splitted = line.split("[\\s\t]+"); //Removes tabs and spaces from line
					// \\s: This represents any whitespace character, including spaces, tabs, and line breaks.
					// \t: This represents a tab character.
					//+: This is a quantifier that matches one or more occurrences of the preceding element (whitespace characters in this case).
					
					if(gender=='M') { // if gender is male
						if(splitted[1].equals(name)) { //entered name matches with particular name
							found = true; //telling that records found
							rank = splitted[0]; //storing rank
						}
					}else { //when gender is female
						if(splitted[3].equals(name)) { //entered name matches with particular name
							found = true; //telling that records found
							rank = splitted[0];	//storing rank
						}
					}

					line = reader.readLine(); //reading next line from file
				}

				if(found) { //if any record match
					System.out.println(name+" is ranked #"+rank+" in year "+year);
				}
				else { //Not found any record
					System.out.println("The name "+ name +" is not ranked in year "+ year);
				}
			}else { // Gender is not male or female
				System.out.println("Gender should be in M or F");
				return;
			}
				reader.close(); // file reader closed
			
		} catch (IOException e) { //if year is not from 2001-2010
			System.out.println("Entered Year is not Correct");
		}
	}
}
