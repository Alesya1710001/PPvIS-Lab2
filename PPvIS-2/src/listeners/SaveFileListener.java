package listeners;

import controller.*;
import parser.DOMParser;
import view.ViewTable;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SaveFileListener extends SelectionAdapter {
	private PageController pageControl;
	private Table tableView;
	private Controller controller;
	private Label pagesLabel;

	public SaveFileListener(Table table, PageController tempValue, Controller tempController, Label tempLabel) {
		tableView = table;
		controller = tempController;
		pagesLabel = tempLabel;
		pageControl = tempValue;
	}

	public void widgetSelected(SelectionEvent event1) {
		Shell shell = new Shell();
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setFilterNames(new String[] { "XML files" });
		dialog.setFilterExtensions(new String[] { "*.xml" });
		dialog.open();

		DOMParser parser = new DOMParser();
		parser.setTable(controller.getTable());
		parser.save(dialog.getFileName());
		ViewTable view = new ViewTable();
		view.seeTable(tableView, pageControl, controller.getTable(), pagesLabel);
	}
}
