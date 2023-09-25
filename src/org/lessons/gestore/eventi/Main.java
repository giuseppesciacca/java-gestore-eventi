package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		LocalDate today = LocalDate.now();
//		LocalDate mineDatePast = LocalDate.parse("2022-01-04");
//		LocalDate mineDateFuture = LocalDate.parse("2023-12-04");

		ProgrammaEventi p1 = new ProgrammaEventi("Eventi");

		while (true) {
			try {
				System.out.print("Inserisci il titolo del concerto: ");
				String titoloEvento = sc.nextLine();

				System.out.print("\nInserisci la data del concerto, in [YYYY-MM-GG]: ");
				String dateString = sc.nextLine();
				LocalDate date = LocalDate.parse(dateString);

				System.out.print("\nInserisci i posti totali: ");
				String nPostiTotString = sc.nextLine();
				int nPostiTot = Integer.parseInt(nPostiTotString);

				System.out.print("\nInserisci l'ora del concerto, in [HH:MM]: ");
				String hourString = sc.nextLine();
				LocalTime hour = LocalTime.parse(hourString);

				System.out.print("\nInserisci il prezzo del biglietto: ");
				String prezzoString = sc.nextLine();
				BigDecimal prezzo = new BigDecimal(prezzoString);

				Concerto c1 = new Concerto(titoloEvento, date, nPostiTot, hour, prezzo);

				// ADD EVENTO TO PROGRAMMAEVENTI
				p1.addEvento(c1);
				p1.getEventiNelProgramma();
				System.out.println(p1.getEventiNelProgramma());

				// PRENOTAZIONI
				System.out.println("\nQuante prenotazioni vuoi effettuare?");
				String nPrenotazioniString = sc.nextLine();
				int nPrenotazioni = Integer.parseInt(nPrenotazioniString);

				for (int i = 0; i < nPrenotazioni; i++) {
					c1.prenota();
				}

				System.out.println("\nNum posti prenotati: " + c1.getnPostiPrenotati());
				System.out.println("Num posti disponibili: " + (c1.getnPostiTot() - c1.getnPostiPrenotati()));

				// DISDETTE
				System.out.print("\nVuoi effettuare delle disdette? Y/n ");
				String sceltaDisdette = sc.nextLine();

				if (sceltaDisdette.toLowerCase().equals("y")) {
					System.out.print("\nQuante disdette vuoi effettuare?");
					String nDisdetteString = sc.nextLine();
					int nDisdette = Integer.parseInt(nDisdetteString);

					for (int i = 0; i < nDisdette; i++) {
						c1.disdici();
					}

					System.out.println("\nNum posti prenotati: " + c1.getnPostiPrenotati());
					System.out.println("Num posti disponibili: " + (c1.getnPostiTot() - c1.getnPostiPrenotati()));
				}

				// CONTINUE TO ADD EVENTS?
				System.out.println("Aggiungere altro evento? Y/n");
				String continueToAdd = sc.nextLine();

				if (continueToAdd.toLowerCase().equals("n")) {
					sc.close();
					break;
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
