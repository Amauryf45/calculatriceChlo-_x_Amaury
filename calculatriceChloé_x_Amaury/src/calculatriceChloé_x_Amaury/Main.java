package calculatriceChloé_x_Amaury;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private String input = "";
	
	@Override
	public void start(Stage primaryStage) {
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

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");
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
        grid.add(equalsButton, 2, 4);
        grid.add(clearButton, 0, 4);

        // Gérez les événements des boutons
        for (int i = 0; i < 10; i++) {
            final int number = i;
            numberButtons[i].setOnAction(event -> handleNumberClick(number));
        }
        addButton.setOnAction(event -> handleOperationClick("+"));
        subtractButton.setOnAction(event -> handleOperationClick("-"));
        multiplyButton.setOnAction(event -> handleOperationClick("*"));
        divideButton.setOnAction(event -> handleOperationClick("/"));
        equalsButton.setOnAction(event -> handleEqualsClick());
        clearButton.setOnAction(event -> handleClearClick());

        // Créez une scène
        Scene scene = new Scene(grid, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleNumberClick(int number) {
        input += String.valueOf(number);
    }

    private void handleOperationClick(String operation) {
    	System.out.println(operation);
        input += operation;
    }

    private void handleEqualsClick() {
        // Évaluez l'expression mathématique et affichez le résultat
        try {
            // Utilisez un moteur d'expression ou écrivez votre propre logique d'évaluation ici
            // Exemple avec un moteur d'expression ScriptEngine
            javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object result = engine.eval(input);
            input = String.valueOf(result);
        } catch (Exception e) {
            input = "Erreur";
        }
    }

    private void handleClearClick() {
        input = "";
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
