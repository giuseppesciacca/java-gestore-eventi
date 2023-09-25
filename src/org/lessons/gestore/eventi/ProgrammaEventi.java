package org.lessons.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {

	private String titolo;
	private List<Evento> eventi;

	public ProgrammaEventi(String titolo) {

		setTitolo(titolo);
		setEventi(new ArrayList<Evento>());
	}

	public String getTitolo() {
		return titolo;
	}

	private void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	private void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

	public void addEvento(Evento evento) {

		eventi.add(evento);
	}

	public List<Evento> getEventiConSpecificaData(LocalDate date) {

		List<Evento> newEventi = new ArrayList<Evento>();

		for (Evento evento : eventi) {
			LocalDate dataEvento = evento.getData();
			if (dataEvento.equals(date)) {
				newEventi.add(evento);
			}
		}

		return newEventi;

	}

	public String getEventiNelProgramma() {
		int nEventi = getEventi().size();
		return "Numero eventi nel programma: " + nEventi;
	}

	public void clearProgrammaEventi() {
		eventi.clear();
	}

	public String printSortedListByDate() {

		Collections.sort(eventi, new Comparator<Evento>() {
			@Override
			public int compare(Evento evento1, Evento evento2) {
				return evento1.getData().compareTo(evento2.getData());

			}
		});

		String listPrinted = "";

		for (Evento evento : eventi) {

			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = evento.getData().format(pattern);

			listPrinted += "- " + formattedDate + " - " + evento.getTitolo() + "\n";

		}

		return listPrinted;
	}

	public String mediaPrezzoConcerto() {
		List<Evento> concerti = new ArrayList<Evento>();

		float sum = 0f;

		for (Evento evento : eventi) {
			if (evento instanceof Concerto) {
				float priceInt = ((Concerto) evento).getPrezzo().floatValue();
				sum += priceInt;
				concerti.add(evento);
			}
		}

		float avgPriceConcertFloat = sum / concerti.size();

		return "Prezzo medio concerto: " + String.format("%.02f", avgPriceConcertFloat);
	}

	public String mediaPrezzoSpettacolo() {
		List<Evento> spettacoli = new ArrayList<Evento>();

		float sum = 0f;

		for (Evento evento : eventi) {
			if (evento instanceof Spettacolo) {
				float priceInt = ((Spettacolo) evento).getPrezzo().floatValue();
				sum += priceInt;
				spettacoli.add(evento);
			}
		}

		float avgPriceShowFloat = sum / spettacoli.size();

		return "Prezzo medio spettacolo: " + String.format("%.02f", avgPriceShowFloat);
	}

	public String mediaPrezzoEvento() {
		List<Evento> spettacoli = new ArrayList<Evento>();
		List<Evento> concerti = new ArrayList<Evento>();

		float sum = 0f;

		for (Evento evento : eventi) {
			if (evento instanceof Spettacolo) {
				float priceInt = ((Spettacolo) evento).getPrezzo().floatValue();
				sum += priceInt;
				spettacoli.add(evento);
			} else if (evento instanceof Spettacolo) {
				float priceInt = ((Spettacolo) evento).getPrezzo().floatValue();
				sum += priceInt;
				concerti.add(evento);
			}

		}

		float avgPriceShowFloat = sum / spettacoli.size();

		return "Prezzo medio evento: " + String.format("%.02f", avgPriceShowFloat);
	}

}
