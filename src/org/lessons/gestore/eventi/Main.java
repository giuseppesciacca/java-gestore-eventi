package org.lessons.gestore.eventi;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();

		LocalDate mineDate = LocalDate.parse("2022-01-04");

		try {
			Evento e1 = new Evento("Super concerto", today, 15);
			e1.prenota();
			e1.disdici();

			System.out.println(e1.toString());

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
