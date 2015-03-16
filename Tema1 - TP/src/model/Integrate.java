package model;

public class Integrate extends UnaryOperation{

	@Override
	public Polinom compute(Polinom p) {
		Polinom pInt = new Polinom();
		
		for (Monom m : p.getLista()) {
			pInt.addMonom(new Monom(m.getCoeficient()/(m.getPutere() + 1), m.getPutere() + 1));
		}
		return pInt;
	}
	
}
