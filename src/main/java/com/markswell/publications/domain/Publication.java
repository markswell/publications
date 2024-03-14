package com.markswell.publications.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Publication {

    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments;

}
