package calculatriceChloé_x_Amaury.view;


import java.util.List;

import javafx.stage.Stage;

public interface CalculatorGUInterface {
	public void affiche(Stage primaryStage);
	
	public void change(String accu);
	
	public void change(List<Double> stackData);
}
