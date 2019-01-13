package enricher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import enricher.domain.Foo;
import enricher.dto.EnrichedMessage;
import enricher.dto.FooMsg;
import enricher.repository.FooRepository;

@Service
public class FooServiceImpl implements FooService {

	@Autowired
	private FooRepository fooRepository;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void loadFoos() {
		List<Foo> foos = new ArrayList<Foo>();
		String account1 = "account1";
		String account2 = "account2";
		Foo foo1 = new Foo();
		foo1.setName(account1);
		foos.add(foo1);
		fooRepository.save(foos);
	}

	@Override
	public EnrichedMessage save(FooMsg fooMsg) {
		
		Foo foo = fooRepository.findByName(fooMsg.getName());
		String status = "New";
		if (foo == null) {
		    foo = new Foo();
			foo.setName(fooMsg.getName());
			foo.setComments(fooMsg.getComments());
			status = "New";
			fooRepository.save(foo);
		} else {
			FooMsg prevMsg = new FooMsg();
			prevMsg.setName(foo.getName());
			prevMsg.setComments(foo.getComments());
			if (prevMsg.equals(fooMsg)) {
				status = "Duplicate";
			} else {
				foo.setName(fooMsg.getName());
				foo.setComments(fooMsg.getComments());
				status = "Update";
				fooRepository.save(foo);
			}
		}
		EnrichedMessage enrichedMessage = new  EnrichedMessage();
		enrichedMessage.setStatus(status);
		enrichedMessage.setPayload(fooMsg);
		enrichedMessage.setFoo(foo);
		return enrichedMessage;
	}




}