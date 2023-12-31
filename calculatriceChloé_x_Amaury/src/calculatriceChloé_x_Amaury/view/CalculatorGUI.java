package calculatriceChloé_x_Amaury.view;

import calculatriceChloé_x_Amaury.controler.CalculatorControler;

import java.util.Stack;


import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 



public class CalculatorGUI implements CalculatorGUInterface {
	
	private CalculatorControler controler;
	
	public CalculatorGUI() {
        // Initialize the controler
		this.controler = new CalculatorControler();
    }

	@Override
	public void affiche(Stage primaryStage) {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Calculatrice JavaFX");

        // Créez une grille pour organiser les boutons de la calculatrice
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Créez un VBox pour afficher l'entrée et le résultat
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        // Créez des boutons pour les chiffres et les opérations
        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
        }

        Text accu = new Text("0");
        Text pile = new Text("");
        
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button swapButton = new Button("swap");
        Button oppositeButton = new Button("opposite");
        Button pointButton = new Button(".");
        Button pushButton = new Button("push");
        Button clearButton = new Button("C");

        
        // Ajoutez les boutons à la grille
        grid.add(vBox, 0, 0, 4, 1);
        for (int i = 1; i <= 9; i++) {
            int row = (i - 1) / 3;
            int col = (i - 1) % 3;
            grid.add(numberButtons[i], col, row + 1);
        }
        grid.add(numberButtons[0], 1, 4);
        grid.add(addButton, 3, 1);
        grid.add(subtractButton, 3, 2);
        grid.add(multiplyButton, 3, 3);
        grid.add(divideButton, 3, 4);
        grid.add(swapButton, 3, 5);
        grid.add(oppositeButton, 2, 5);
        grid.add(pointButton, 1, 5);
        grid.add(pushButton, 2, 4);
        grid.add(clearButton, 0, 4);
        
        grid.add(accu,3,0);
        grid.add(pile, 0, 0);

        // Gérez les événements des boutons
        for (int i = 0; i < 10; i++) {
            final int number = i;
            numberButtons[i].setOnAction(event -> handleNumberClick(number,accu));
        }
        addButton.setOnAction(event -> handleOperationClick("+",accu,pile));
        subtractButton.setOnAction(event -> handleOperationClick("-",accu,pile));
        multiplyButton.setOnAction(event -> handleOperationClick("*",accu,pile));
        divideButton.setOnAction(event -> handleOperationClick("/",accu,pile));
        swapButton.setOnAction(event -> handleOperationClick("swap",accu,pile));
        oppositeButton.setOnAction(event -> handleOperationClick("opposite",accu,pile));
        pointButton.setOnAction(event -> handleOperationClick(".",accu,pile));
        pushButton.setOnAction(event -> handlePushClick(accu,pile));
        clearButton.setOnAction(event -> handleClearClick(accu,pile));

        // Créez une scène
        Scene scene = new Scene(grid, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleNumberClick(int number, Text accu) {
    	if(accu.getText()=="0") {
    		accu.setText("");
    	}
		accu.setText(accu.getText()+ String.valueOf(number));
    }

    private void handleOperationClick(String operation, Text accu, Text pile) {
    	switch (operation) {
    		case "+":
    			controler.change(accu.getText()); //envoie accu au model
    			change(controler.add(),pile); // met a jour la pile selon le retour du model
    			accu.setText("0");
    			break;
    		case "-":
    			controler.change(accu.getText());
    			change(controler.substract(),pile);
    			accu.setText("0");
    			break;
    		case "*":
    			controler.change(accu.getText());
    			change(controler.multiply(),pile);
    			accu.setText("0");
    			break;
    		case "/":
    			controler.change(accu.getText());
    			change(controler.divide(),pile);
    			accu.setText("0");
    			break;
    		case "swap":
    			change(controler.swap(),pile);
    			break;
    		case "opposite":
    			controler.change(accu.getText());
    			change(controler.opposite(),pile);
    			accu.setText("0");
    			break;
    		case ".":
    			if(!accu.getText().contains(".")) {
    				accu.setText(accu.getText()+ ".");
    			}
    			break;
    	}
    }

    private void handlePushClick(Text accu, Text pile) {
		controler.change(accu.getText());
    	change(controler.push(),pile);
		accu.setText("0");
    }

    private void handleClearClick(Text accu, Text pile) {
        change(controler.clear(),pile);
		accu.setText("0");
    }
	

	@Override
	public void change(String accu) {
		// TODO Auto-generated method stub
	}

	@Override
	public void change(List<Double> stackData, Text pile) {
		// TODO Auto-generated method stub
		System.out.println(stackData);
		StringBuilder pileText = new StringBuilder();
		stackData.forEach(number->{
			pileText.append(Double.toString(number)+" | ");
		});
		System.out.println(pileText.toString());
		pile.setText(pileText.toString());
	}
	
	

}
