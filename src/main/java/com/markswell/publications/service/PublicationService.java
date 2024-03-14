package com.markswell.publications.service;

import com.markswell.publications.domain.Publication;

import java.util.List;

public interface PublicationService {
    void insert(Publication publication);

    List<Publication> findAll();

    Publication findById(String id);
}
