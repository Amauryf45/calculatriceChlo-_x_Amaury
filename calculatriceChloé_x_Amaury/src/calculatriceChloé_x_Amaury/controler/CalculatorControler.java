package calculatriceChloé_x_Amaury.controler;

import calculatriceChloé_x_Amaury.model.CalculatorModel;

import java.util.List;

public class CalculatorControler implements CalculatorControlerInterface {
	
	private CalculatorModel model;
	


	@Override
	public void change(String accu) {
		// TODO Auto-generated method stub
		model.setAccu(Double.parseDouble(Double.toString(model.getAccu())+accu));
	}

	@Override
	public void change(List<Double> stackDatea) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void push() {
		// TODO Auto-generated method stub
		model.push();
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		model.swap();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		model.clear();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		model.add();
	}

	@Override
	public void substract() {
		// TODO Auto-generated method stub
		model.substract();
	}

	@Override
	public void multiply() {
		// TODO Auto-generated method stub
		model.multiply();
	}

	@Override
	public void divide() {
		// TODO Auto-generated method stub
		model.divide();
	}

	@Override
	public void opposite() {
		// TODO Auto-generated method stub
		model.opposite();
	}

}
