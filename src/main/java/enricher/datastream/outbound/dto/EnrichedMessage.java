package enricher.datastream.outbound.dto;

import enricher.datastream.inbound.dto.Payload;
import enricher.elastic.domain.MessageDoc;

public class EnrichedMessage {
	
	private String status;

	private Payload payload;
	
	private MessageDoc messageDoc;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public MessageDoc getMessageDoc() {
		return messageDoc;
	}

	public void setMessageDoc(MessageDoc messageDoc) {
		this.messageDoc = messageDoc;
	}



	

}