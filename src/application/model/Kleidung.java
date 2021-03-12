package application.model;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

public class Kleidung implements Serializable {

	private StringProperty marke = new SimpleStringProperty();
	private ObjectProperty<Color> farbe = new SimpleObjectProperty<Color>();
	private ObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<Größe> size = new SimpleObjectProperty<Größe>();
	private BooleanProperty gender = new SimpleBooleanProperty();
	private DoubleProperty price = new SimpleDoubleProperty();

	public Kleidung(String marke, Color farbe, LocalDate date, Größe size, boolean gender, double price) {
		super();
		setMarke(marke);
		setFarbe(farbe);
		setDate(date);
		setSize(size);
		setGender(gender);
		setPrice(price);
	}

	public String getMarke() {
		return marke.get();
	}

	public void setMarke(String marke) {
		this.marke.set(marke);
	}

	public StringProperty markeProperty() {
		return marke;
	}

	public Color getFarbe() {
		return farbe.get();
	}

	public void setFarbe(Color farbe) {
		this.farbe.set(farbe);
	}

	public ObjectProperty<Color> colorProperty() {
		return farbe;
	}

	public LocalDate getDate() {
		return date.get();
	}

	public void setDate(LocalDate date) {
		this.date.set(date);
	}

	public ObjectProperty<LocalDate> dateProperty() {
		return date;
	}

	public Größe getSize() {
		return size.get();
	}

	public void setSize(Größe size) {
		this.size.set(size);
	}

	public ObjectProperty<Größe> sizeProperty() {
		return size;
	}

	public boolean getGender() {
		return gender.get();
	}

	public void setGender(boolean gender) {
		this.gender.set(gender);
	}

	public BooleanProperty bproperty() {
		return gender;
	}

	public double getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
	}

	public DoubleProperty priceProperty() {
		return price;
	}

	@Override
	public String toString() {
		return "Kleidung [Marke=" + getMarke() + ", farbe=" + getFarbe() + ", date=" + getDate() + ", size=" + getSize()
				+ ", gender=" + getGender() + ", price=" + getPrice() + "]";
	}

}
