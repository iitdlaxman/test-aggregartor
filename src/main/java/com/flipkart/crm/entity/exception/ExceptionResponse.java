package com.flipkart.crm.entity.exception;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse {

    @JsonProperty("response_code")
    private ResponseCode responseCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private String messageType = "ERROR";

    @JsonProperty("recommended_message")
    private String recommendedMessage;

}
