package com.alura.challenge_cpiedra.controllers;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateResponse;
import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateResponseToDatabase;
import com.alura.challenge_cpiedra.DtoGetData.topics.DtoUpdateResponse;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponsesInfoOfResponsesTopic;
import com.alura.challenge_cpiedra.Services.ServicesResponses;
import com.alura.challenge_cpiedra.models.Responses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/responses")
@SecurityRequirement(name = "bearer-key")
public class ResponsesController
{
    @Autowired
    ServicesResponses servicesResponses;

    @GetMapping("/{id}")
    @Operation(summary = "Get the information of specific response by code", tags = "Get")
    public ResponseEntity getResponsesByTopic(@PathVariable Integer id)
    {
        return ResponseEntity.ok(servicesResponses.getResponseById(id));
    }

    @PostMapping
    @Operation(summary = "Get the responses of the specific topic", tags = "Post")
    public ResponseEntity getResponsesByTopic(@RequestBody DtoCreateResponse dtoCreateResponse, UriComponentsBuilder uriComponentsBuilder )
    {
        DtoResponsesInfoOfResponsesTopic dtoResponsesInfoOfResponsesTopic = servicesResponses.createResponse(dtoCreateResponse);

        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(dtoResponsesInfoOfResponsesTopic.codeResponse()).toUri();

        return ResponseEntity.created(url).body(dtoResponsesInfoOfResponsesTopic);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the information of the response", tags = "Put")
    @Transactional
    public ResponseEntity updateResponseData(@PathVariable Integer id, @RequestBody DtoUpdateResponse dtoUpdateResponse)
    {
        return ResponseEntity.ok(servicesResponses.updateResponse(Long.valueOf(id), dtoUpdateResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a response using the code", tags = "Delete")
    @Transactional
    public ResponseEntity deleteResponseData(@PathVariable Integer id)
    {
        return ResponseEntity.ok(servicesResponses.deleteResponse(Long.valueOf(id)));
    }

}
