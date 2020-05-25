package controller;

import model.Student;
import parser.*;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

public class Controller {
	private List<Student> table = new ArrayList<>();

	public List<Student> getTable() {
		return table;
	}

	public void setItem(Student item) {
		table.add(item);
	}

	public void deleteElement(List<Student> needDeleteElement) {
		for (int i = 0; i < needDeleteElement.size(); i++)
			table.remove(needDeleteElement.get(i));
	}

	public List<Student> findNoteByStudentName(String studentName, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (studentName.equals(findingVector.get(i).getStudentName()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteByFatherName(String fatherName, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (fatherName.equals(findingVector.get(i).getFatherName()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteByMotherName(String motherName, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (motherName.equals(findingVector.get(i).getMotherName()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteByFatherMoney(Integer fatherMoney, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (fatherMoney.equals(findingVector.get(i).getFatherMoney()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteByMotherMoney(Integer motherMoney, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (motherMoney.equals(findingVector.get(i).getMotherMoney()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteBySisterNumber(Integer sisterNumber, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (sisterNumber.equals(findingVector.get(i).getNumberOfSisters()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public List<Student> findNoteByBrotherNumber(Integer brotherNumber, List<Student> findingVector) {
		List<Student> needToFind = new ArrayList<>();

		for (int i = 0; i < findingVector.size(); i++) {
			if (brotherNumber.equals(findingVector.get(i).getNumberOfBrothers()))
				needToFind.add(findingVector.get(i));
		}
		return needToFind;
	}

	public void loadFile(String nameOfFile) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			SaxParser saxParser = new SaxParser();
			parser.parse(new File(nameOfFile), saxParser);
			table = saxParser.getResult();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
