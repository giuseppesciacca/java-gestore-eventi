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

}
