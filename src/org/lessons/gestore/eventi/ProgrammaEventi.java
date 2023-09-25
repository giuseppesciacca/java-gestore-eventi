package org.lessons.gestore.eventi;

import java.util.ArrayList;
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

	public String getEventiNelProgramma() {
		int nEventi = getEventi().size();
		return "Numero eventi nel programma: " + nEventi;
	}

	public void clearProgrammaEventi() {
		eventi.clear();
	}

}
