package test;

public class StringAppl {
	public static void main(String[] args) {
		// Deklaration der Referenzvariablen + Instanzierung der Objekte
		String s1 = new String("ich bin ein String");
		String s2 = new String("ich bin ein String");
		String s3; // nur Deklaration der Refernzvariablen
		s3 = new String("auch ich bin ein String"); // Instanzierung des
													// Objektes

		if (s1 == s2) {
			System.out.println("s1 und s2 sind gleich");
		} else {
			System.out.println("s1 und s2 sind NICHT gleich");
		}
		// Ein wirklicher String-Vergleich
		if (s1.equals(s2)) {
			System.out.println("s1 und s2 sind gleich");
		} else {
			System.out.println("s1 und s2 sind NICHT gleich");
		}
		// Deklaration, als ob String ein primitiver Datentyp sei
		String s4 = "ich bin ein String";
		String s5 = "ich bin ein String";
		if (s4 == s5) {
			System.out.println("s4 und s5 sind gleich");
		} else {
			System.out.println("s4 und s5 sind NICHT gleich");
		}
		// Strings können mit dem '+'- oder dem '+='-Operator
		// aneinander gehängt werden
		String s6 = s1 + ", " + s3;
		s6 += "\nund ich auch!";
		// Und hier lassen wir s1 auch noch s6 referenzieren
		s1 = s6;
		System.out.println(s1);
	}
}
