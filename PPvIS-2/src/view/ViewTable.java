package view;

import model.Student;
import java.util.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;



public class ViewTable {

	public void seeTable(Table workSpace, int pageControl, List <Student> controller, Label pagesLabel)
    {
		int maxPage=0;
        String pages;
        if(controller.size()%10==0)
            maxPage=controller.size()/10;
        else
            maxPage=controller.size()/10+1;
        int temp =pageControl+1;
        pages=""+temp+"/"+maxPage;
        pagesLabel.setText(pages);

        TableItem[] arrayOfItems = workSpace.getItems();
        
        for (int i = 0; i < 10; i++) {
            if (controller.size() - 10 * pageControl > i) {
                arrayOfItems[i].setText(0, controller.get(i + pageControl*10).getStudentName());
                arrayOfItems[i].setText(1, controller.get(i + pageControl*10).getFatherName());
                arrayOfItems[i].setText(2, controller.get(i + pageControl*10).getMotherName());
                arrayOfItems[i].setText(3, Integer.toString(controller.get(i + pageControl*10).getFatherMoney()));
                arrayOfItems[i].setText(4, Integer.toString(controller.get(i + pageControl*10).getMotherMoney()));
                arrayOfItems[i].setText(5, Integer.toString(controller.get(i + pageControl*10).getNumberOfSisters()));
                arrayOfItems[i].setText(6, Integer.toString(controller.get(i + pageControl*10).getNumberOfBrothers()));

            } else {
                arrayOfItems[i].setText(0, "");
                arrayOfItems[i].setText(1, "");
                arrayOfItems[i].setText(2, "");
                arrayOfItems[i].setText(3, "");
                arrayOfItems[i].setText(4, "");
                arrayOfItems[i].setText(5, "");
                arrayOfItems[i].setText(6, "");
            }

        }
    }

}
