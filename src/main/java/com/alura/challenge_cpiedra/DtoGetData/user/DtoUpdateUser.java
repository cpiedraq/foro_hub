package com.alura.challenge_cpiedra.DtoGetData.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoUpdateUser(@NotBlank String username,
                            @Email String email,
                            @NotBlank String password,
                            @NotBlank Integer typeOfProfile) {
}