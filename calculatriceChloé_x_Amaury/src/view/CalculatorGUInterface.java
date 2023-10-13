package view;

import java.util.List;

public interface CalculatorGUInterface {
	public void affiche();
	
	public void change(String accu);
	
	public void change(List<Double> stackData);
}
