package view;

import model.Student;
import controller.PageController;

import java.util.List;
import org.eclipse.swt.widgets.*;

public class ViewTable {
	public void seeTable(Table workSpace, PageController pageControl, List<Student> controller, Label pagesLabel) {
		int maxPage = 0;
		String pages;
		int page = pageControl.getPage();
		int number = pageControl.getNumberOfELement();

		if (controller.size() % number == 0)
			maxPage = controller.size() / number;
		else
			maxPage = controller.size() / number + 1;

		int temp = page + 1;
		pages = "" + temp + "/" + maxPage;
		pagesLabel.setText(pages);

		TableItem[] arrayOfItems = workSpace.getItems();

		for (int i = 0; i < number; i++) {
			if (controller.size() - number * page > i) {
				arrayOfItems[i].setText(0, controller.get(i + page * number).getStudentName());
				arrayOfItems[i].setText(1, controller.get(i + page * number).getFatherName());
				arrayOfItems[i].setText(2, controller.get(i + page * number).getMotherName());
				arrayOfItems[i].setText(3, Integer.toString(controller.get(i + page * number).getFatherMoney()));
				arrayOfItems[i].setText(4, Integer.toString(controller.get(i + page * number).getMotherMoney()));
				arrayOfItems[i].setText(5, Integer.toString(controller.get(i + page * number).getNumberOfSisters()));
				arrayOfItems[i].setText(6, Integer.toString(controller.get(i + page * number).getNumberOfBrothers()));

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
