package calculatriceChloé_x_Amaury.controler;

import java.util.List;

public interface CalculatorControlerInterface {
	public void change(String accu);
	
	public void change(List<Double> stackDatea);
	
	public void swap();
	
	public void clear();
	
	public void add();
	
	public void substract();
	
	public void multiply();
	
	public void divide();
	
	public void opposite();
}
