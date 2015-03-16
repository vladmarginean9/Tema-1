package model;

import java.util.Iterator;

public class Division extends BinaryOperation{
	private Polinom cat; 
	private Polinom rest;

	public Polinom compute(Polinom p1, Polinom p2){
		Polinom inmultire = new Polinom();
		cat = new Polinom(); 
		rest = new Polinom();
		if (p2.getLista().isEmpty()) {
			return null;
		}
		else {
			if (p1.getGrad() < p2.getGrad()){
				this.rest = p1;
			}
			else {
				this.rest = p1.clone();
				Iterator<Monom> it = p2.getLista().iterator();
				Monom m = it.next();
				int indexCat = 0;
				while ( (this.rest.getGrad() >= p2.getGrad()) && (!(this.rest.getLista().isEmpty())) ) {
						this.cat.addMonom(new Monom(this.rest.getLista().get(0).getCoeficient()/m.getCoeficient(), this.rest.getLista().get(0).getPutere()-m.getPutere()));
						BinaryOperation mul = new Multiply();
						BinaryOperation sub = new Subtract();
						inmultire = mul.compute2(this.cat.getLista().get(indexCat), p2);
						this.rest = sub.compute(this.rest, inmultire);
						indexCat++;
				}
			}
			return this.cat;
		}
	}
	
	public Polinom getResult(int opNumber){
		if (opNumber == 0) {
			return this.cat;
		}
		else {
			return this.rest;
		}
	}
}
