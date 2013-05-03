import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//read from xml file example
		try{
			XMLReader xmlR = new XMLReader();
			NodeList res = xmlR.readNodeFromFile("atm");
			for(int i=0; i<res.getLength(); i++){
				Node nNode = res.item(i);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					System.out.println("Staff id : " + eElement.getAttribute("id"));
				}
			}
		
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
