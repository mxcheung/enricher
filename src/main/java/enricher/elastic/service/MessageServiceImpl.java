package enricher.elastic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import enricher.datastream.inbound.dto.Employee;
import enricher.datastream.inbound.dto.Payload;
import enricher.datastream.outbound.dto.EnrichedMessage;
import enricher.elastic.domain.MessageDoc;
import enricher.elastic.repository.MessageDocRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDocRepository messageDocRepository;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void loadMessageDocs() {
		List<MessageDoc> foos = new ArrayList<MessageDoc>();
		String account1 = "account1";
		MessageDoc foo1 = new MessageDoc();
		foo1.setName(account1);
		foos.add(foo1);
		messageDocRepository.save(foos);
	}

	@Override
	public EnrichedMessage save(Payload payload) throws JsonProcessingException {
		
		String json = mapper.writeValueAsString(payload);
		MessageDoc messageDoc = messageDocRepository.findByName(payload.getName());
		String status = "New";
		if (messageDoc == null) {
			messageDoc = new MessageDoc();
			messageDoc.setName(payload.getName());
			messageDoc.setMessage(json);
			status = "New";
			messageDocRepository.save(messageDoc);
		} else {
			if (json.equals(messageDoc.getMessage())) {
				status = "Duplicate";
			} else {
				status = "Update";
				messageDoc.setMessage(json);
				messageDocRepository.save(messageDoc);
			}
		}
		EnrichedMessage enrichedMessage = new  EnrichedMessage();
		enrichedMessage.setStatus(status);
		enrichedMessage.setPayload(payload);
		enrichedMessage.setMessageDoc(messageDoc);
		return enrichedMessage;
	}




}