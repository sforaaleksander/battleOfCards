package com.codecool.battle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CardParser {
    private Document doc;
    private CardRepository cardRepository;

    public CardParser(String xmlPath) {
        this.cardRepository = new CardRepository();
        loadXmlDocument(xmlPath);
        this.parse();
        this.loadCardImages();
    }

    private void loadCardImages() {
        try {
            for (Card card : cardRepository.getCards()) {
                card.setImage(readTxt(card.getName()));
                System.out.println(card.getImage());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private String[] readTxt(String dinoName) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String fileName = currentDirectory + "/src/main/resources/images/" + dinoName.toLowerCase() + ".txt";
        Path path = Paths.get(fileName);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int lineCount = (int) Files.lines(path).count();

        String[] lines = new String[lineCount];
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lines[i++] = line;
        }
        bufferedReader.close();
        return lines;

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
            String name = element.getAttribute("name").toUpperCase();
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
            String type = attr.getAttribute("type").toUpperCase();
            int value = Integer.valueOf(attr.getTextContent());

            card.setAttributeByType(type, value);
        }
    }
}
