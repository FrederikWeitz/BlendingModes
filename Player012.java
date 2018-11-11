package blendingmode;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Player012 extends Application {

	// Property to Change all Images Opacity with Slider
	SimpleDoubleProperty setOpacity = new SimpleDoubleProperty(1);
	
	// List to Change all blending Images with Button 
	ArrayList<ImageView> blendImageViewList = new ArrayList<ImageView>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Layout Container
		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 600);
		
		ToolBar toolBar = new ToolBar();
		root.getChildren().add(toolBar);
		
		// Opacity Slider
		VBox sliderBox = new VBox();
		Label opacityLabel = new Label("Opacity");
		opacityLabel.setFont(Font.font("Arial", 12));
		opacityLabel.setMaxHeight(12);
		opacityLabel.setTextAlignment(TextAlignment.CENTER);
		opacityLabel.setAlignment(Pos.TOP_CENTER);
		opacityLabel.setPrefWidth(300);
		Slider opacitySlider = new Slider(0,1,1);
		opacitySlider.setPrefWidth(300);
		setOpacity.bind(opacitySlider.valueProperty());
		opacitySlider.setTooltip(new Tooltip("Change Opacity"));
		
		sliderBox.getChildren().addAll(opacityLabel, opacitySlider);
		toolBar.getItems().add(sliderBox);
		
		
		// *** Buttons for the toolBar ***
		Button patternButton = new Button();
		patternButton.setGraphic(new ImageView(new Image("/blendingModeImages/attribution.png")));
		
		Button rainbowButton = new Button();
		rainbowButton.setGraphic(new ImageView(new Image("/blendingModeImages/rainbow.png")));
		
		Button butterflyButton = new Button();
		butterflyButton.setGraphic(new ImageView(new Image("/blendingModeImages/butterfly.png")));
		
		Button sunflowerButton = new Button();
		sunflowerButton.setGraphic(new ImageView(new Image("/blendingModeImages/weather_sun.png")));
		
		toolBar.getItems().addAll(patternButton, rainbowButton, butterflyButton, sunflowerButton);
		
		
		// *** Button Events - Changing Images ***
		rainbowButton.setOnAction((event) -> {
			for (ImageView item : blendImageViewList) {
				item.setImage(new Image("/blendingModeImages/abstract-020.png"));
			}
		});
		
		rainbowButton.setOnAction((event) -> {
			for (ImageView item : blendImageViewList) {
				item.setImage(new Image("/blendingModeImages/rainbow-colors.jpg"));
			}
		});
		
		butterflyButton.setOnAction((event) -> {
			for (ImageView item : blendImageViewList) {
				item.setImage(new Image("/blendingModeImages/common-blue.jpg"));
			}
		});
		
		sunflowerButton.setOnAction((event) -> {
			for (ImageView item : blendImageViewList) {
				item.setImage(new Image("/blendingModeImages/growing-sunflowers.jpg"));
			}
		});
		
		
		// GridPane and contents ***********************************
		GridPane gridPane = new GridPane();
		root.getChildren().add(gridPane);
		
		//
		// without BlendingMode: 
		Pane normalPane = getViewPane("normal", null);
		gridPane.add(normalPane, 0, 0);
		
		//
		// first BlendingMode: multiply
		Pane multiplyPane = getViewPane("multiply", BlendMode.MULTIPLY);
		gridPane.add(multiplyPane, 1, 0);
		
		//
		// second BlendingMode: difference
		Pane differencePane = getViewPane("difference", BlendMode.DIFFERENCE);
		gridPane.add(differencePane, 2, 0);
		
		//
		// third BlendingMode: add
		Pane addPane = getViewPane("add", BlendMode.ADD);		
		gridPane.add(addPane, 3, 0);
		
		//
		// fourth BlendingMode: red
		Pane redPane = getViewPane("red", BlendMode.RED);
		gridPane.add(redPane, 4, 0);
		
		//
		// fifth BlendingMode: blue
		Pane bluePane = getViewPane("blue", BlendMode.BLUE);
		gridPane.add(bluePane, 5, 0);
		
		//
		// sixth BlendingMode: burn
		Pane burnPane = getViewPane("color-burn", BlendMode.COLOR_BURN);
		gridPane.add(burnPane, 0, 1);
		
		//
		// seventh BlendingMode: dodge
		Pane dodgePane = getViewPane("color-dodge", BlendMode.COLOR_DODGE);
		gridPane.add(dodgePane, 1, 1);
		
		//
		// eight BlendingMode: darken
		Pane darkenPane = getViewPane("darken", BlendMode.DARKEN);
		gridPane.add(darkenPane, 2, 1);
		
		//
		// ninth BlendingMode: exclusion
		Pane exclusionPane = getViewPane("exclusion", BlendMode.EXCLUSION);
		gridPane.add(exclusionPane, 3, 1);
		
		//
		// tenth BlendingMode: overlay
		Pane overlayPane = getViewPane("overlay", BlendMode.OVERLAY);
		gridPane.add(overlayPane, 4, 1);
		
		//
		// eleventh BlendingMode: green
		Pane greenPane = getViewPane("green", BlendMode.GREEN);
		gridPane.add(greenPane, 5, 1);
		
		//
		// twelvth BlendingMode: hard-light
		Pane hardPane = getViewPane("hard-light", BlendMode.HARD_LIGHT);
		gridPane.add(hardPane, 0, 2);
		
		//
		// thirteenth BlendingMode: lighten
		Pane lightenPane = getViewPane("lighten", BlendMode.LIGHTEN);
		gridPane.add(lightenPane, 1, 2);
		
		//
		// fourteenth BlendingMode: screen
		Pane screenPane = getViewPane("screen", BlendMode.SCREEN);
		gridPane.add(screenPane, 2, 2);
		
		//
		// fifteenth BlendingMode: src-atop
		Pane atopPane = getViewPane("src-atop", BlendMode.SRC_ATOP);
		gridPane.add(atopPane, 3, 2);
		
		//
		// sixteenth BlendingMode: src-over
		Pane overPane = getViewPane("src-over", BlendMode.SRC_OVER);
		gridPane.add(overPane, 4, 2);
		
		//
		// seventeenth BlendingMode: soft-light
		Pane softPane = getViewPane("soft-light", BlendMode.SOFT_LIGHT);
		gridPane.add(softPane, 5, 2);
		
		// Stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * returns Pane with all Contents for Blending Modes
	 * @param title
	 * @param blendMode
	 * @return Pane
	 */
	public Pane getViewPane(String title, BlendMode blendMode) {
		Pane viewPane = new Pane();
		viewPane.getChildren().add(new VBox(getLabel(title), new Pane(getBoxView(), getBlendView(blendMode))));
		viewPane.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		return viewPane;
	}
	
	/**
	 * returns the base Image in which the other Image is blended
	 * @return ImageView
	 */
	public ImageView getBoxView() {
		Image boxImage = new Image(getClass().getResourceAsStream("/blendingModeImages/box2.png"));
		ImageView boxView = new ImageView(boxImage);
		boxView.setScaleX(.4);
		boxView.setScaleY(.4);
		boxView.setTranslateX(-64);
		boxView.setTranslateY(-64);
		return boxView;
	}
	
	/**
	 * returns the Image to be blended; adds the ImageView to the blendImageViewList
	 * @param blendMode
	 * @return ImageView
	 */
	public ImageView getBlendView(BlendMode blendMode) {
		Image blendImage = new Image(getClass().getResourceAsStream("/blendingModeImages/abstract-020.png"));
		ImageView blendView = new ImageView(blendImage);
		blendImageViewList.add(blendView);
		blendView.opacityProperty().bind(setOpacity);
		if (blendView != null) {
			blendView.setBlendMode(blendMode);
		}
		return blendView;
	}

	/**
	 * creates a Label for each blending mode
	 * @param str
	 * @return Label
	 */
	public Label getLabel(String str) {
		Label label = new Label(str);
		label.setFont(Font.font("Arial", 16));
		label.setTextFill(Color.WHITE);
		return label;
	}
}
