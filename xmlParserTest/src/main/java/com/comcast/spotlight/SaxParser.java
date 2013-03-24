package com.comcast.spotlight;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {

	static SAXParserFactory factory;
	static
	{
		factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
	}
	
	protected String messageId;
	protected String identity;
	protected String value;
	protected String queryId;

	@Override
	public String toString() {
		return "SaxParser [messageId=" + messageId + ", identity=" + identity + ", value=" + value + ", queryId=" + queryId + "]";
	}

	public void parse(String xml) throws Throwable {
		//SAXParserFactory factory = SAXParserFactory.newInstance();
		//factory.setNamespaceAware(true);
		SAXParser parser = factory.newSAXParser();
		parser.parse(new InputSource(new StringReader(xml)), this);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		//System.out.println("uri: " + uri);
		//System.out.println("localName: " + localName);
		//System.out.println("qName: " + qName);

		if (localName.equalsIgnoreCase("SISQueryRequest")) {
			this.identity = attributes.getValue("identity");
			this.messageId = attributes.getValue("messageId");
		}
		else if (localName.equalsIgnoreCase("Query")) {
			this.queryId = attributes.getValue("queryId");
		}
		else if (localName.equalsIgnoreCase("Qualifier")) {
			this.value = attributes.getValue("value");
		}

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		/*
		 * if (firstName) { name = new String(ch, start, length);
		 * System.out.println("First name is : " + name); firstName = false; }
		 */
	}
}
