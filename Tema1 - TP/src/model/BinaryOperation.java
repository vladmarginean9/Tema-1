package model;

public abstract class BinaryOperation implements Operation{
	
	public abstract Polinom compute(Polinom p1, Polinom p2);
	
	public Polinom compute2(Monom m1, Polinom p1){
		return null;
	}
	
	public Polinom getResult(int opNumber){
		return null;
	}
}
