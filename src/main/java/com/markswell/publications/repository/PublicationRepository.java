package com.markswell.publications.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.markswell.publications.repository.entity.PublicationEntity;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity, String> {
}
