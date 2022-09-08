class Administration	{
			
	public static void main(String[] args)	{	
			
			// Lege Schueler einmal an
			User u1 = new User("Felix","Balduin",new Date("14.02.89"));
			User u2 = new User("Moni","Thor",new Date("15.02.89"));
			User u3 = new User("Ägar","Keks",new Date("16.02.89"));
			User u4 = new User("Matt","Eagle",new Date("17.02.89"));
			
		    // Gebe einmal beispielhaft die Daten auf der Konsole aus...
		    u1.printData();
		    u2.printData();
		    u3.printData();
		    u4.printData();
		    
		    
		
	}
	
	
}
