package view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import controller.PageController;
import listeners.FirstPageListener;
import listeners.LastPageListener;
import listeners.NextPageListener;
import listeners.PreviousPageListener;
import model.Student;

public class FindDialog {

	List<Student> vectorOfAnswers=new ArrayList<>();
	List<Student> findVector=null;
	Shell shell;
	PageController pageControl=new PageController();
	
	public void setWorkSpace(List<Student> base, Display display)
	{
	
		Controller controller=new Controller();
		findVector=base;
        
        Shell shell=new Shell();
        shell.setLayout(new RowLayout(SWT.VERTICAL));
        
        Composite Cells = new Composite(shell, SWT.NONE);
	    Composite[] Composites=new Composite[7];
	    Label[] Labels =new Label[7];
        Text[] Text =new Text[7];
	        
	     String[] labelNames={"Student's name", "Father's name", "Mother's name", "Father's money", "Mother's money", "Number of sisters", "Number of brothers"};

	     for(int i=0;i<7;i++)
	     {
	            Composites[i]=new Composite(Cells, SWT.NONE);
	            Composites[i].setLayout(new RowLayout(SWT.VERTICAL));
	            Labels[i]=new Label(Composites[i],SWT.NONE);
	            Text[i]=new Text(Composites[i],SWT.NONE);
	            Labels[i].setText(labelNames[i]);
	            
	     }
	        
	     Cells.setLayout(new RowLayout(SWT.HORIZONTAL));
	     
	     Button FindButton=new Button(Cells,SWT.NONE);
	     FindButton.setText("find note");

	     Table tableView = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	     tableView.setHeaderVisible(true);
	     
	     TableColumn column;
	        
		 for (int numberOfTitle = 0; numberOfTitle < labelNames.length; numberOfTitle++)
		 {
				column = new TableColumn(tableView, SWT.LEFT);
				column.setWidth(200);
			    column.setText(labelNames[numberOfTitle]);
	   	 }
		 
		 for(int i=0;i<10;i++)
	     {
	           TableItem item = new TableItem(tableView, SWT.NONE);
	     }
		 
		 Composite controlPageButtons = new Composite(shell, SWT.NONE);
			
	     Button firstPage = new Button(controlPageButtons,SWT.NONE);
	     Button previousPage = new Button(controlPageButtons, SWT.NONE);
         Button nextPage = new Button(controlPageButtons, SWT.NONE);
         Button lastPage = new Button(controlPageButtons,SWT.NONE);
	     Label pagesNumber=new Label(controlPageButtons,SWT.NONE);
	     
	     firstPage.setText("To start");
	     lastPage.setText("To end");
	     nextPage.setText("Next");
	     previousPage.setText("Previous");
	     pagesNumber.setText("0/0");
	        
	     controlPageButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
	     
	     firstPage.addSelectionListener( new FirstPageListener(tableView,pageControl,controller,pagesNumber));
	     lastPage.addSelectionListener(new LastPageListener(tableView, pageControl,controller,pagesNumber) );
	     nextPage.addSelectionListener(new NextPageListener(tableView, pageControl,controller,pagesNumber));
	     previousPage.addSelectionListener(new PreviousPageListener(tableView,pageControl,controller,pagesNumber));
	     
	     FindButton.addSelectionListener(new SelectionAdapter() {
	         public void widgetSelected(SelectionEvent event1)
	         {
	        	 
	             if(!Text[0].getText().isEmpty())
	             {
	              
	                 vectorOfAnswers = controller.findNoteByStudentName(Text[0].getText(), findVector);
	             
	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[1].getText().isEmpty())
	             {
	               
	                 vectorOfAnswers =controller.findNoteByFatherName(Text[1].getText(), findVector);
	                 
	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[2].getText().isEmpty())
	             {
	                

	                 vectorOfAnswers = controller.findNoteByMotherName(Text[2].getText(), findVector);

	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[3].getText().isEmpty())
	             {
	                
	                 vectorOfAnswers = controller.findNoteByFatherMoney(Integer.valueOf(Text[3].getText()), findVector);

	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[4].getText().isEmpty())
	             {
	                 
	                 vectorOfAnswers = controller.findNoteByMotherMoney(Integer.valueOf(Text[4].getText()), findVector);

	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[5].getText().isEmpty())
	             {
	                
	                 vectorOfAnswers = controller.findNoteBySisterNumber(Integer.valueOf(Text[5].getText()), findVector);
	                 findVector=vectorOfAnswers;

	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             if(!Text[6].getText().isEmpty())
	             {
	                
	                 vectorOfAnswers = controller.findNoteByBrotherNumber(Integer.valueOf(Text[6].getText()), findVector);

	                 for (int i=0;i<vectorOfAnswers.size();i++)
	                 {
	                     controller.setItem(vectorOfAnswers.get(i));
	                 }
	             }
	             
	             ViewTable viewTable=new ViewTable();
	             viewTable.seeTable(tableView, pageControl.getPage(), vectorOfAnswers, pagesNumber);
	         }
	         });
	     
	     shell.pack();
	        shell.open();
	        while (!shell.isDisposed()) {
	            if (!display.readAndDispatch())
	                display.sleep();
	        }
		 
	}
	
	
}
