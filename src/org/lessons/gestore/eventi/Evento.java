package org.lessons.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
			throw new Exception("La data non puo' essere di un giorno precedente ad oggi.");
		}

		this.data = data;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	private void setnPostiTot(int nPostiTot) throws Exception {

		if (nPostiTot < 0) {
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

	public void prenota() throws Exception {
		nPostiPrenotati++;
		LocalDate today = LocalDate.now();

		if (nPostiPrenotati >= getnPostiTot()) {
			throw new Exception("SOLD OUT, non e' possibile prenotare ulteriori posti.");
		} else if (data.isBefore(today)) {
			throw new Exception("Non e' possibile prenotare l'evento in quanto è stato gia' tenuto in data " + data
					+ ". Prenota un altro evento.");
		}
	}

	public void disdici() throws Exception {
		nPostiPrenotati--;
		LocalDate today = LocalDate.now();

		if (nPostiPrenotati < 0) {
			throw new Exception("Impossibile applicare la disdetta. Non ci sono posti prenotati per questo evento.");
		} else if (data.isBefore(today)) {
			throw new Exception("Non è possibile disdire l'evento in quanto è stato già tenuto in data " + data + ".");
		}
	}

	@Override
	public String toString() {

		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = data.format(pattern);

		return "Titolo: " + titolo + "\nData: " + formattedDate;
	}
}
