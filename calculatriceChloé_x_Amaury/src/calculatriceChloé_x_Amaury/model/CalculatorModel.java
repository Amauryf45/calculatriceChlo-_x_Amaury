package calculatriceChloé_x_Amaury.model;

import calculatriceChloé_x_Amaury.controler.CalculatorControler;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	

	private double accu = 0;
	Stack<Double> pileCalc = new Stack<Double>(); 

	
	@Override
	public Stack<Double> push() {
		//met le resultat sur la pileCalc
		if(getAccu() != 0) {
			pileCalc.push(getAccu());
			setAccu(0);
		}
		System.out.println("model pile : "+pileCalc);
		return pileCalc;
	}

	@Override
	public double pop() {
		// recupere le dernier element de la pile
		if(pileCalc.size()>0) {
			double out = pileCalc.pop();
			return out;
		}
		else{
			//ne devrait pas arriver
			return 0;
		}
	}

	@Override
	public Stack<Double> drop() {
		// supprime le dernier element de la pile
		if(pileCalc.size()>0) {
			pileCalc.pop();
		}
		return pileCalc;
	}


	
	@Override
	public Stack<Double> swap() {
		//échanger l’ordre des deux derniers opérandes
		if(pileCalc.size()>1) {
			double acc0 = getAccu();
			double acc1 = pop();
			double acc2 = pop();
			setAccu(acc1);
			push();
			setAccu(acc2);
			push();
			setAccu(acc0);
		}
		return(pileCalc);
	}

	@Override
	public Stack<Double> clear() {
		// reinitialise la pile et l'accumulateur
		pileCalc.clear();
		setAccu(0);
		return(pileCalc);
	}

	@Override
	public Stack<Double> add() {
		//addition
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()+pop());
		push();
		setAccu(0);
		return(pileCalc);
	}

	@Override
	public Stack<Double> substract() {
		//soustraction
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(pop()-getAccu());
		push();
		setAccu(0);
		return(pileCalc);
	}

	@Override
	public Stack<Double> multiply() {
		//multiplication
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()*pop());
		push();
		setAccu(0);
		return(pileCalc);
	}

	@Override
	public Stack<Double> divide() {
		//division
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(pop()/getAccu());
		push();
		setAccu(0);
		return(pileCalc);
	}

	@Override
	public Stack<Double> opposite() {
		// met un -
		if(getAccu()==0){
			setAccu(pop());
		}
		setAccu(-getAccu());
		return push();
	}

	public double getAccu() {
		return accu;
	}

	public void setAccu(double newAccu) {
		System.out.println("setAccu : "+newAccu);
		accu = newAccu;
	}

}
