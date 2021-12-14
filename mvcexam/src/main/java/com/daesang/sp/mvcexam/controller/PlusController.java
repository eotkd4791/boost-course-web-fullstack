package com.daesang.sp.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	
	@GetMapping(path="/plusform")
	public String plusForm() { //모델앤뷰 객체 또는 문자열 또는 뷰 이름 문자열 가능
		return "plusForm"; // 여기서는 뷰 이름을 문자열로 넘겨준다. 그러면 viewResolver가 찾아서 앞뒤 문자열 붙여서 매칭되는 뷰를 보여줌
	}
	
	@PostMapping(path="/plus")
	public String plus(
		@RequestParam int value1, 
  		@RequestParam int value2, 
        ModelMap modelMap
    ) {	
		int result = value1 + value2;
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result); // spring이 알아서 request scope에 매핑함
		return "plusResult";
	}
}
