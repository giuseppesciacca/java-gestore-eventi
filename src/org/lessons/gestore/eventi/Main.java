package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
				System.out.println("\nAggiungere altro evento? Y/n");
				String continueToAdd = sc.nextLine();

				if (continueToAdd.toLowerCase().equals("n")) {
					break;
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		// RICERCA EVENTO PER DATA
		System.out.println("\nVuoi cercare un evento attraverso una data specifica? Y/n");
		String sceltaCercaEvento = sc.nextLine();
		if (sceltaCercaEvento.toLowerCase().equals("y")) {
			System.out.println("\nPer che data vuoi cercare un evento? [YYYY-mm-GG]");
			String dataDaCercareString = sc.nextLine();
			LocalDate dataDaCercare = LocalDate.parse(dataDaCercareString);

			List<Evento> newEventi = p1.getEventiConSpecificaData(dataDaCercare);

			for (Evento evento : newEventi) {
				System.out.println(evento.toString() + "\n");
			}
		}

		// STAMPA LISTA IN ORDINE DI DATA
		System.out.println(p1.printSortedListByDate());

		sc.close();
	}
}
