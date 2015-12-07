package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Skill {
	@Id
	@GeneratedValue
	@Column(name = "skill_id")
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<DocumentSkill> documents;

	private Integer documentCount;

	private Integer point;
}
