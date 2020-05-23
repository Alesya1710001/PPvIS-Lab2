package listeners;

import controller.*;
import view.ViewTable;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class OpenFileListener extends SelectionAdapter
{
    PageController pageControl;
    Table tableView;
    Controller controller;
    Label pagesLabel;

    public OpenFileListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
    }

    public void widgetSelected(SelectionEvent event1) 
    {
        Shell shell=new Shell();
        FileDialog dialog=new FileDialog(shell, SWT.OPEN);
        dialog.setFilterNames(new String[]{"XML files"});
        dialog.setFilterExtensions(new String[]{"*.xml"});
        dialog.open();
        controller.loadFile(dialog.getFileName());
        ViewTable view = new ViewTable();
        view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
    }
}
