package calculatriceChloé_x_Amaury.model;

import java.util.Stack;

public interface CalculatorModelInterface {
	
	public Stack<Double> push();
	
	public double pop();
	
	public Stack<Double> drop();
	
	public Stack<Double> swap();
	
	public Stack<Double> clear();
	
	public Stack<Double> add();
	
	public Stack<Double> substract();
	
	public Stack<Double> multiply();
	
	public Stack<Double> divide();
	
	public Stack<Double> opposite();
}
