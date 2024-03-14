package com.markswell.publications.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.markswell.publications.domain.Publication;
import com.markswell.publications.mapper.PublicationMapper;
import com.markswell.publications.service.PublicationService;
import com.markswell.publications.repository.PublicationRepository;
import com.markswell.publications.exception.PublicationNotFoundException;

import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final MessageSource messageSource;
    private final PublicationMapper mapper;
    private final CommentServiceImpl commentService;
    private final PublicationRepository repository;

    @Override
    public void insert(Publication publication) {
        var entity = mapper.toPublicationEntity(publication);
        repository.save(entity);
    }

    @Override
    public List<Publication> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toPublication)
                .toList();
    }

    @Override
    public Publication findById(String id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PublicationNotFoundException(messageSource.getMessage("publication.not_found", null, Locale.getDefault() ).formatted(id)));
        var comments = commentService.getComments(id);
        var publication = mapper.toPublication(entity);
        publication.setComments(comments);
        return publication;
    }

}
