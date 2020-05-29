package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {

    public static final String STRING_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
            "<first>" +
                "<second>some string</second>" +
                "<second>some string</second>" +
                "<second><![CDATA[need CDATA because of < and >]]></second><second/>" +
            "</first>";

    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String result = null;

        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(obj, writer);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setCoalescing(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(writer.toString())));
            doc.getDocumentElement().normalize();

            NodeList listNode = doc.getElementsByTagName(tagName);

            for (int i = 0; i < listNode.getLength(); i++) {
                Node n = listNode.item(i);
                n.getParentNode().insertBefore(doc.createComment(comment), n);
            }
            result = getStringFromDocument(doc);
        } catch (JAXBException | ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getStringFromDocument(Document doc) throws TransformerException {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.STANDALONE, "no");
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(doc), new StreamResult(out));
        return out.toString();
    }

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(First.class);
            First first = (First) context.createUnmarshaller().unmarshal(new StringReader(STRING_XML));
            System.out.println(first.toString() + "\n");

            System.out.println(toXmlWithComment(first, "second", "it's a comment"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
