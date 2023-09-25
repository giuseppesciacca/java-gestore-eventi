package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate today = LocalDate.now();

//		LocalDate mineDatePast = LocalDate.parse("2022-01-04");
//		LocalDate mineDateFuture = LocalDate.parse("2023-12-04");

		try {
			Evento e1 = new Evento("Super Evento", today, 15);
			System.out.println(e1.toString());

			// PRENOTAZIONI
			System.out.println("\nQuante prenotazioni vuoi effettuare?");
			String nPrenotazioniString = sc.nextLine();
			int nPrenotazioni = Integer.parseInt(nPrenotazioniString);

			for (int i = 0; i < nPrenotazioni; i++) {
				e1.prenota();
			}

			System.out.println("\nNum posti prenotati: " + e1.getnPostiPrenotati());
			System.out.println("Num posti disponibili: " + (e1.getnPostiTot() - e1.getnPostiPrenotati()));

			// DISDETTE
			System.out.print("\nVuoi effettuare delle disdette? Y/n ");
			String sceltaDisdette = sc.nextLine();

			if (sceltaDisdette.toLowerCase().equals("y")) {
				System.out.print("\nQuante disdette vuoi effettuare?");
				String nDisdetteString = sc.nextLine();
				int nDisdette = Integer.parseInt(nDisdetteString);

				for (int i = 0; i < nDisdette; i++) {
					e1.disdici();
				}

				System.out.println("\nNum posti prenotati: " + e1.getnPostiPrenotati());
				System.out.println("Num posti disponibili: " + (e1.getnPostiTot() - e1.getnPostiPrenotati()));
			}

			sc.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		LocalTime t1 = LocalTime.now();
		String bs1 = "14.99";
		BigDecimal b1 = new BigDecimal(bs1);

		try {
			Concerto c1 = new Concerto("Super Evento", today, 15, t1, b1);

			System.out.println(c1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
