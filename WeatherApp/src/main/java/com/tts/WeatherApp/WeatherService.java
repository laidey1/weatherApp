package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
	
	private ZipCodeRepository zipcodeRepository; 
	@Autowired
	public WeatherService(ZipCodeRepository zipcodeRepository) 
            {
			this.setZipcodeRepository(zipcodeRepository);
}
	public ZipCodeRepository getZipcodeRepository() {
		return zipcodeRepository;
	}

	public void setZipcodeRepository(ZipCodeRepository zipcodeRepository) {
		this.zipcodeRepository = zipcodeRepository;
	}
	
	

	 @Value("${api_key}")//bring in api key and assign to api jey variable below
	    private String apiKey;

//	 public Response getForecast(String zipCode) {//getForcast method
//		    String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
//		        zipCode + ",us&units=imperial&appid=" + apiKey;//call by zip code in weatherMap app
//		   //if you want to test : System.out.printlm("url: "+url);
//		    RestTemplate restTemplate = new RestTemplate();//allows us to pass url to request we are making and return response class
//		    //error handling if zip incorrect
//		    try {
//		        return restTemplate.getForObject(url, Response.class);
//		    }
//		    catch (HttpClientErrorException ex) {
//		        Response response = new Response();
//		        response.setName("error");
//		        return response;
//		    }
//		    
//		}

	 
	 public Response getForecast(String zipCode) {//getForcast method
		    String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
		        zipCode + ",us&units=imperial&appid=" + apiKey;//call by zip code in weatherMap app
		   //if you want to test : System.out.printlm("url: "+url);
		    RestTemplate restTemplate = new RestTemplate();//allows us to pass url to request we are making and return response class
		    //error handling if zip incorrect
		    try {
		        return restTemplate.getForObject(url, Response.class);
		    }
		    catch (HttpClientErrorException ex) {
		        Response response = new Response();
		        response.setName("error");
		        return response;
		    }
		    
		}

	
}
