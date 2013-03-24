package com.comcast.spotlight;

public class XmlParserSAX extends XmlParser {

	@Override
	public void parse(String xml) {

		SaxParser s = new SaxParser();
		try {
			s.parse(xml);
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
