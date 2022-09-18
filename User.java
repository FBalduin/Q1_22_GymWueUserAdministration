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
	
   
}
