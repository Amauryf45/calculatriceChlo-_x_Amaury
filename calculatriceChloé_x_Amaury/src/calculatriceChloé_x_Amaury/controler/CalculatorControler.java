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
	public String change(String accu) {
		// TODO Auto-generated method stub
		if(accu == "") {
			model.setAccu(0);
			return("0");
		}
		else if(accu==".") {
			String oldAccu = Double.toString(model.getAccu());
			if(oldAccu.endsWith(".0")) { //si le nombre en place est un entier 
				model.setAccu(Double.parseDouble(oldAccu));
				return(oldAccu.substring(0,oldAccu.length()-1));
			}
			else {
				return(oldAccu);
			}
		}
		else {
			if(Double.toString(model.getAccu()).endsWith(".0")) {
				//Si accu était entier
				String oldAccu = Double.toString(model.getAccu());
				String newAccu = oldAccu.substring(0, oldAccu.length() - 2)+accu; //retirer ".0"
				model.setAccu(Double.parseDouble(newAccu));
				if(newAccu.startsWith("0")) {
					// retirer le 0 devant un nombre 
					newAccu = newAccu.substring(1, newAccu.length());
				}
				return(newAccu);
			}
			else {
				model.setAccu(Double.parseDouble(Double.toString(model.getAccu())+accu));
				return(Double.toString(model.getAccu()));
			}
			}
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

	public void point() {
		// TODO Auto-generated method stub
		
	}

}
