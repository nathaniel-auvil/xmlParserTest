package com.comcast.spotlight.sis;

import org.junit.Test;

import com.comcast.spotlight.XmlParser;
import com.comcast.spotlight.XmlParserN;

public class XmlParserTest {

	@Test
	public void testParse() {

		int ITERATIONS = 1;
		XmlParser s = null;

		/*
		 * String xml =
		 * "<soap:Envelope xmlns:soap=\"http://www.w3.org/2001/12/soap-envelope\" soap:encodingStyle=\"http://www.w3.org/2001/12/soap-encoding\">"
		 * ; xml +=
		 * "<soap:Body xmlns:m=\"http://www.example.org/stock\"> <m:GetStockPriceResponse messageId=\"ewfwefwe\" identity=\"efwew\">"
		 * ; xml += "<m:Price value2 = \"55.99\">34.5</m:Price>"; xml +=
		 * "</m:GetStockPriceResponse></soap:Body></soap:Envelope>";
		 */

		String xml = "<SISQueryRequest messageId=\"consumer-345\" system=\"SISClient\" version=\"1.0\" identity=\"40DA910E-01AF-5050-C7EA-5D7B4A475311\" xmlns=\"http://www.scte.org/schemas/130-6/2010/sis\" xmlns:core=\"http://www.scte.org/schemas/130-2/2008a/core\" xmlns:gis=\"http://www.scte.org/schemas/130-8/2010a/gis\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.scte.org/schemas/130-6/2010/sis 	SCTE_130-6_2010.xsd\">";
		xml += "<gis:Query queryId=\"233\" expandOutput=\"false\"><gis:ServiceDataModel>http://SuperDemograpics.com</gis:ServiceDataModel><gis:UniqueQualifier><gis:Qualifier name=\"MACAddress\" value=\"00-1e-c2-01-d3-2d\"/></gis:UniqueQualifier></gis:Query></SISQueryRequest>";

		long start = System.currentTimeMillis();
		for (int i = 0; i < ITERATIONS; i++) {
			s = new XmlParserN();
			s.parse(xml);
		}
		long stop = System.currentTimeMillis();
		System.out.println("N   " + (stop - start) + " ms");
		System.out.println(s);
	}
}
