package com.codecool.battle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CardParser {
    private Document doc;
    private CardRepository cardRepository;

    public CardParser(String xmlPath) {
        this.cardRepository = new CardRepository();
        loadXmlDocument(xmlPath);
        this.parse();
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public void loadXmlDocument(String xmlPath) {
        try {
            File file = new File(xmlPath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.doc = dBuilder.parse(file);
            this.doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void parse() {
        NodeList nList = doc.getElementsByTagName("Dino");

        for (int i = 0; i < nList.getLength(); i++) {

            Node node = nList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;
            String name = element.getAttribute("name");
            Card card = new Card(name);
            setAttributeValues(card, element);

            System.out.println(card.getName());

            this.cardRepository.addCard(card);
        }
    }

    private void setAttributeValues(Card card, Element element) {
        Element attributesNode = (Element) element.getElementsByTagName("Attributes").item(0);

        NodeList attributeList = attributesNode.getElementsByTagName("Attr");

        for (int i = 0; i < attributeList.getLength(); i++) {
            Element attr = (Element) attributeList.item(i);
            String type = attr.getAttribute("type");
            int value = Integer.valueOf(attr.getTextContent());

            card.setAttributeByType(type, value);
        }
    }
}
