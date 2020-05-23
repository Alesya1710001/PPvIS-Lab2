package listeners;

import controller.*;
import view.ViewTable;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class LastPageListener extends SelectionAdapter
{
    private PageController pageControl;
    Table tableView;
    Controller controller;
    Label pagesLabel;
    
    public LastPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
    }

    public void widgetSelected(SelectionEvent event1) 
    {
    	pageControl.lastPage(controller);
        ViewTable view = new ViewTable();
        view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
    }

}