package model;

public class Derivate extends UnaryOperation{

	@Override
	public Polinom compute(Polinom p) {
		Polinom pDeriv = new Polinom();
		for (Monom m : p.getLista()){
			if (m.getPutere() != 0) {
				pDeriv.addMonom(new Monom((m.getPutere())*m.getCoeficient(), m.getPutere()-1));
			}
		}
		return pDeriv;
	}
}