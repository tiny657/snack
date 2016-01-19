package com.snack.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	public Attachment save(Attachment attachment) {
		return attachmentRepository.save(attachment);
	}
}
