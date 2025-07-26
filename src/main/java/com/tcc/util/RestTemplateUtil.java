package com.tcc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestTemplateUtil {

	private static final String BEARER = "Bearer ";

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	LoggerUtil log;

	private HttpComponentsClientHttpRequestFactory clientHttpRequestFactory;

	public <T> ResponseEntity<T> sendRequest(UriComponentsBuilder uri, HttpMethod method, Object body,
			Class<T> classOfT, boolean apigeeToken, String function, String idProcess) throws RestClientException {

		this.clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		this.restTemplate = new RestTemplate(clientHttpRequestFactory);

		long startTimeTry = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
	
		HttpEntity<Object> entity = null;
		entity = (body != null) ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
		ResponseEntity<T> resp = restTemplate.exchange(uri.toUriString(), method, entity, classOfT);
		long endTimeConn = System.currentTimeMillis() - startTimeTry;
		log.infoService(String.valueOf(idProcess), uri.toUriString(), body, resp.getBody(), function, endTimeConn);
		return resp;
	}

}
