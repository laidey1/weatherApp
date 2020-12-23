package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
	@Autowired
    private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model) {//output in thymeleaf to display 
				    model.addAttribute("request", new Request());  
		    return "index";
		}
		
		
//	    Response response = weatherService.getForecast("23605");//hard coded zip but we can create a form to have users check zip
//	    //to test System.out.println("Response: "+response);
//	    model.addAttribute("data", response);//pass response object into model
//	    return "index";
	@PostMapping
		public String postIndex(Request request, Model model) {
		    Response data = weatherService.getForecast(request.getZipCode());
		    model.addAttribute("data", data);
		    return "index";
		}
	}


