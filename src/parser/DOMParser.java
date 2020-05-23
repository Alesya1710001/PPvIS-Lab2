package parser;

import model.Student;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class DOMParser 
{
	private List <Student> table = new ArrayList<>();
	
	public void setTable(List<Student> tempTable) 
	{
		table = tempTable;
	}
	
	public void save(String nameOfFile) 
	{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element root = document.createElement("base");
        document.appendChild(root);
        for (int i = 0; i < table.size(); i++) {
            Element note = document.createElement("note");
            
            Element studentNameElement = document.createElement("studentName");
            Element fatherNameElement = document.createElement("fatherName");
            Element motherNameElement = document.createElement("motherName");
            Element fatherMoneyElement = document.createElement("fatherMoney");
            Element motherMoneyElement = document.createElement("motherMoney");
            Element sisterElement = document.createElement("sisterNumber");
            Element brotherElement = document.createElement("brotherNumber");
            
            Text studentName = document.createTextNode(table.get(i).getStudentName());
            Text fatherName = document.createTextNode(table.get(i).getFatherName());
            Text motherName = document.createTextNode(table.get(i).getMotherName());
            Text fatherMoney = document.createTextNode(Integer.toString(table.get(i).getFatherMoney()));
            Text motherMoney = document.createTextNode(Integer.toString(table.get(i).getMotherMoney()));
            Text sisterNumber = document.createTextNode(Integer.toString(table.get(i).getNumberOfSisters()));
            Text brotherNumber = document.createTextNode(Integer.toString(table.get(i).getNumberOfBrothers()));
            
            note.appendChild(studentNameElement);
            note.appendChild(fatherNameElement);
            note.appendChild(motherNameElement);
            note.appendChild(fatherMoneyElement);
            note.appendChild(motherMoneyElement);
            note.appendChild(sisterElement);
            note.appendChild(brotherElement);
            
            studentNameElement.appendChild(studentName);
            fatherNameElement.appendChild(fatherName);
            motherNameElement.appendChild(motherName);
            fatherMoneyElement.appendChild(fatherMoney);
            motherMoneyElement.appendChild(motherMoney);
            sisterElement.appendChild(sisterNumber);
            brotherElement.appendChild(brotherNumber);
            
            root.appendChild(note);
                        
        }
        
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        try {
            transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(nameOfFile)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

}
