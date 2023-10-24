package calculatriceChloé_x_Amaury;

import calculatriceChloé_x_Amaury.view.CalculatorGUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private CalculatorGUI calcGUI;
	
	@Override
	public void start(Stage primaryStage) {
		
		calcGUI = new CalculatorGUI();
		
		calcGUI.affiche(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
