package enricher.dto;

import enricher.domain.Foo;

public class EnrichedMessage {
	
	private String status;

	private FooMsg payload;
	
	private Foo foo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FooMsg getPayload() {
		return payload;
	}

	public void setPayload(FooMsg payload) {
		this.payload = payload;
	}

	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	

}