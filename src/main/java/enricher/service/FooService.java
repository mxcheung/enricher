package enricher.service;

import enricher.domain.Foo;
import enricher.dto.EnrichedMessage;
import enricher.dto.FooMsg;

public interface FooService {

	void loadFoos();

	EnrichedMessage save(FooMsg fooMsg);

		
}