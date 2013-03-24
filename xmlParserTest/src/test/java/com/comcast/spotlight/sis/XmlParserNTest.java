package com.comcast.spotlight.sis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.comcast.spotlight.XmlParser;
import com.comcast.spotlight.XmlParserN;

public class XmlParserNTest {

	@Test
	public void testEasy() {
		String xml = "<SISQueryRequest messageId=\"consumer-345\" identity=\"40DA910E-01AF-5050-C7EA-5D7B4A475311\"\\>";

		XmlParser s = new XmlParserN();
		s.parse(xml);

		assertTrue(s.getMessageId().equals("consumer-345"));
		assertTrue(s.getIdentity().equals("40DA910E-01AF-5050-C7EA-5D7B4A475311"));
		assertNull(s.getQueryId());
		assertNull(s.getValue());
	}

	@Test
	public void testEasySingleSpaces() {
		String xml = "<SISQueryRequest messageId = \"consumer-345\" identity=\"40DA910E-01AF-5050-C7EA-5D7B4A475311\"\\>";

		XmlParser s = new XmlParserN();
		s.parse(xml);

		assertTrue(s.getMessageId().equals("consumer-345"));
		assertTrue(s.getIdentity().equals("40DA910E-01AF-5050-C7EA-5D7B4A475311"));
		assertNull(s.getQueryId());
		assertNull(s.getValue());
	}

	@Test
	public void testEasyMultiSpaces() {
		String xml = "<SISQueryRequest     messageId    =    \"consumer-345\"         identity=\"40DA910E-01AF-5050-C7EA-5D7B4A475311\"\\>";

		XmlParser s = new XmlParserN();
		s.parse(xml);

		assertTrue(s.getMessageId().equals("consumer-345"));
		assertTrue(s.getIdentity().equals("40DA910E-01AF-5050-C7EA-5D7B4A475311"));
		assertNull(s.getQueryId());
		assertNull(s.getValue());
	}
}
