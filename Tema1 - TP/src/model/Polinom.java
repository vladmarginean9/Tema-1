package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
	private double grad = 0;
	private ArrayList<Monom> monoame;

	public Polinom() {
		monoame = new ArrayList<Monom>();
	}
	
	public void addMonom(Monom m1){
		boolean found = false;
		
		if (m1.getCoeficient() != 0) {
			if (m1.getPutere() > grad) {
				this.grad = m1.getPutere();
			}
			for (Monom m2 : this.monoame){
				if (m1.getPutere() == m2.getPutere()){
					m2.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
					found = true;
				}
				}
			if (found == false) {
				this.monoame.add(new Monom(m1.getCoeficient(), m1.getPutere()));
			}
			Collections.sort(this.monoame, new ComparatorPutere());
		}
	}
	
	public ArrayList<Monom> getLista(){
		return this.monoame;
	}
	
	public double getGrad(){
		return this.grad;
	}
	
	public Polinom clone(){
		Polinom clonat = new Polinom();
		for (Monom m : this.monoame) {
			clonat.addMonom(new Monom(m.getCoeficient(), m.getPutere()));
		}
		return clonat;
	}
	
	public String toString(){
		String printPolynomial = "";
		
		if (monoame.isEmpty()) {
			return "0";
		}
		else {
			for(Monom m: monoame){
				printPolynomial = printPolynomial + m.toString();
			}
			
			return printPolynomial;
		}
	}
}
