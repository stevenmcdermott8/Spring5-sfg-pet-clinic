package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * stevmc created on 2/11/20
 */
@Controller
public class IndexController {

	@RequestMapping({ "/", "", "index", "index.html" })
	public String index() {
		return "index";
	}
}
