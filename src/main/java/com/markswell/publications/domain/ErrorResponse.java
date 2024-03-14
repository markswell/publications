package com.markswell.publications.domain;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ErrorResponse {

    private Long timestamp;

    private String message;

    private String path;

}
