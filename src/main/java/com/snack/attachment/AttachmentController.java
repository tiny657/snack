package com.snack.attachment;

import com.snack.document.FileWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Date;
import java.util.Iterator;

@Slf4j
@Controller
@RequestMapping("/attach")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;

	@Autowired
	private FileWriter fileWriter;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity attach(MultipartHttpServletRequest request) {
		try {
			Iterator<String> iterator = request.getFileNames();

			while (iterator.hasNext()) {
				final String PATH = "attach";
				String uploadedFile = iterator.next();
				MultipartFile file = request.getFile(uploadedFile);
				Attachment dto = new Attachment();
				dto.setRegDate(new Date());
				dto.setFilename(file.getOriginalFilename());
				dto.setMimeType(file.getContentType());
				fileWriter.writeFile(file, PATH, dto.getFilename());
				attachmentService.upload(dto);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
}
