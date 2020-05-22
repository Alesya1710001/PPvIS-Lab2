package view;


import controller.*;
import listeners.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;



public class MainDialog {
	protected Shell shell;

	public static void main(String[] args) {
		
		 PageController pageControl = new PageController();
	     Controller controller = new Controller();
	     Shell shell;
	     Display display = new Display();
	     shell = new Shell(display);
	     shell.setLayout(new RowLayout(SWT.VERTICAL));
	     
	     Composite menuGroup = new Composite(shell, SWT.NONE);
	     Button openFile = new Button(menuGroup, SWT.NONE);
	     Button saveFile = new Button(menuGroup, SWT.NONE);
	     Button addNote = new Button(menuGroup, SWT.NONE);
	     Button findNote = new Button(menuGroup, SWT.NONE);
	     Button deleteNote = new Button(menuGroup, SWT.NONE);
	     
	     openFile.setText("open file");
	     saveFile.setText("save file");
	     addNote.setText("add note");
	     findNote.setText("find note");
	     deleteNote.setText("delete note");
	     
	     
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
	        menuGroup.setLayout(new RowLayout(SWT.VERTICAL));
	      
	        
	        Table table = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	        table.setHeaderVisible(true);
	        TableColumn column;
	        	        
			for (int numberOfTitle = 0; numberOfTitle < labelNames.length; numberOfTitle++)
			{
				column = new TableColumn(table, SWT.LEFT);
				column.setWidth(200);
			    column.setText(labelNames[numberOfTitle]);
			}
			
			for (int i = 0; i < 10; i++) {
	            TableItem item = new TableItem(table, SWT.NONE);
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
	        

	        firstPage.addSelectionListener( new FirstPageListener(table,pageControl,controller,pagesNumber));
	        lastPage.addSelectionListener(new LastPageListener(table, pageControl,controller,pagesNumber) );
	        nextPage.addSelectionListener(new NextPageListener(table, pageControl,controller,pagesNumber));
	        previousPage.addSelectionListener(new PreviousPageListener(table,pageControl,controller,pagesNumber));
	        addNote.addSelectionListener(new AddNoteListener(table,pageControl,controller,pagesNumber,Text));
	        openFile.addSelectionListener(new OpenFileListener(table,pageControl,controller,pagesNumber));
	        saveFile.addSelectionListener(new SaveFileListener(table,pageControl,controller,pagesNumber));
	     
	        findNote.addSelectionListener(new SelectionAdapter() {
	            public void widgetSelected(SelectionEvent event1) {
	                FindDialog menu = new FindDialog();
	                menu.setWorkSpace(controller.getTable(), display);
	            }
	        });

	        deleteNote.addSelectionListener(new SelectionAdapter() {
	            public void widgetSelected(SelectionEvent event1) {
	                DeleteDialog menu = new DeleteDialog();
	                menu.setWorkSpace(controller.getTable(), controller);


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
