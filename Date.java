public class Date {
    int day;
    int month;
    int year;

    // Konstruktor parsed String direkt, schön und passend ins Datum-Objekt
    // einziges Format was akzeptiert wird: DD.JJ.YY
    public Date(String date)   {
        this.day = Integer.parseInt(date.substring(0,2)); // Trenne Tag von '14.02.20' und wandle in Zahl um
        this.month = Integer.parseInt(date.substring(3,5)); // s.O.
        this.year = Integer.parseInt(date.substring(6,8)); // s.O.
    }
    
    
    // methode liefert DDMM zurück für Moodle-Username
    public String getDDMM() { 
        String dd = ""; 
        String mm = "";
        if(this.day<10) {		// Achtung - es soll ja "02" und nicht "2" gespeichert werden
            dd="0"+this.day;
        } else {
            dd=this.day+"";
        }
        if(this.month<10) {
            mm="0"+this.month;
        } else {
            mm=this.month+"";
        } 
        return dd+mm; // verkette Tag mit Monat und gebe es zurück "0401"
    }

}
