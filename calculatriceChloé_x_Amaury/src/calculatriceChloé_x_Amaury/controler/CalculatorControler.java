package calculatriceChloé_x_Amaury.controler;

import calculatriceChloé_x_Amaury.model.CalculatorModel;

import java.util.List;

public class CalculatorControler implements CalculatorControlerInterface {
	
	private CalculatorModel model;
	
    public CalculatorControler() {
        // Initialize the model in the constructor
        this.model = new CalculatorModel();
    }

	@Override
	public void change(String accu) {
		// TODO Auto-generated method stub
		model.setAccu(Double.parseDouble(Double.toString(model.getAccu())+accu));
	}

	@Override
	public void change(List<Double> stackDatea) {
		// TODO Auto-generated method stub
		
		//afficher la pile dans la calculette

	}
	
	@Override
	public void push() {
		// TODO Auto-generated method stub
		change(model.push());
		change("");
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		change(model.swap());
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		change(model.clear());
		change("");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		change(model.add());
		change("");
	}

	@Override
	public void substract() {
		// TODO Auto-generated method stub
		change(model.substract());
		change("");
	}

	@Override
	public void multiply() {
		// TODO Auto-generated method stub
		change(model.multiply());
		change("");
	}

	@Override
	public void divide() {
		// TODO Auto-generated method stub
		change(model.divide());
		change("");
	}

	@Override
	public void opposite() {
		// TODO Auto-generated method stub
		change(model.opposite());
		change("");
	}

}
