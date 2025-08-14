package com.alzahraa.money.manegment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alzahraa.money.manegment.entity.PublicContent;
import com.alzahraa.money.manegment.enums.ContentType;

@Repository
public interface PublicContentRepository extends JpaRepository<PublicContent, Long> {
    // Custom query to find content by type, if needed
    List<PublicContent> findByType(ContentType type);
}
