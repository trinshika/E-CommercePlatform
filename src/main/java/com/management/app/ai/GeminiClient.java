package com.management.app.ai;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GeminiClient {

	@Autowired
	RestTemplate restTemplate;

	@Value("${gemini.url}")
	String url;

	@Value("${gemini.apikey}")
	String apiKey;

	@Value("${gemini.prompt}")
	String prompt;

	public String getQuoteForMail() throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-goog-api-key", apiKey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> part = new HashMap<>();
		part.put("text", prompt);

		Map<String, Object> contentItem = new HashMap<>();
		contentItem.put("parts", Collections.singletonList(part));

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("contents", Collections.singletonList(contentItem));

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

//		System.out.println(response.getBody());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		
		JsonNode js = root.get("candidates");

		return root.get("candidates").get(0).get("content").get("parts").get(0).get("text").asText();


	}


}
