package com.resilience4j.example.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resilience4j.example.model.Activity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RequestMapping("/activity")
@RestController
public class ActivityController {

    private RestTemplate restTemplate;

    private final String BORED_API = "https://www.boredapi.com/api/activity";
    


    public ActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    public String getRandomActivity() {
        ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
        Activity activity = responseEntity.getBody();
        System.out.println("Activity received: " + activity.getActivity());
        return activity.getActivity();
    }

    public String fallbackRandomActivity(Throwable throwable) {
        return "Watch a video from TechPrimers";
    }

}

