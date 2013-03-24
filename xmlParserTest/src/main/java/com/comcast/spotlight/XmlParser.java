package com.comcast.spotlight;

public abstract class XmlParser {

	protected String messageId;
	protected String identity;
	protected String value;
	protected String queryId;

	@Override
	public String toString() {
		return "SoapParser [messageId=" + messageId + ", identity=" + identity + ", value=" + value + ", queryId=" + queryId + "]";
	}

	public abstract void parse(String xml);

}
