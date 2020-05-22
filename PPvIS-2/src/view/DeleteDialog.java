package view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import model.Student;

public class DeleteDialog {
	
	 List<Student> vectorOfAnswers=new ArrayList<>();
	 
	 List<Student> findVector=null;
	 
	 Shell shell;
	 

	 public void setWorkSpace(List<Student> base, Controller mainController)
	 {
		 Controller controller=new Controller();
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
	            Text[i]=new Text(Composites[i],SWT.NONE);
	            Labels[i]=new Label(Composites[i],SWT.NONE);
	            Labels[i].setText(labelNames[i]);
	            
	     }
	        
	     Cells.setLayout(new RowLayout(SWT.HORIZONTAL));
	     
	     Label answer=new Label(shell,SWT.NONE);
	     RowData size=new RowData(400,50);
	     answer.setLayoutData(size);
	     
	     Button deleteButton =new Button(shell,SWT.NONE);
		 deleteButton.setText("Delete");
		 
		 deleteButton.addSelectionListener(new SelectionAdapter() {
	
			 public void widgetSelected(SelectionEvent event1) {
	                findVector=base;
	                if (!Text[0].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByStudentName(Text[0].getText(), findVector);
	                  
	                }
	                
	                if (!Text[1].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByFatherName(Text[1].getText(), findVector);
	                  
	                }
	                
	                if (!Text[2].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByMotherName(Text[2].getText(), findVector);
	                  
	                }
	                
	                if (!Text[3].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByFatherMoney(Integer.valueOf(Text[3].getText()), findVector);
	                 
	                }
	                
	                if (!Text[4].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByMotherMoney(Integer.valueOf(Text[4].getText()), findVector);
	                 
	                }
	                
	                if (!Text[5].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteBySisterNumber(Integer.valueOf(Text[5].getText()), findVector);
	                
	                }
			 
	                if (!Text[6].getText().isEmpty()) {
	                    vectorOfAnswers = controller.findNoteByBrotherNumber(Integer.valueOf(Text[6].getText()), findVector);
	                   	                }
	                if(vectorOfAnswers.size()==0)
	                    answer.setText("noting to delete");
	                else
	                    answer.setText(vectorOfAnswers.size()+" elements of base has deleted");
	                    mainController.deleteElement(vectorOfAnswers);

	            }
	        });
		 
		 shell.pack();
	     shell.open();
		 
	 
	 }
	

}