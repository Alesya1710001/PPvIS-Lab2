package listeners;

import controller.*;
import view.ViewTable;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class NextPageListener extends SelectionAdapter
{
    PageController pageControl;
    Table tableView;
    Controller controller;
    Label pagesLabel;
    
    public NextPageListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
    }

    public void widgetSelected(SelectionEvent event1) 
    {
        pageControl.nextPage(controller);
        ViewTable view=new ViewTable();
        view.seeTable(tableView,pageControl,controller.getTable(),pagesLabel);
    }
}
