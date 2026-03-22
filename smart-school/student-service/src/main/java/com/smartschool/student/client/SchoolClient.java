package com.smartschool.student.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Component
public class SchoolClient {
    private final RestTemplate restTemplate;
    private final String schoolServiceUrl;

    public SchoolClient(RestTemplate restTemplate, @Value("${school.service.url:http://localhost:8081}") String schoolServiceUrl) {
        this.restTemplate = restTemplate;
        this.schoolServiceUrl = schoolServiceUrl;
    }

    public Optional<SchoolRemoteDTO> getSchool(Long id) {
        try {
            SchoolRemoteDTO dto = restTemplate.getForObject(schoolServiceUrl + "/api/schools/" + id, SchoolRemoteDTO.class);
            return Optional.ofNullable(dto);
        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        }
    }
}
