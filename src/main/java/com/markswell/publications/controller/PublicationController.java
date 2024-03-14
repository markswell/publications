package com.markswell.publications.controller;

import com.markswell.publications.domain.Publication;
import com.markswell.publications.mapper.PublicationMapper;
import com.markswell.publications.service.impl.PublicationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markswell.publications.controller.request.PublicationRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publication")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationMapper mapper;
    private final PublicationServiceImpl service;

    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid PublicationRequest request) {
        var publication = mapper.toPublication(request);
        service.insert(publication);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Publication>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
