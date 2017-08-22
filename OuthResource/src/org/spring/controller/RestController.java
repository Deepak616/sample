package org.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resource")
public class RestController {
	
	@RequestMapping(value="/getValue",method=RequestMethod.GET)
	@ResponseBody public String getValue(){
		return "\"protected value\"";
	}

}
