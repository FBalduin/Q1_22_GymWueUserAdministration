import java.io.File; // zum Umgang mit Dateien
import java.io.FileNotFoundException; // zum Umgang mit Datei-Fehlern
import java.util.Scanner;

class Administration	{
	
	// Array mit 1000 Fächern um User zu speichern
	public static User[] allGymWueUser = new User[1000];
	// todo...
	//public static Students[] allGymWueUser = new User[1000];
	//public static Teacher[] allGymWueUser = new User[1000];

	// Startmethode
	public static void main(String[] args)	{		
			// Lege Schueler einmal an
			User u1 = new User("Felix","Balduin",new Date("14.02.89"));
			User u2 = new User("Moni","Thor",new Date("15.02.89"));
			User u3 = new User("Ägar","Keks",new Date("16.02.89"));
			User u4 = new User("Matt","Eagle",new Date("17.12.89"));
			
		    // Gebe einmal beispielhaft die Daten auf der Konsole aus...
		    u1.printData();
		    u2.printData();
		    u3.printData();
		    u4.printData();
		    
		    // Teste die Methode getUserAge und rufe am Rückgabewert direkt die Methode zur sauberen Stringkonvertierung auf.
		    System.out.println(u4.getUserAge().getDateAsString());
		    
		    // importiere alle User ins Array
		    System.out.println("");
		    System.out.println("Importiere User...");
		    importCSV2User("userdata.csv");
		    
		    // gebe Testweise einfach mal einen zufälligen Nutzer aus...
		    System.out.println("");
		    System.out.println("Gebe zufälligen User aus...");
		    allGymWueUser[42].printData();
	}
	
	// importiert alle User aus einer CSV-Datei in unser UserArray allGymWueUser
	public static void importCSV2User(String filepath)	{
		int i = 0; // lege für spätere Zwecke zählvariable i an.
		// try - catch-Block notwendig zum Abfangen von Fehlern, wenn z.B. die Datei nicht da ist.
		try
		{
			// lese Zeilenweise CSV-Datei ein
			Scanner scanner = new Scanner(new File(filepath));
			Scanner dataScanner = null; //Objekt zum lesen eines Datensatzes
			// solange es einen nächste Zeile mit Text gibt, führe Schleife aus
			while(scanner.hasNext()==true)	{
				dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
				dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Datenfeldern 
				// lese lastname ein
				String ln = dataScanner.next();
				// lese lastname ein
				String fn = dataScanner.next();
				// lese dayOfBirth ein
				String dob= dataScanner.next();
				// lese mail ein	- gibt es aber nicht			
				// String ml = dataScanner.next();
				// lese geschlecht ein - auch noch nicht vorhanden
				// String ge = dataScanner.next();
				
				User temp = new User(fn,ln,new Date(dob));
				
				allGymWueUser[i] = temp;	// füge Temp in UserArray ein
				allGymWueUser[i].printData(); // gebe einmal testweise die Daten aus
				i++; // erhöhe i um ins nächste Regal zu kommen
			}	// nächste Zeile, wenn es eine gibt.
			scanner.close(); // schließe Scanner
		}
		// Fehlerbehandlung - muss uns nicht beschäftigen - gibt eine Fehlermeldung aus
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public static User getOldestUser()	{
		// todo: hier ist noch was zu tun...
		return null; 
	}
	
	public static User addUserViaConsole()	{
		User u1 = new User();
		int okay = 0; // Prüfvariable ob alle Eingaben okay sind oder nochmal eingeben werden müssen.
		// schleife zur Eingabe
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Gebe den Nachnamen ein");
			String lastName = sc.nextLine();
			System.out.println("Gebe den Vornamen ein");
			String firstName = sc.nextLine();
			System.out.println("Gebe deine E-Mail Addresse ein");
			String mail = sc.nextLine();
			System.out.println("Gebe dein geburtsdatum ein, in folgendem Format: DD.MM.YY");
			String dayOfBirth = sc.nextLine();
			
			System.out.println("Gebe dein geschlecht an, ´m´für männlich, `w`für weiblich, `d`für divers");
			String g = sc.nextLine();
			char gender = g.charAt(0);
			u1.lastName=lastName;
			u1.dayOfBirth = new Date(dayOfBirth);
			System.out.println("Überprüfe ob alles richtig ist");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Nachname :");
			System.out.println(lastName);
			System.out.println(" ");
			System.out.println("Vorname:");
			System.out.println(" ");
			System.out.println(firstName);
			System.out.println(" ");
			System.out.println("E-Mail Addresse:");
			System.out.println(" ");
			System.out.println(mail);
			System.out.println(" ");
			System.out.println("Geburtstag:");
			System.out.println(" ");
			System.out.println(dayOfBirth);
			System.out.println(" ");
			System.out.println("Gender:");
			System.out.println(" ");
			System.out.println(gender);
			
			System.out.println("War alles soweit okay oder nochmal starten");
			System.out.println("1=okay; 0 = nochmal starten");
			okay = sc.nextInt();
			
		} while (okay!=-1);
		
		return u1;
	}

	public static void printUserArray(User[] printUserArray)	{
		// todo...
		// gehe mit einer Schleife einmal durch das Array und 
		// gebe von jedem User die entsprechenden Daten aus...
	}
}
