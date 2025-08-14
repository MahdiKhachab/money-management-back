package com.alzahraa.money.manegment.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alzahraa.money.manegment.entity.PublicContent;
import com.alzahraa.money.manegment.enums.ContentType;
import com.alzahraa.money.manegment.service.PublicContentService;

@RestController
@RequestMapping("/api")
public class PublicContentController {

    private final PublicContentService publicContentService;

    
    public PublicContentController(PublicContentService publicContentService) {
        this.publicContentService = publicContentService;
    }

    // Anyone can access this
    @GetMapping("/public-content")
    public ResponseEntity<List<PublicContent>> getAllPublicContent() {
        List<PublicContent> content = publicContentService.getAllPublicContent();
        return ResponseEntity.ok(content);
    }

    @GetMapping("/public-content/{id}")
    public ResponseEntity<PublicContent> getPublicContentById(@PathVariable Long id) {
        PublicContent content = publicContentService.getPublicContentById(id);
        return ResponseEntity.ok(content);
    }


    @PostMapping("/admin/public-content")
    public ResponseEntity<PublicContent> createPublicContent(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam ContentType type,
            @RequestParam(required = false) MultipartFile attachment) {
        PublicContent newContent = publicContentService.createPublicContent(title, description, type, attachment);
        return new ResponseEntity<>(newContent, HttpStatus.CREATED);
    }

    @PutMapping("/admin/public-content/{id}")
    public ResponseEntity<PublicContent> updatePublicContent(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam ContentType type,
            @RequestParam(required = false) MultipartFile attachment) {
        PublicContent updatedContent = publicContentService.updatePublicContent(id, title, description, type, attachment);
        return ResponseEntity.ok(updatedContent);
    }

    @DeleteMapping("/admin/public-content/{id}")
    public ResponseEntity<Void> deletePublicContent(@PathVariable Long id) {
        publicContentService.deletePublicContent(id);
        return ResponseEntity.noContent().build();
    }
}
