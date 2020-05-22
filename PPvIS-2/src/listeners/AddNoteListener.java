package listeners;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import controller.PageController;
import model.Student;
import view.ViewTable;

public class AddNoteListener extends SelectionAdapter
{
    PageController pageControl=null;
    Table tableView= null;
    Controller controller= null; 
    Label pagesLabel=null;
    Text[] arrayOfText=new Text[7];
    
    public AddNoteListener(Table table, PageController tempValue, Controller tempController, Label tempLabel, Text[] tempArrayOfText)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
        arrayOfText=tempArrayOfText;
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
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);
    }
}
