package com.snack.attachment;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	// Retrieve file
	public FileUpload findByFilename(String filename) {
		return attachmentRepository.findByFilename(filename);
	}

	// Upload the file
	public void upload(Attachment attachment) {
		attachmentRepository.saveAndFlush(attachment);
	}
}
