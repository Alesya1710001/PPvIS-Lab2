package listeners;

import controller.*;
import view.ViewTable;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class PreviousPageListener extends SelectionAdapter {
	private PageController pageControl;
	private Table tableView;
	private Controller controller;
	private Label pagesLabel;

	public PreviousPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel) {
		tableView = table;
		controller = tempController;
		pagesLabel = tempLabel;
		pageControl = tempValue;
	}

	public void widgetSelected(SelectionEvent event1) {
		pageControl.previousPage();
		ViewTable view = new ViewTable();
		view.seeTable(tableView, pageControl, controller.getTable(), pagesLabel);
	}
}
