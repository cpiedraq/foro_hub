package com.alura.challenge_cpiedra.DtoGetData.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoCreateUser (@NotBlank String username,
                             @Email String email,
                             @NotBlank String password,
                             @NotNull Integer typeOfProfile
                             )
{
}
