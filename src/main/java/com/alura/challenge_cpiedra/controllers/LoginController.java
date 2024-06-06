package com.alura.challenge_cpiedra.controllers;

import com.alura.challenge_cpiedra.DtoGetData.user.DtoLoginDataUser;
import com.alura.challenge_cpiedra.DtoResponses.user.DtoResponseTokenData;
import com.alura.challenge_cpiedra.Services.ServiceUser;
import com.alura.challenge_cpiedra.databaseRepositories.*;
import com.alura.challenge_cpiedra.models.*;
import com.alura.challenge_cpiedra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    ServiceUser serviceUser;

    @PostMapping
    @Operation(summary = "Receive the username and password and it returns a JWT with authentication data", tags = "Authentication")
    public ResponseEntity checkAuthentication(@RequestBody DtoLoginDataUser dtoLoginDataUser)
    {
        return ResponseEntity.ok(serviceUser.authenticateUser(dtoLoginDataUser));
    }
}
