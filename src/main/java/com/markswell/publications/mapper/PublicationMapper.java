package com.markswell.publications.mapper;

import com.markswell.publications.controller.request.PublicationRequest;
import com.markswell.publications.domain.Publication;
import com.markswell.publications.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publication);

    Publication toPublication(PublicationRequest request);
}
