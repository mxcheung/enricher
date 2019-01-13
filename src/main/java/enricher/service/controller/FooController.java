package enricher.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import enricher.dto.EnrichedMessage;
import enricher.dto.FooMsg;
import enricher.service.FooService;

@RestController
@RequestMapping("foos")
public class FooController {

	private static final Logger LOG = LoggerFactory.getLogger(FooController.class);

	@Autowired
	private FooService fooService;

	@RequestMapping(value = "/loadFoos", method = RequestMethod.GET)
	public void loadSales() {
		fooService.loadFoos();
	}

	@RequestMapping(value = "/postFoo", method = RequestMethod.POST)
	public @ResponseBody EnrichedMessage postFoo(@RequestBody FooMsg fooMsg) {
		LOG.info(" postFoo");
		return fooService.save(fooMsg);
	}
}