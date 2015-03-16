package model;

public class Add extends BinaryOperation {

	@Override
	public Polinom compute(Polinom p1, Polinom p2) {
		Polinom pSum = new Polinom();
		boolean inserat;
		
		for (Monom m2: p2.getLista()){
			inserat = false;
			for (Monom m1: p1.getLista()){
				if (m1.getPutere() == m2.getPutere()){
					inserat = true;
					if ((m1.getCoeficient() + m2.getCoeficient() != 0)) {
					pSum.addMonom(new Monom(m1.getCoeficient() + m2.getCoeficient(), m1.getPutere()));
					}
				}
			}
			if (inserat == false) {
				pSum.addMonom(new Monom(m2.getCoeficient(), m2.getPutere()));
			}
		}
		for (Monom m1: p1.getLista()){
			inserat = false;
			for (Monom m2: p2.getLista()){
				if (m2.getPutere() == m1.getPutere()){
					inserat = true;
				}
			}
			if (inserat == false) {
				pSum.addMonom(new Monom(m1.getCoeficient(), m1.getPutere()));
			}
		}
		return pSum;
	}
}
