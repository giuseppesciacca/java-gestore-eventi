package org.lessons.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
}
