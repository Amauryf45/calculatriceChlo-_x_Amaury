package calculatriceChloé_x_Amaury.model;

import calculatriceChloé_x_Amaury.controler.CalculatorControler;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	
	private CalculatorControler controler;

	private double accu = 0;
	Stack<Double> pileCalc = new Stack<Double>(); 
	
	public CalculatorModel() {
        // Initialize the controler
		this.controler = new CalculatorControler();
    }

	
	@Override
	public void push() {
		//met le resultat sur la pileCalc
		if(getAccu() != 0) {
			pileCalc.push(getAccu());
			updateStack();
			setAccu(0);
		}
	}

	@Override
	public double pop() {
		// recupere le dernier element de la pile
		if(pileCalc.size()>0) {
			double out = pileCalc.pop();
			updateStack();
			return out;
		}
		else{
			//ne devrait pas arriver
			return 0;
		}
	}

	@Override
	public void drop() {
		// supprime le dernier element de la pile
		if(pileCalc.size()>0) {
			pileCalc.pop();
			updateStack();
		}
	}

	public void updateStack() {
		controler.change(pileCalc);
	}
	
	@Override
	public void swap() {
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
	}

	@Override
	public void clear() {
		// reinitialise la pile et l'accumulateur
		pileCalc.clear();	
		setAccu(0);
	}

	@Override
	public void add() {
		//addition
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()+pop());
		push();
		setAccu(0);
	}

	@Override
	public void substract() {
		//soustraction
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()-pop());
		push();
		setAccu(0);
	}

	@Override
	public void multiply() {
		//multiplication
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()*pop());
		push();
		setAccu(0);
	}

	@Override
	public void divide() {
		//division
		if(getAccu()==0) {
			setAccu(pop());
		}
		setAccu(getAccu()/pop());
		push();
		setAccu(0);
	}

	@Override
	public void opposite() {
		// met un -
		if(getAccu()==0){
			setAccu(pop());
		}
		setAccu(-getAccu());
		push();
		setAccu(0);
	}

	public double getAccu() {
		return accu;
	}

	public void setAccu(double accu) {
		this.accu = accu;
		controler.change(Double.toString(accu));
	}

}
