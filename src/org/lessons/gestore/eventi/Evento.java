package org.lessons.gestore.eventi;

import java.time.LocalDate;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int nPostiTot;
	private int nPostiPrenotati;

	public Evento(String titolo, LocalDate data, int nPostiTot) throws Exception {
		setTitolo(titolo);
		setData(data);
		setnPostiTot(nPostiTot);
		setnPostiPrenotati(0);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {

		LocalDate today = LocalDate.now();

		if (data.isBefore(today)) {
			throw new Exception("La data non puo' essere in un giorno precedente ad oggi.");
		}

		this.data = data;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	private void setnPostiTot(int nPostiTot) throws Exception {

		if (nPostiTot > 0) {
			throw new Exception("Posti totali devono essere maggiori di zero.");
		}

		this.nPostiTot = nPostiTot;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	private void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}
}
