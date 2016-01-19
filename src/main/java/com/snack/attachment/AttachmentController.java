package com.snack.attachment;

import com.snack.document.AttachmentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private AttachmentUtils attachmentUtils;

	@RequestMapping(value = "{filename}", method = RequestMethod.GET)
	public @ResponseBody byte[] read(@PathVariable String filename) {
		return attachmentUtils.read(filename);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity attach(MultipartHttpServletRequest request) {
		try {
			Iterator<String> iterator = request.getFileNames();

			while (iterator.hasNext()) {
				String uploadedFile = iterator.next();
				MultipartFile file = request.getFile(uploadedFile);
				Attachment dto = new Attachment();
				dto.setFilename(file.getOriginalFilename());
				dto.setMimeType(file.getContentType());
				dto.setRegDate(new Date());
				dto = attachmentService.save(dto);
				attachmentUtils.write(file, dto.getFilename(), dto.getId());
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
}
