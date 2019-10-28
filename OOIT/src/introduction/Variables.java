package introduction;

public class Variables {

	public static void main(String[] args) {
		// Varijable 
		double firstNumber;
		firstNumber = 1;
		
		double secondNumber = 5;
		
		int result = (int)(firstNumber/secondNumber);
		System.out.println(result);
		
		double resultDouble = firstNumber/secondNumber;
		System.out.println(resultDouble);

		boolean alwaysTrue = true;
		boolean alwaysFalse = false;
		System.out.println(alwaysTrue && alwaysFalse);
		System.out.println(alwaysTrue || alwaysFalse);
		
		 // Konkatenacija stringova
		 String firstName = "Petar";
		 String lastName = "Petrovic";
		 
		 // char space = ' ';
		 // System.out.println(firstName + space + lastName);
		 System.out.println("Student je: " + firstName + ' ' + lastName);
		 
		 // Koriscenje IF uslova
		 if (firstNumber > 0) {
			 System.out.println("Broj je pozitivan");
		 }
		 else if (firstNumber < 0) {
			 System.out.println("Broj je negativan");
		 }
		 else {
			 System.out.println("Broj je 0");
		 }
		 
		 // WHILE petlja
		 int i = 1;
		 System.out.println("While petlja - od 1 do 10");
		 while (i <= 10) {
			 System.out.println(i);
			 i++; //i = i + 1
		 }
		 
		 // FOR petlja
		 System.out.println("For petlja - od 1 do 10");
		 for (i = 1; i <= 10; i++) {
			 System.out.println(i);
		 }
		 
		 // DO-WHILE petlja
		 i = 1;
		 System.out.println("Do-while petlja - od 1 do 10");
		 do {
			System.out.println(i);
			i++;
		 } while (i <= 10);
		 
		 // ZADATAK: koriscenjem petlji izracunati faktorijel nekog broja
		 System.out.println("Faktorijel nekog broja pomocu WHILE petlje:");
		 int fakt = 5;
		 int sum = 1;
		 while (fakt > 0) {
			 sum = sum * fakt;
			 fakt--;
		 }
		 System.out.println(sum);
		 
		 System.out.println("Faktorijel nekog broja pomocu DO-WHILE petlje:");
		 fakt = 5;
		 sum = 1;
		 do {
			 sum = sum * fakt;
			 fakt--;
		 } while (fakt > 0);
		 System.out.println(sum);
		 
		 System.out.println("Faktorijel nekog broja pomocu FOR petlje:");
		 for (fakt = 5, sum = 1; fakt > 0; fakt--) {
			 sum = sum * fakt;
		 }
		 System.out.println(sum);
	}

}
