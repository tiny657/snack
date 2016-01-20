package com.snack.attachment;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Component
public class AttachmentUtils {

	final String PATH = "attach";

	public void write(MultipartFile file, String filename, Integer id) {
		FileOutputStream fos = null;
		try {
			byte fileData[] = file.getBytes();
			fos = new FileOutputStream(PATH + "/" + id);
			fos.write(fileData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	public byte[] read(String filename) {
		FileInputStream fis = null;
		byte[] bytes = new byte[0];
		try {
			fis = new FileInputStream(PATH + "/" + filename);
			bytes = IOUtils.toByteArray(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fis);
		}

		return bytes;
	}
}
