import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CardParser {
    Document doc;

    public CardParser(String xmlPath){
        loadXmlDocument(xmlPath);
        this.parse();
    }


    public void loadXmlDocument(String xmlPath){
        try {
            File file = new File(xmlPath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            this.doc = dBuilder.parse(file);
            this.doc.getDocumentElement().normalize();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void parse(){
        NodeList nList = doc.getElementsByTagName("Dino");

        for (int i=0;i<nList.getLength();i++){

            Node node = nList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;
            String name = element.getAttribute("name");
            Card card = new Card(name);
            setAttributeValues(card, element);
        System.out.println(card.getName());
        }
    }

    private void setAttributeValues(Card card, Element element){
        Element attributesNode = (Element) element.getElementsByTagName("Attributes").item(0);

        NodeList attributeList = attributesNode.getElementsByTagName("Attr");

        int[] values = new int[4];

        for (int i=0; i<attributeList.getLength();i++){
            Element attr = (Element) attributeList.item(i);
            // String type = attr.getAttribute("type");
            int value = Integer.valueOf(attr.getTextContent());
            values[i] = value;
        }
        card.setValues(values);
    }

}