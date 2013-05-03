
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class XMLReader {
	
	private File xmlFile;
	
	public XMLReader(){
		xmlFile = new File("C:/Users/computer/git/myLocalGitRepo/BankExercise1/src/bankConfig.xml");
	}
	public NodeList readNodeFromFile(String node){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			//optional, but recommended
			doc.getDocumentElement().normalize();
			
			return doc.getElementsByTagName(node);
		 
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
	 
	  
	 
	