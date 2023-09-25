package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int nPostiTot, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, nPostiTot);

		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getDateAndHourFormatted() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = getData().format(pattern);

		DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm", Locale.ITALY);
		String oraFormattata = ora.format(f);

		return "Concerto in data: " + formattedDate + " alle ore: " + oraFormattata;
	}

	public String getPriceFormatted() {

		return "Prezzo: " + String.format("%.02f", prezzo) + " euro";
	}

	@Override
	public String toString() {

		return getDateAndHourFormatted() + "\nTitolo: " + getTitolo() + "\n" + getPriceFormatted();
	}

}
