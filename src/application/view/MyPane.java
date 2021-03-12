package application.view;

import java.util.ArrayList;

import application.control.Handler;
import application.model.Größe;
import application.model.Kleidung;
import application.model.Verwaltung;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class MyPane extends BorderPane {
	public ListView<Kleidung> list;
	ObservableList<Kleidung> observableList;
	private GridPane grid = new GridPane();
	TextField marke;
	TextField Preis;
	int zahl = 0;
	ColorPicker color = new ColorPicker();
	ComboBox<Größe> size = new ComboBox<Größe>();
	ComboBox<Größe> size2 = new ComboBox<Größe>();
	DatePicker date = new DatePicker();
	CheckBox box11 = new CheckBox();
	RadioButton male = new RadioButton();
	RadioButton female = new RadioButton();
	Label label = new Label("Marke/Bezeichnung");
	Label label1 = new Label("Farbe:");
	Label label2 = new Label("Einkaufsdatum");
	Label label3 = new Label("Mann:");
	Label label4 = new Label("           Frau:");
	Label label5 = new Label("Größe");
	Label label6 = new Label("Preis");
	Label label7 = new Label(String.valueOf(zahl));

	Label label8 = new Label("Marke/Bezeichnung");
	Label label9 = new Label("Farbe:");
	Label label10 = new Label("Einkaufsdatum");
	Label label11 = new Label("Mann:");
	Label label12 = new Label("           Frau:");
	Label label13 = new Label("Größe");
	Label label14 = new Label("Preis");
	TextField marke1;
	TextField Preis1;
	ColorPicker color1 = new ColorPicker();
	DatePicker date1 = new DatePicker();
	CheckBox box1 = new CheckBox();
	RadioButton male1 = new RadioButton();
	RadioButton female1 = new RadioButton();
	ComboBox<Größe> size1 = new ComboBox<Größe>();
	Kleidung k;
	Dialog add;
	Verwaltung vw = new Verwaltung();
	Handler handler = new Handler(this, vw);

	ObservableList<Kleidung> kleidung = FXCollections.observableArrayList(new ArrayList<Kleidung>());

	public MyPane() {
		observableList = vw.getKleidung();
		list = new ListView<Kleidung>(observableList);
		marke = new TextField();
		Preis = new TextField();
		marke1 = new TextField();
		Preis1 = new TextField();
		marke.setPrefWidth(200);
		marke.setMaxWidth(200);
		Preis.setPrefWidth(200);
		Preis.setMaxWidth(200);
		init();

	}

	public void init() {
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Kleidung>() {

			@Override
			public void changed(ObservableValue<? extends Kleidung> observable, Kleidung oldValue, Kleidung newValue) {
				// TODO Auto-generated method stub
				if (oldValue != null) {
					marke.textProperty().unbindBidirectional(oldValue.markeProperty());
					color.valueProperty().unbindBidirectional(oldValue.colorProperty());
					date.valueProperty().unbindBidirectional(oldValue.dateProperty());
					size.valueProperty().unbindBidirectional(oldValue.sizeProperty());
					box11.selectedProperty().unbindBidirectional(oldValue.bproperty());
					Preis.textProperty().unbindBidirectional(String.valueOf(oldValue.priceProperty()));
				}
				if (newValue != null) {
					marke.textProperty().bindBidirectional(newValue.markeProperty());
					color.valueProperty().bindBidirectional(newValue.colorProperty());
					date.valueProperty().bindBidirectional(newValue.dateProperty());
					size.valueProperty().bindBidirectional(newValue.sizeProperty());
					box11.selectedProperty().bindBidirectional(newValue.bproperty());
					Preis.textProperty().bindBidirectional(newValue.priceProperty(), new NumberStringConverter() {
					});
				}
			}
		});
		centerset();
		topset();
	}

	public void centerset() {
		ToggleGroup tg = new ToggleGroup();
		VBox box = new VBox();
		FlowPane fp = new FlowPane();
		FlowPane fp1 = new FlowPane();
		FlowPane fp2 = new FlowPane();
		fp2.setAlignment(Pos.CENTER);
		fp2.setPadding(new Insets(10));
		size2.getItems().addAll(Größe.values());
		size2.setOnAction(e -> {
			System.out.println(size2.getValue());
			anzahl(size2.getValue());
		});
		fp2.getChildren().addAll(size2, label7);
		box.getChildren().addAll(grid, fp2);

		size.getItems().addAll(Größe.values());
		size1.getItems().addAll(Größe.values());
		male.setToggleGroup(tg);
		female.setToggleGroup(tg);
		list.setPrefWidth(550);
		list.setPrefHeight(470);
//		setMargin(grid, new Insets(40, 40, 40, 40));
		grid.setPrefWidth(300);
		label1.setPrefWidth(250);
		label1.setMaxWidth(250);
		label2.setPrefWidth(250);
		label2.setMaxWidth(250);
		label3.setPrefWidth(250);
		label3.setMaxWidth(250);
		label4.setPrefWidth(250);
		label4.setMaxWidth(250);
		label5.setPrefWidth(250);
		label5.setMaxWidth(250);
		label6.setPrefWidth(250);
		label6.setMaxWidth(250);
		grid.setHgap(30);
		grid.setVgap(30);
		grid.add(label, 0, 0);
		grid.add(marke, 1, 0);
		grid.add(label1, 0, 1);
		grid.add(color, 1, 1);
		grid.add(label2, 0, 2);
		grid.add(date, 1, 2);
		grid.add(label5, 0, 3);
		grid.add(size, 1, 3);
		grid.add(label3, 0, 4);
		fp1.setPrefWidth(350);
		fp1.setMaxWidth(350);
		fp1.getChildren().addAll(male, label4, female);
		grid.add(box11, 1, 4);
		grid.add(label6, 0, 5);
		grid.add(Preis, 1, 5);
		grid.setPadding(new Insets(10));

		grid.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(5))));
		fp.getChildren().addAll(list, new Label("  "), box);

		setCenter(fp);
	}

	public void topset() {
		MenuBar bar = new MenuBar();
		Menu Kleidung = new Menu("Kleidung");
		Menu Sort = new Menu("Sort");
		MenuItem alpha = new MenuItem("Alphabetisch");
		Sort.getItems().addAll(alpha);
		alpha.setOnAction(handler);
		alpha.setUserData("add");
		MenuItem add = new MenuItem("Add");
		MenuItem del = new MenuItem("Del");
		MenuItem speichern = new MenuItem("Save");
		MenuItem load = new MenuItem("Load");
		add.setOnAction(handler);
		add.setUserData("add");
		speichern.setOnAction(handler);
		speichern.setUserData("save");
		load.setOnAction(handler);
		load.setUserData("load");
		del.setOnAction(handler);
		del.setUserData("del");
		bar.getMenus().addAll(Kleidung, Sort);
		Kleidung.getItems().addAll(add, del, load, speichern);
		setTop(bar);
	}

	public void addDialog() {

		add = new Dialog<>();
		Label label = new Label();
		FlowPane fp1 = new FlowPane();
		size2.getItems().addAll(Größe.values());
		marke1.setText("");
		Preis1.setText("");
		date1.setValue(null);
		size1.setValue(null);
		color1.setValue(Color.WHITE);
		GridPane grid = new GridPane();
		ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
		add.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);
		add.setTitle("Kleidung hinzufügen");
		add.setHeaderText("Bitte Daten korrekt eingeben");
		grid.setHgap(30);
		grid.setVgap(30);
		grid.add(label8, 0, 0);
		grid.add(marke1, 1, 0);
		grid.add(label9, 0, 1);
		grid.add(color1, 1, 1);
		grid.add(label10, 0, 2);
		grid.add(date1, 1, 2);
		grid.add(label13, 0, 3);
		grid.add(size1, 1, 3);
		grid.add(label11, 0, 4);
		fp1.setPrefWidth(350);
		fp1.setMaxWidth(350);
		fp1.getChildren().addAll(male1, label12, female1);
		grid.add(box1, 1, 4);
		grid.add(label14, 0, 5);
		grid.add(Preis1, 1, 5);
		grid.add(label, 0, 6);

		grid.setPadding(new Insets(10));

		grid.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(5))));
		add.getDialogPane().setContent(grid);
		final Button btok = (Button) add.getDialogPane().lookupButton(addButtonType);
		btok.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					k = new Kleidung(marke1.getText(), color1.getValue(), date1.getValue(), size1.getValue(),
							box1.isSelected(), Double.parseDouble(Preis1.getText()));
				} catch (Exception e) {

					label.setText("Bitte geben Sie richtige Werte ein!!");
					label.setFont(Font.font(10));
					label.setTextFill(Color.RED);
					event.consume();
				}

			}
		});
		add.setResultConverter(new Callback<ButtonType, Kleidung>() {

			@Override
			public Kleidung call(ButtonType b) {
				if (b == addButtonType) {
					vw.add(k);

				}
				return null;
			}
		});

		add.showAndWait();
	}

	public ObservableList<Kleidung> getKleidungListe() {
		return list.getSelectionModel().getSelectedItems();
	}

	public void anzahl(Größe g) {
		zahl = 0;
		for (Kleidung k : observableList) {
			System.out.println(k);
			if (k.getSize() == g) {
				zahl++;

			}
			label7.setText(String.valueOf(zahl));
		}
	}

}
