package com.snack.document;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachedFileService {

	@Autowired
	private AttachedFileRepository attachedFileRepository;

	// Retrieve file
	public FileUpload findByFilename(String filename) {
		return attachedFileRepository.findByFilename(filename);
	}

	// Upload the file
	public void upload(AttachedFile attachedFile) {
		attachedFileRepository.saveAndFlush(attachedFile);
	}
}
