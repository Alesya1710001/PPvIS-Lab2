package SaxParser;

import model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Vector;


public class SaxParser extends DefaultHandler {
	
	Vector<Student> array=new Vector<Student>(0);
	Student item = null;
    String thisElement = "";

    public Vector<Student> getResult(){
        return array;
    }
    
    public void startDocument()  {
        System.out.println("Start parse XML...");
    }
    
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)  {

        thisElement = qName;
        if(thisElement.equals("note"))
            item = new Student();
    }
    
    public void endElement(String namespaceURI, String localName, String qName) {
        if(qName.equals("note"))
            array.addElement(item);
        thisElement = "";
    }
    
    public void characters(char[] ch, int start, int length) {
    	
    	if (thisElement.equals("studentName")) {
            item.setStudentName(new String(ch, start, length));
        }
    	
    	if (thisElement.equals("fatherName")) {
            item.setFatherName(new String(ch, start, length));
        }
    	
    	if (thisElement.equals("motherName")) {
            item.setMotherName(new String(ch, start, length));
        }
    	
    	if (thisElement.equals("fatherMoney")) {
            item.setFatherMoney(Integer.valueOf(new String(ch, start, length)));
        }
    	
    	if (thisElement.equals("motherMoney")) {
            item.setMotherMoney(Integer.valueOf(new String(ch, start, length)));
        }
    	
    	if (thisElement.equals("sisterNumber")) {
            item.setNumberOfSisters(Integer.valueOf(new String(ch, start, length)));
        }
    	
    	if (thisElement.equals("brotherNumber")) {
            item.setNumberOfBrothers(Integer.valueOf(new String(ch, start, length)));
        }
    	
    }
    
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }

}
