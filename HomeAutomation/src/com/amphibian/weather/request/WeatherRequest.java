package com.amphibian.weather.request;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientResponse;

import com.amphibian.weather.response.WeatherResponse;


public class WeatherRequest {

	private final static String BASE_URL = "http://api.wunderground.com/api/";
	
	private String apiKey;
	
	private Set<Feature> features;
	
	public WeatherRequest() {
		this.apiKey = null;
		this.features = new HashSet<Feature>();
	}
	
	public void setApiKey(String k) {
		this.apiKey = k;
	}
	
	public void addFeature(Feature f) {
		this.features.add(f);
	}
	
	public WeatherResponse query(String country, String city) {
		
		if (this.apiKey == null) {
			return null;
		}
		
		if (this.features.size() == 0) {
			return null;
		}
		
		Client c = ClientBuilder.newClient();
	
		
		String url = BASE_URL + this.apiKey + "/";
		Iterator<Feature> i = this.features.iterator();
		while (i.hasNext()) {
			url += i.next() + "/";
		}
		url += "/lang:DL/q/" +country +"/"+ city + ".json";
		
		WebTarget r = c.target(url);
		Response response = r.request(MediaType.APPLICATION_JSON).get(); //.readEntity(ClientResponse.class);
		WeatherResponse w = response.readEntity(WeatherResponse.class);
		return w;
		
	}
	
	
	public static void main(String[] args) {

	/*	WeatherRequest req = new WeatherRequest();
		req.setApiKey("your_api_key");
		req.addFeature(Feature.CONDITIONS);
		req.addFeature(Feature.FORECAST);
		req.addFeature(Feature.ALERTS);
		WeatherResponse resp = req.query("17084");
		
		System.out.println("Current weather: " + resp.getConditions().getWeather());
		System.out.println("Current temp(F): " + resp.getConditions().getTempF());
		*/
		
	}
	
}
