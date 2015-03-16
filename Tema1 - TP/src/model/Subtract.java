package model;

public class Subtract extends BinaryOperation{

	@Override
	public Polinom compute(Polinom p1, Polinom p2) {
		Polinom pSub = new Polinom();
		boolean inserat;
		
		for (Monom m1: p2.getLista()){
			inserat = false;
			for (Monom m2: p1.getLista()){
				if (m1.getPutere() == m2.getPutere()){
					inserat = true;
					if (m2.getCoeficient() - m1.getCoeficient() != 0) {
					pSub.addMonom(new Monom(m2.getCoeficient() - m1.getCoeficient(), m2.getPutere()));
					}
				}
			}
			if (inserat == false) {
				pSub.addMonom(new Monom(-m1.getCoeficient(), m1.getPutere()));
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
				pSub.addMonom(new Monom(m1.getCoeficient(), m1.getPutere()));
			}
		}
		return pSub;
	}
	
}
