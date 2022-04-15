package com.example.customvalidation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SearchController {

    @PostMapping("/search")
    private SearchRequest search(@RequestBody @Valid SearchRequest searchRequest) {
        System.out.println("request: " + searchRequest);
        return searchRequest;
    }
}