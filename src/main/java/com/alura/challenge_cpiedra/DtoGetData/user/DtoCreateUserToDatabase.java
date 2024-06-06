package com.alura.challenge_cpiedra.DtoGetData.user;

import com.alura.challenge_cpiedra.models.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateUserToDatabase (String username,
                                       String email,
                                       String passwordEncrypted,
                                       Profile typeOfProfile){
}
