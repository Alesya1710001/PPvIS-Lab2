package listeners;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import controller.Controller;
import controller.PageController;
import view.ViewTable;

public class FirstPageListener extends SelectionAdapter {

	 PageController pageControl=null;
	    Table tableView= null;
	    Controller controller= null;
	    Label pagesLabel=null;
	    public FirstPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
	    {
	         tableView=table;
	         controller=tempController;
	         pagesLabel=tempLabel;
	         pageControl=tempValue;
	    }
	    public void widgetSelected(SelectionEvent event1) {
	        pageControl.firsPage();
	        ViewTable view = new ViewTable();
	        view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);


	    }
}
