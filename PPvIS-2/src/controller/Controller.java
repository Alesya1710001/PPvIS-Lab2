package controller;

import model.Student;
import SaxParser.SaxParser;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Controller {

	private List <Student> table = new ArrayList<>();
	
	public List<Student> getTable()
    {
        return table;
    }
	
	public void setItem(Student item)
    {
        table.add(item);
    }
	
	public void deleteElement(List<Student> needDeleteElement)
	    {
	        for(int i=0;i<needDeleteElement.size();i++)
	            table.remove(needDeleteElement.get(i));
	    }

    public List<Student> findNoteByStudentName(String studentName, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(studentName.equals(findingVector.get(i).getStudentName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteByFatherName(String fatherName, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(fatherName.equals(findingVector.get(i).getFatherName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteByMotherName(String motherName, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(motherName.equals(findingVector.get(i).getMotherName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteByFatherMoney(Integer fatherMoney, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(fatherMoney.equals(findingVector.get(i).getFatherMoney()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteByMotherMoney(Integer motherMoney, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(motherMoney.equals(findingVector.get(i).getMotherMoney()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteBySisterNumber(Integer sisterNumber, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(sisterNumber.equals(findingVector.get(i).getNumberOfSisters()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }
    
    public List<Student> findNoteByBrotherNumber(Integer brotherNumber, List<Student> findingVector)
    {
        List<Student> needToFind=new ArrayList<>();

        for(int i=0;i<findingVector.size();i++)
        {
            if(brotherNumber.equals(findingVector.get(i).getNumberOfBrothers()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public void save(String nameOfFile) {
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
    
    public void loadFile(String nameOfFile)
    {
        SAXParserFactory factory =SAXParserFactory.newInstance();
        SAXParser parser = null;
        try
        {
            parser = factory.newSAXParser();
            SaxParser saxParser = new SaxParser();
            parser.parse(new File(nameOfFile), saxParser);
            table= saxParser.getResult();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    
    
   
    
    

}
