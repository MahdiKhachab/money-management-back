package com.alzahraa.money.manegment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alzahraa.money.manegment.entity.PublicContent;
import com.alzahraa.money.manegment.enums.ContentType;

public interface PublicContentService {

	public List<PublicContent> getAllPublicContent();

	public PublicContent getPublicContentById(Long id);

	public PublicContent createPublicContent(String title, String description, ContentType type,
			MultipartFile attachment);

	public PublicContent updatePublicContent(Long id, String title, String description, ContentType type,
			MultipartFile attachment);

	public void deletePublicContent(Long id);

}
