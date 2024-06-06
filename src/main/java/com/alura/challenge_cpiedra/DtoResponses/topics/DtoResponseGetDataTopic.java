package com.alura.challenge_cpiedra.DtoResponses.topics;

import com.alura.challenge_cpiedra.DtoResponses.user.DtoUser;

import java.time.LocalDateTime;
import java.util.List;

public record DtoResponseGetDataTopic(Integer id,
                                      String title,
                                      String message,
                                      LocalDateTime creationDate,
                                      String status,
                                      DtoUser user,
                                      String course,
                                      List<DtoResponseTopic> listResponses
                               )
{

}
