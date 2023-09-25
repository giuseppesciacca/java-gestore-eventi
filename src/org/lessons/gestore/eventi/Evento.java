package org.lessons.gestore.eventi;

public class Evento {

	private String titolo;
	private String data;
	private int nPostiTot;
	private int nPostiPrenotati;

	public Evento(String titolo, String data, int nPostiTot) {
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	public void setnPostiTot(int nPostiTot) {
		this.nPostiTot = nPostiTot;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	public void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}

}
