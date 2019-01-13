package enricher.datastream.outbound.dto;

import enricher.datastream.inbound.dto.Employee;
import enricher.elastic.domain.MessageDoc;

public class EnrichedMessage {
	
	private String status;

	private Employee payload;
	
	private MessageDoc messageDoc;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getPayload() {
		return payload;
	}

	public void setPayload(Employee payload) {
		this.payload = payload;
	}

	public MessageDoc getMessageDoc() {
		return messageDoc;
	}

	public void setMessageDoc(MessageDoc messageDoc) {
		this.messageDoc = messageDoc;
	}


	

}