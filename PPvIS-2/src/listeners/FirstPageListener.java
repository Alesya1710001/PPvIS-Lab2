package listeners;

import controller.Controller;
import controller.PageController;
import view.ViewTable;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class FirstPageListener extends SelectionAdapter {
	private  PageController pageControl;
	private Table tableView;
	private Controller controller;
	private Label pagesLabel;

	public FirstPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel) {
		tableView = table;
		controller = tempController;
		pagesLabel = tempLabel;
		pageControl = tempValue;
	}

	public void widgetSelected(SelectionEvent event1) {
		pageControl.firsPage();
		ViewTable view = new ViewTable();
		view.seeTable(tableView, pageControl, controller.getTable(), pagesLabel);
	}
}
