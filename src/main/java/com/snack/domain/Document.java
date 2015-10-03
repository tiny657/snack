package com.snack.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Document {
	@Id
	@GeneratedValue
	private Integer id;
	private String content;
	private Integer point;
	private Integer love;
	private Integer comment;
	private Integer sharing;
	private String memberId;
	private Date regDate;
}
