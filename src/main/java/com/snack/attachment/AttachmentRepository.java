package com.snack.attachment;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
	FileUpload findByFilename(String filename);
}
