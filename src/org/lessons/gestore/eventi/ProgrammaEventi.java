package org.lessons.gestore.eventi;

import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

	private String titolo;
	private List<Evento> eventi;

	public ProgrammaEventi(String titolo) {

		setTitolo(titolo);
		this.eventi = new ArrayList<Evento>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

}
