package enricher.datastream.inbound.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import enricher.datastream.inbound.dto.Employee;
import enricher.datastream.outbound.dto.EnrichedMessage;
import enricher.elastic.service.MessageService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/loadMessages", method = RequestMethod.GET)
	public void loadMessages() {
		messageService.loadMessageDocs();
	}

	@RequestMapping(value = "/postEmployee", method = RequestMethod.POST)
	public @ResponseBody EnrichedMessage postEmployee(@RequestBody Employee mmployee) throws JsonProcessingException {
		LOG.info(" postEmployee");
		return messageService.save(mmployee);
	}
}