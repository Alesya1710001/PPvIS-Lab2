package view;

import controller.*;
import listeners.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class MainDialog 
{
	protected Shell shell;

	public static void main(String[] args) 
	{
		 Shell shell;
		 Display display = new Display();
		 shell = new Shell(display);
		 shell.setLayout(new RowLayout(SWT.VERTICAL));
		 
	     Controller controller = new Controller();
	     PageController pageControl = new PageController();
         
	     
	     Composite menuGroup = new Composite(shell, SWT.NONE);
	     Composite Cells = new Composite(shell, SWT.NONE);
	     Composite[] Composites=new Composite[7];
	     
	     Table table = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	     table.setHeaderVisible(true);
	     TableColumn column;
	     TableItem item;
	     
	     Composite controlPageButtons = new Composite(shell, SWT.NONE);
	     
	     controlPageButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
	     Cells.setLayout(new RowLayout(SWT.HORIZONTAL));
		 menuGroup.setLayout(new RowLayout(SWT.VERTICAL));
	     
	     Label[] Labels =new Label[7];
         Text[] Text =new Text[7];
	        
	     Button openFile = new Button(menuGroup, SWT.NONE);
	     Button saveFile = new Button(menuGroup, SWT.NONE);
	     Button addNote = new Button(menuGroup, SWT.NONE);
	     Button findNote = new Button(menuGroup, SWT.NONE);
	     Button deleteNote = new Button(menuGroup, SWT.NONE);
	     Button firstPage = new Button(controlPageButtons,SWT.NONE);
	     Button previousPage = new Button(controlPageButtons, SWT.NONE);
	     Button nextPage = new Button(controlPageButtons, SWT.NONE);
	     Button lastPage = new Button(controlPageButtons,SWT.NONE);
	     
	     Label pagesNumber=new Label(controlPageButtons,SWT.NONE);
	     RowData size=new RowData(100,50);
		 pagesNumber.setLayoutData(size);
		 
		 Text numberElement = new Text(controlPageButtons,SWT.NONE);
		
	     Button number = new Button(controlPageButtons,SWT.NONE);
	     
	     openFile.setText("open file");
	     saveFile.setText("save file");
	     addNote.setText("add note");
	     findNote.setText("find note");
	     deleteNote.setText("delete note");
	     firstPage.setText("To start");
	     lastPage.setText("To end");
	     nextPage.setText("Next");
	     previousPage.setText("Previous");
	     number.setText("Change number of element");
	     pagesNumber.setText("0/0");

	     String[] labelNames={"Student's name", 
	    		 "Father's name", 
	    		 "Mother's name", 
	    		 "Father's money", 
	    		 "Mother's money", 
	    		 "Number of sisters", 
	    		 "Number of brothers"};

	     for(int i=0;i<7;i++)
	     {
	    	 Composites[i]=new Composite(Cells, SWT.NONE);
	    	 Composites[i].setLayout(new RowLayout(SWT.VERTICAL));
	    	 Labels[i]=new Label(Composites[i],SWT.NONE);
	    	 Text[i]=new Text(Composites[i],SWT.NONE);
	    	 Labels[i].setText(labelNames[i]);
	     }
	        
	     for (int numberOfTitle = 0; numberOfTitle < labelNames.length; numberOfTitle++)
	     {
	    	 column = new TableColumn(table, SWT.LEFT);
	    	 column.setWidth(200);
	    	 column.setText(labelNames[numberOfTitle]);
	     }
			
	     
	     for (int i = 0; i < pageControl.getNumberOfELement() ; i++) 
	     {
	    	 item = new TableItem(table, SWT.NONE);
	     }

	     firstPage.addSelectionListener( new FirstPageListener(table,pageControl,controller,pagesNumber));
	     lastPage.addSelectionListener(new LastPageListener(table, pageControl,controller,pagesNumber) );
	     nextPage.addSelectionListener(new NextPageListener(table, pageControl,controller,pagesNumber));
	     previousPage.addSelectionListener(new PreviousPageListener(table,pageControl,controller,pagesNumber));
	     addNote.addSelectionListener(new AddNoteListener(table,pageControl,controller,pagesNumber,Text));
	     openFile.addSelectionListener(new OpenFileListener(table,pageControl,controller,pagesNumber));
	     saveFile.addSelectionListener(new SaveFileListener(table,pageControl,controller,pagesNumber));

	     number.addSelectionListener(new SelectionAdapter() 
	     {
	    	 public void widgetSelected(SelectionEvent event1)
	    	 {	
	    		 table.removeAll();
	    		 pageControl.setNumberOfELement(Integer.valueOf(numberElement.getText()));
	    		 for (int i = 0; i < pageControl.getNumberOfELement() ; i++) 
	    		 {
	    			 TableItem item = new TableItem(table, SWT.NONE);
	    		 }
	    	 }
	     });
	        
	     findNote.addSelectionListener(new SelectionAdapter() 
	     {
	    	 public void widgetSelected(SelectionEvent event1) 
	    	 {
	    		 FindDialog menu = new FindDialog();
	    		 menu.setWorkSpace(controller.getTable(), display);
	    	 }
	     });

	     deleteNote.addSelectionListener(new SelectionAdapter() 
	     {
	    	 public void widgetSelected(SelectionEvent event1) 
	    	 {
	    		 DeleteDialog menu = new DeleteDialog();
	    		 menu.setWorkSpace(controller.getTable(), controller);
	         }
	     });

	     shell.pack();
	     shell.open();
	     while (!shell.isDisposed()) 
	     {
	    	 if (!display.readAndDispatch())
	    		 display.sleep();
	     }	
	}
}
