package application.control;

import java.io.File;

import application.model.Verwaltung;
import application.view.MyPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class Handler implements EventHandler<ActionEvent> {
	MyPane mp;
	Verwaltung vw;
	File f = new File("C:\\Users\\Fireboy\\Desktop\\Schule\\POS\\Lab26 GUI\\src\\file.txt");

	public Handler(MyPane mp, Verwaltung vw) {
		this.mp = mp;
		this.vw = vw;
	}

	@Override
	public void handle(ActionEvent event) {
		String data = "";
		if (event.getSource() instanceof MenuItem) {
			MenuItem m = (MenuItem) event.getSource();
			data = (String) m.getUserData();
		}
		switch (data) {
		case "add":
			mp.addDialog();
			break;

		case "del":
			vw.del(mp.getKleidungListe());
			break;
		case "load":
			vw.lesen(f);
			break;
		case "save":
			vw.speichern(f);
			break;
		case "alpha":
			vw.sort();
		}
	}

}
