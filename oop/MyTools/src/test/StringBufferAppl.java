package test;

public class StringBufferAppl {
	public static void main(String[] args) {
		String s = "";
		final int ITERATIONS = 10000;
		long timeStart = System.currentTimeMillis();
		System.out
				.println("Vor 1. Schleife, warten Sie, es kann eine weilen dauern...");
		for (int i = 0; i < ITERATIONS; i++) {
			s += i + " "; // es wird jedesmal ein neues String-Objekt
		}
		long timeStop = System.currentTimeMillis();
		long deltaTime1 = timeStop - timeStart;
		System.out.println("Die 1. Schleife dauerte = " + deltaTime1
				+ " Millisekunden");
		//
		StringBuffer sb = new StringBuffer();
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < ITERATIONS; i++) {
			sb.append(i + " "); // hier wird kein neues Objekt erzeugt!!
		}
		timeStop = System.currentTimeMillis();
		long deltaTime2 = timeStop - timeStart;
		System.out.println("Die 2. Scheife dauerte = " + deltaTime2
				+ " Millisekunden");
		System.out.println("Die 2. Schleife ist ca. "
				+ (deltaTime1 / deltaTime2) + " mal schnellerer!!");
	}
}
