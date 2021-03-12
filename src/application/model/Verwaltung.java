package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class Verwaltung {

	List<Kleidung> list = new ArrayList<Kleidung>();
	ObservableList<Kleidung> kleidung;
	int size = 0;

	public Verwaltung() {
		kleidung = FXCollections.observableList(new ArrayList<Kleidung>(), new Callback<Kleidung, Observable[]>() {

			@Override
			public Observable[] call(Kleidung k) {
				// TODO Auto-generated method stub
				return new Observable[] { k.markeProperty(), k.colorProperty(), k.dateProperty(), k.sizeProperty(),
						k.bproperty(), k.priceProperty() };
			}
		});
		kleidung.add(new Kleidung("Moiggaaa", Color.AQUA, LocalDate.of(2002, 3, 20), Größe.L, false, 120));
	}

	public ObservableList<Kleidung> getKleidung() {
		return kleidung;
	}

	public void setKleidung(ObservableList<Kleidung> kleidung) {
		this.kleidung = kleidung;
	}

	public void add(Kleidung k) {
		kleidung.add(k);
	}

	public void del(ObservableList<Kleidung> b) {
		kleidung.removeAll(b);
	}

	public void speichern(File f) {
		try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(f))) {

			size = kleidung.size();
			ArrayList<Kleidung> listk = new ArrayList<Kleidung>(kleidung);

			for (Kleidung k : listk) {
				ois.writeUTF(k.getMarke());
				ois.writeDouble(k.getFarbe().getRed());
				ois.writeDouble(k.getFarbe().getGreen());
				ois.writeDouble(k.getFarbe().getBlue());
				ois.writeDouble(k.getFarbe().getOpacity());

				ois.writeObject(k.getDate());
				ois.writeObject(k.getSize());
				ois.writeBoolean(k.getGender());
				ois.writeDouble(k.getPrice());

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lesen(File f) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			for (int i = 0; i < size; i++) {
				add(new Kleidung((String) ois.readUTF(),
						new Color(ois.readDouble(), ois.readDouble(), ois.readDouble(), ois.readDouble()),
						(LocalDate) ois.readObject(), (Größe) ois.readObject(), ois.readBoolean(), ois.readDouble()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sort() {
		FXCollections.sort(kleidung, new Comparator<Kleidung>() {

			@Override
			public int compare(Kleidung o1, Kleidung o2) {
				// TODO Auto-generated method stub
				return o1.getMarke().compareTo(o2.getMarke());
			}
		});
	}
}
