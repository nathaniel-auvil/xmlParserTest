package com.comcast.spotlight;

import java.util.HashMap;
import java.util.Map;

public class XmlParserN extends XmlParser {

	public void parse(String xml) {

		Map<String, String> values = new HashMap<String, String>(32);
		int elementStart = -1;
		String element;
		int space = -1;
		int valueStart = -1;

		int attributeStart = -1;
		String attribute = null;

		for (int i = 0; i < xml.length(); i++) {
			System.out.println("xml.charAt(" + i + "): " + xml.charAt(i));

			switch (xml.charAt(i)) {

			case '<':
				elementStart = i;
				break;

			case '>':
				elementStart = -1;
				break;

			case ' ':
				if (attributeStart == -1) {
					while (xml.charAt(++i) == ' ');
					attributeStart = i;
				}
				else {
					// while (xml.charAt(++i) == ' ');
					attribute = xml.substring(attributeStart, i);
					// attributeStart = -1;
				}

				break;

			case '=':
				attribute = xml.substring(attributeStart, i);

				// --after an equals, we can only have space or double quote to close
				while (attributeStart != -1) {
					switch (xml.charAt(++i)) {

					case '"':
						if (valueStart == -1) {
							// valueStart = i + 1;
							valueStart = ++i;
						}
						else {
							values.put(attribute, xml.substring(valueStart, i));
							valueStart = -1;
							attributeStart = -1;
						}

						break;

					case ' ':
						break;
					}
				}

				break;
			}
		}

		System.out.println(values);

		this.messageId = values.get("messageId");
		this.identity = values.get("identity");
		this.value = values.get("value");
		this.queryId = values.get("queryId");
	}

}
