package com.snack.repository;

import com.snack.App;
import com.snack.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional
public class InitializeRepositoryTest {
	@Autowired
	UserRepository userRepository;

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	DocumentKeeperRepository documentKeeperRepository;

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	DocumentSkillRepository documentSkillRepository;

	User user1, user2, user3, user4;
	Document document1, document2;
	Comment comment1, comment2;
	DocumentKeeper documentKeeper1, documentKeeper2, documentKeeper3, documentKeeper4;
	Skill skill1, skill2;
	DocumentSkill documentSkill1, documentSkill2;

	@Test
	@Rollback(false)
	public void _deleteAll() {
		userRepository.deleteAll();
		documentRepository.deleteAll();
		commentRepository.deleteAll();
		documentKeeperRepository.deleteAll();
		skillRepository.deleteAll();
		documentSkillRepository.deleteAll();
	}

	@Test
	@Rollback(false)
	public void insertAll() {
		createUser1();
		createUser2();
		createUser3();
		createUser4();
		createDocument1();
		createDocument2();
		createComment1();
		createComment2();
		createDocumentKeeper1();
		createDocumentKeeper2();
		createDocumentKeeper3();
		createDocumentKeeper4();
		createSkill1();
		createSkill2();
		createDocumentSkill1();
		createDocumentSkill2();
	}

	@Test
	public void createUser1() {
		User user = new User();
		user.setUserId("userId1");
		user.setName("name1");
		user.setMyCommentCount(1);
		user.setMyKeepCount(3);
		user1 = userRepository.save(user);
	}

	@Test
	public void createUser2() {
		User user = new User();
		user.setUserId("userId2");
		user.setName("name2");
		user.setMyCommentCount(1);
		user.setMyKeepCount(3);
		user2 = userRepository.save(user);
	}

	@Test
	public void createUser3() {
		User user = new User();
		user.setUserId("userId3");
		user.setName("name3");
		user.setMyCommentCount(1);
		user.setMyKeepCount(3);
		user3 = userRepository.save(user);
	}

	@Test
	public void createUser4() {
		User user = new User();
		user.setUserId("userId4");
		user.setName("name4");
		user.setMyCommentCount(1);
		user.setMyKeepCount(3);
		user4 = userRepository.save(user);
	}

	@Test
	public void createDocument1() {
		Document document = new Document();
		document.setCommentCount(1);
		document.setAuthor(user1);
		document.setContent("content1");
		document.setKeeperCount(2);
		document.setTitle("title1");
		document1 = documentRepository.save(document);
	}

	@Test
	public void createDocument2() {
		Document document = new Document();
		document.setCommentCount(1);
		document.setAuthor(user1);
		document.setContent("content2");
		document.setKeeperCount(2);
		document.setTitle("title2");
		document2 = documentRepository.save(document);
	}

	@Test
	public void createComment1() {
		Comment comment = new Comment();
		comment.setContent("comment_content1");
		comment.setWriter(user1);
		comment.setDocument(document1);
		comment1 = commentRepository.save(comment);
	}

	@Test
	public void createComment2() {
		Comment comment = new Comment();
		comment.setContent("comment_content2");
		comment.setWriter(user1);
		comment.setDocument(document1);
		comment2 = commentRepository.save(comment);
	}

	@Test
	public void createDocumentKeeper1() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document1);
		documentKeeper.setKeeper(user1);
		documentKeeper1 = documentKeeperRepository.save(documentKeeper);
	}

	@Test
	public void createDocumentKeeper2() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document1);
		documentKeeper.setKeeper(user2);
		documentKeeper2 = documentKeeperRepository.save(documentKeeper);
	}

	@Test
	public void createDocumentKeeper3() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document2);
		documentKeeper.setKeeper(user1);
		documentKeeper3 = documentKeeperRepository.save(documentKeeper);
	}

	@Test
	public void createDocumentKeeper4() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document2);
		documentKeeper.setKeeper(user3);
		documentKeeper4 = documentKeeperRepository.save(documentKeeper);
	}

	@Test
	public void createSkill1() {
		Skill skill = new Skill();
		skill.setName("skill1");
		skill1 = skillRepository.save(skill);
	}

	@Test
	public void createSkill2() {
		Skill skill = new Skill();
		skill.setName("skill2");
		skill2 = skillRepository.save(skill);
	}

	@Test
	public void createDocumentSkill1() {
		DocumentSkill documentSkill = new DocumentSkill();
		documentSkill.setDocument(document1);
		documentSkill.setSkill(skill1);
		documentSkill1 = documentSkillRepository.save(documentSkill);
	}

	@Test
	public void createDocumentSkill2() {
		DocumentSkill documentSkill = new DocumentSkill();
		documentSkill.setDocument(document1);
		documentSkill.setSkill(skill2);
		documentSkill2 = documentSkillRepository.save(documentSkill);
	}
}
