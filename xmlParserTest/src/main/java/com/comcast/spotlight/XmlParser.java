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

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

}
