package com.alura.challenge_cpiedra.controllers;

import com.alura.challenge_cpiedra.Services.ServiceTopic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicsorder")
@SecurityRequirement(name = "bearer-key")
public class TopicsOrderController
{
    @Autowired
    ServiceTopic serviceTopic;

    @GetMapping
    @Operation(summary = "Return the last records of topics", tags = "Get")
    public ResponseEntity getAllTopics(@PageableDefault(size = 10) Pageable pagination)
    {
        return ResponseEntity.ok(serviceTopic.findLastTenRecords());
    }
}
