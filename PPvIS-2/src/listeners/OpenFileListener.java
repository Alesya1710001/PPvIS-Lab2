package listeners;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import controller.Controller;
import controller.PageController;
import view.ViewTable;

public class OpenFileListener extends SelectionAdapter
{
    PageController pageControl=null;
    Table tableView= null;
    Controller controller= null;
    Label pagesLabel=null;

    public OpenFileListener(Table table, PageController tempValue, Controller tempController, Label tempLabel)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
    }

    public void widgetSelected(SelectionEvent event1) {
        Shell shell=new Shell();
        FileDialog dialog=new FileDialog(shell, SWT.OPEN);
        dialog.setFilterNames(new String[]{"XML files"});
        dialog.setFilterExtensions(new String[]{"*.xml"});
        dialog.open();
        controller.loadFile(dialog.getFileName());
        ViewTable view = new ViewTable();
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);
    }
}
