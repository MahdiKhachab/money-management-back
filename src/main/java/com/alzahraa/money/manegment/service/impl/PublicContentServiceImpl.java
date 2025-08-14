package com.alzahraa.money.manegment.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alzahraa.money.manegment.entity.PublicContent;
import com.alzahraa.money.manegment.enums.ContentType;
import com.alzahraa.money.manegment.repository.PublicContentRepository;
import com.alzahraa.money.manegment.service.PublicContentService;

@Service
public class PublicContentServiceImpl implements PublicContentService {

    private static final Logger logger = LoggerFactory.getLogger(PublicContentServiceImpl.class);

    private final PublicContentRepository publicContentRepository;
    private final FileStorageService fileStorageService;

    public PublicContentServiceImpl(PublicContentRepository publicContentRepository, FileStorageService fileStorageService) {
        this.publicContentRepository = publicContentRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public List<PublicContent> getAllPublicContent() {
        try {
            return publicContentRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving all public content", e);
            throw new RuntimeException("Failed to fetch public content list", e);
        }
    }

    @Override
    public PublicContent getPublicContentById(Long id) {
        try {
            return publicContentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Content not found with id: " + id));
        } catch (Exception e) {
            logger.error("Error retrieving public content with ID: {}", id, e);
            throw new RuntimeException("Failed to fetch public content with ID: " + id, e);
        }
    }

    @Override
    public PublicContent createPublicContent(String title, String description, ContentType type, MultipartFile attachment) {
        try {
            PublicContent content = new PublicContent();
            content.setTitle(title);
            content.setDescription(description);
            content.setType(type);
            content.setCreatedAt(LocalDateTime.now());

            if (attachment != null && !attachment.isEmpty()) {
                String fileUrl = fileStorageService.storeFile(attachment);
                content.setAttachmentUrl(fileUrl);
            }

            return publicContentRepository.save(content);
        } catch (Exception e) {
            logger.error("Error creating public content: {}", title, e);
            throw new RuntimeException("Failed to create public content", e);
        }
    }

    @Override
    public PublicContent updatePublicContent(Long id, String title, String description, ContentType type, MultipartFile attachment) {
        try {
            PublicContent existingContent = getPublicContentById(id);
            existingContent.setTitle(title);
            existingContent.setDescription(description);
            existingContent.setType(type);

            if (attachment != null && !attachment.isEmpty()) {
                String fileUrl = fileStorageService.storeFile(attachment);
                existingContent.setAttachmentUrl(fileUrl);
            }

            return publicContentRepository.save(existingContent);
        } catch (Exception e) {
            logger.error("Error updating public content with ID: {}", id, e);
            throw new RuntimeException("Failed to update public content with ID: " + id, e);
        }
    }

    @Override
    public void deletePublicContent(Long id) {
        try {
            publicContentRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting public content with ID: {}", id, e);
            throw new RuntimeException("Failed to delete public content with ID: " + id, e);
        }
    }
}
