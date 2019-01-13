package enricher.elastic.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import enricher.datastream.inbound.dto.Employee;
import enricher.datastream.outbound.dto.EnrichedMessage;

public interface MessageService {

	void loadMessageDocs();

	EnrichedMessage save(Employee employee) throws JsonProcessingException;

		
}