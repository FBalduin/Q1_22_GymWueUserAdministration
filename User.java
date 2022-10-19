import java.time.LocalDate;    // Bibliothek für aktuelles Datum
import java.time.format.DateTimeFormatter;  // Bibliotek zur Formatierung des Datums

public class User  {
    
    String firstName;
    String lastName;
    String mail;
    String moodleUsername;
    char gender;
    Date dayOfBirth;
    
    // Default-Konstruktor wenn man schon mal das Objekt erstellen will, aber keine Werte hat
    public User() {
        this.firstName = "Max";
        this.lastName =  "Mustermann";
        this.dayOfBirth = new Date("01.01.00");
        this.gender = 'u';
        this.mail = "-";
        generateMoodleUsername(); // setze moodleUsername automatisiert - da er ja nur eigenen Regeln folgt.
    }
    
    // Konstruktor mit den drei wichtigsten Daten
    public User(String fn, String ln, Date dob) {
        this.firstName = fn;
        this.lastName = ln;
        this.dayOfBirth = dob;
        generateMoodleUsername(); // setze moodleUsername
        this.mail = "-";
        this.gender='u';

    }
    
    // Konstruktor mit allen Daten
    public User(String fn, String ln, Date dob, String mail, char gender) {
        this.firstName = fn;
        this.lastName = ln;
        this.dayOfBirth = dob;
        this.mail = mail;
        this.gender = gender;
        generateMoodleUsername(); // setze moodleUsername
    }
    
    
    // Methode um direkt alle Daten auf die Konsole zu schreiben
    public void printData()	{
		//todo - hier fehlt noch was
		System.out.println(this.lastName+", "+this.firstName+","+this.moodleUsername+"!");
		switch(this.gender){ 
        case 'm': 
            System.out.println("Gender: 'male' "); 
            break; 
        case 'f': 
            System.out.println("Gender: 'female' "); 
            break; 
        case 'd': 
            System.out.println("Gender: 'divers' "); 
            break; 
        case 'u': 
            System.out.println("Gender: 'unknown' "); 
            break;         } 
		System.out.println("Day of Birth: "+this.dayOfBirth.getDateAsString());
		System.out.println("Mail: "+this.mail);
		System.out.println("---------------------------------");
    } 
    
    private void generateMoodleUsername()	{
		
		// Wandle Umlaute um...
		
		// in kleinbuchstaben umwandeln...
		String first3 = this.firstName.toLowerCase();
		String last3 = this.lastName.toLowerCase();
		
		// so braucht man nur kleinbuchstaben abzufangen
		first3 = first3.replaceAll("ä","ae");
		first3 = first3.replaceAll("ü","ue");
		first3 = first3.replaceAll("ö","oe");
		first3 = first3.replaceAll("ß","ss");
		first3 = first3.replaceAll("é","e");
		first3 = first3.replaceAll("è","e");
		
	    last3 = last3.replaceAll("ä","ae");
		last3 = last3.replaceAll("ü","ue");
		last3 = last3.replaceAll("ö","oe");
		last3 = last3.replaceAll("ß","ss");
		last3 = last3.replaceAll("é","e");
		last3 = last3.replaceAll("è","e");
		
		// kürze nun auf 3 Buchstaben
		first3 = first3.substring(0,3);
		last3 = last3.substring(0,3);

        // Setze nun moodleUsername und verkette alle Werte passend
		this.moodleUsername = "100" + first3 + last3 + this.dayOfBirth.getDDMM();
	}
	
	public Date getUserAge()	{
		
		// get currentDate
		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		String currentDateS = todaysDate.format(formatter);
	
		Date currentDate = new Date(currentDateS);
		
		int y = -1;
		int m = -1;
		int d = -1;
		// Fange Fehler ab z.B. (20)20-(19)90 = -70 statt 30
		if (this.dayOfBirth.year > currentDate.year){
			y = (currentDate.year + 100)-this.dayOfBirth.year;
		}
		else
		{
			y = currentDate.year-this.dayOfBirth.year;
		}
		
		// Problem 1 - Geburtsmonat > aktueller Monat z.B. 11 - 9 --> (9 + 12) - 11 = 10 
		if (this.dayOfBirth.month > currentDate.month){
			y --; // Ziehe ein Jahr ab
			m = (currentDate.month+12) - this.dayOfBirth.month;
		}
		// z.B. 9 - 12 --> 12-9=3
		else
		{
			m = currentDate.month - this.dayOfBirth.month;
		}
		
		// Problem 2 - Geburtstag > aktueller Tag z.B. 11 - 9 --> (9 + 12) - 11 = 10 
		if (this.dayOfBirth.day > currentDate.day){
			m --; // Ziehe ein Jahr ab
			d = (currentDate.day+30) - this.dayOfBirth.day;
		}
		// z.B. 9 - 12 --> 12-9=3
		else
		{
			d = currentDate.day - this.dayOfBirth.day;
		}
		
		// Baue das tatsächliche Datum zusammen...
		
		// letzten Fehler abfangen - jeweils zweistelliges Datum
		
		String yS = "";
		String mS = "";
		String dS = "";
		
		if(y<10)	{
			yS = "0"+y;
		}
		else {
			yS = ""+y;
		}
		if(m<10)	{
			mS = "0"+m;
		}
		else {
			mS = ""+m;
		}
		if(d<10)	{
			dS = "0"+d;
		}
		else {
			dS = ""+d;
		}
		
		Date age = new Date(dS+"."+mS+"."+yS);
		return age;	 // return Datum 
	}
	
    public int getUserAgeInYears()	{
		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		String currentDateS = todaysDate.format(formatter);
	
		Date currentDate = new Date(currentDateS);
		
		int difYear = -1 ;
		
		// Fange Fehler ab z.B. (20)20-(19)90 = -70 statt 30
		if (this.dayOfBirth.year > currentDate.year){
			difYear = (currentDate.year + 100)-this.dayOfBirth.year;
		}
		else
		{
			difYear = currentDate.year-this.dayOfBirth.year;
		}
		// Problem 1 - Geburtsmonat > aktueller Monat
		if (this.dayOfBirth.month > currentDate.month){
			difYear --; // Ziehe ein Jahr ab		
		}
		// Problem 2 - Geburtsmonat = aktueller Monat, aber GebursTAG>aktueller Tag
		if ((this.dayOfBirth.month > currentDate.month) && this.dayOfBirth.day>currentDate.day){
			difYear --; // Ziehe ein Jahr ab		
		}		
		return difYear;
	} 

	// return ...
	// true, wenn Objekt-Nutzer selbst älter als Vergleich ist
	// false, wenn Objekt-Nutzer selbst älter als Vergleich ist
	public boolean isOlder(User c)	{	
		// Problem - was mache ich, wenn der Nutzer A 1989 geboren ist und Nutzer B 2020
		// if 89 < 20 --> false; aber eigentlich ist A älter
		// if 15 < 20 --> true; und eigentlich auch A älter	
		return false;
	}

	public Date compareUserAge(User c)	{
		// todo...hier gibt es noch was zu tun
		return null;
	}
}
