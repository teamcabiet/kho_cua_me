package inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControll {
	@GetMapping ("/")
	public String index() {
		return "index";
	}
}
