package model;

public class Multiply extends BinaryOperation{

	@Override
	public Polinom compute(Polinom p1, Polinom p2) {
		Polinom pMul = new Polinom();
		
		if ((p1.getLista().isEmpty()) || (p2.getLista().isEmpty())){
			return pMul;
		}
		else {
			for (Monom m1: p1.getLista()){
				for (Monom m2: p2.getLista()){
					pMul.addMonom(new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getPutere() + m2.getPutere()));
				}
			}
			return pMul;
		}
	}
	
	public Polinom compute2(Monom m1, Polinom p1){
		Polinom pMul = new Polinom();
		for (Monom m2: p1.getLista()){
			pMul.addMonom(new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getPutere() + m2.getPutere()));
		}
		return pMul;
	}
}