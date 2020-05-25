package listeners;

import model.Student;
import controller.*;
import view.ViewTable;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class AddNoteListener extends SelectionAdapter {
	private PageController pageControl;
	private Table tableView;
	private Controller controller;
	private Label pagesLabel;
	private Text[] arrayOfText = new Text[7];

	public AddNoteListener(Table table, PageController tempValue, Controller tempController, Label tempLabel,
			Text[] tempArrayOfText) {
		tableView = table;
		controller = tempController;
		pagesLabel = tempLabel;
		pageControl = tempValue;
		arrayOfText = tempArrayOfText;
	}

	public void widgetSelected(SelectionEvent event1) {
		Student newItem = new Student();

		newItem.setStudentName(arrayOfText[0].getText());
		newItem.setFatherName(arrayOfText[1].getText());
		newItem.setMotherName(arrayOfText[2].getText());
		newItem.setFatherMoney(Integer.valueOf(arrayOfText[3].getText()));
		newItem.setMotherMoney(Integer.valueOf(arrayOfText[4].getText()));
		newItem.setNumberOfSisters(Integer.valueOf(arrayOfText[5].getText()));
		newItem.setNumberOfBrothers(Integer.valueOf(arrayOfText[6].getText()));

		controller.setItem(newItem);

		ViewTable view = new ViewTable();
		view.seeTable(tableView, pageControl, controller.getTable(), pagesLabel);
	}
}
