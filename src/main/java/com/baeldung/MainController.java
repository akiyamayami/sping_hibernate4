package com.baeldung;

import com.baeldung.persistence.model.Foo;
import com.baeldung.persistence.service.IFooService;
import com.baeldung.persistence.service.impl.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@RestController
public class MainController {

	@Autowired
	private IFooService fooService;

	@GetMapping("/")
	public String home(){
        fooService.create(new Foo(randomAlphabetic(6)));
		return fooService.findAll().toString();
	}
}
