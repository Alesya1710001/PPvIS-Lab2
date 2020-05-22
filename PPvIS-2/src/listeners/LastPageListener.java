package listeners;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import controller.Controller;
import controller.PageController;
import view.ViewTable;

public class LastPageListener extends SelectionAdapter
{
    private PageController pageControl=null;
    Table tableView= null;
    Controller controller= null;
    Label pagesLabel=null;
    public LastPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
    }

    public void widgetSelected(SelectionEvent event1) {
            pageControl.lastPage(controller);
            ViewTable view = new ViewTable();
            view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);
    }

}