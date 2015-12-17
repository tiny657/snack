package com.snack.repository;

import com.snack.App;
import com.snack.domain.*;
import com.snack.service.*;
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
	UserService userService;

	@Autowired
	DocumentService documentService;

	@Autowired
	CommentService commentService;

	@Autowired
	DocumentKeeperService documentKeeperService;

	@Autowired
	DocumentViewerService documentViewerService;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	SkillOwnerRepository skillOwnerRepository;

	@Autowired
	SkillOwnerHistoryRepository skillOwnerHistoryRepository;

	@Autowired
	DocumentSkillService documentSkillService;

	@Autowired
	DocumentSkillHistoryRepository documentSkillHistoryRepository;

	User user1, user2, user3, user4;
	Document document1, document2;
	Comment comment1, comment2;
	DocumentKeeper documentKeeper1, documentKeeper2, documentKeeper3, documentKeeper4, documentKeeper5;
	DocumentViewer documentViewer1, documentViewer2;
	Notification notification1, notification2;
	Skill skill1, skill2;
	SkillOwner skillOwner1, skillOwner2;
	SkillOwnerHistory skillOwnerHistory1, skillOwnerHistory2;
	DocumentSkill documentSkill1, documentSkill2;
	DocumentSkillHistory documentSkillHistory1, documentSkillHistory2;

	@Test
	@Rollback(false)
	public void initialize() {
		documentSkillHistoryRepository.deleteAll();
		documentSkillService.deleteAll();
		skillOwnerHistoryRepository.deleteAll();
		skillOwnerRepository.deleteAll();
		documentKeeperService.deleteAll();
		commentService.deleteAll();
		documentService.deleteAll();
		skillRepository.deleteAll();
		notificationRepository.deleteAll();
		userService.deleteAll();

		createUser1();
		createUser2();
		createUser3();
		createUser4();
		createNotification1();
		createNotification2();
		createSkill1();
		createSkill2();
		createDocument1();
		createDocument2();
		createComment1();
		createComment2();
		createDocumentKeeper1();
		createDocumentKeeper2();
		createDocumentKeeper3();
		createDocumentKeeper4();
		createDocumentKeeper5();
		createDocumentViewer1();
		createDocumentViewer2();
		createSkillOwner1();
		createDocumentSkill1();
		createDocumentSkill2();
		createDocumentSkill3();
	}

	public void createUser1() {
		User user = new User();
		user.setUserId("userId1");
		user.setName("name1");
		user.setDescription("My name is name1");
		user1 = userService.create(user);
	}

	public void createUser2() {
		User user = new User();
		user.setUserId("userId2");
		user.setName("name2");
		user.setDescription("My name is name2");
		user2 = userService.create(user);
	}

	public void createUser3() {
		User user = new User();
		user.setUserId("userId3");
		user.setName("name3");
		user.setDescription("My name is name3");
		user3 = userService.create(user);
	}

	public void createUser4() {
		User user = new User();
		user.setUserId("userId4");
		user.setName("name4");
		user.setDescription("My name is name4");
		user4 = userService.create(user);
	}

	public void createNotification1() {
		Notification notification = new Notification();
		notification.setMessage("noti1");
		notification.setReceiver(user1);
		notification.setSee(false);
		notification1 = notificationRepository.save(notification);
	}

	public void createNotification2() {
		Notification notification = new Notification();
		notification.setMessage("noti2");
		notification.setReceiver(user1);
		notification.setSee(false);
		notification2 = notificationRepository.save(notification);
	}

	public void createDocument1() {
		Document document = new Document();
		document.setAuthor(user1);
		document.setContent("content1");
		document.setTitle("title1");
		document1 = documentService.create(document);
	}

	public void createDocument2() {
		Document document = new Document();
		document.setAuthor(user1);
		document.setContent("content2");
		document.setTitle("title2");
		document2 = documentService.create(document);
	}

	public void createComment1() {
		Comment comment = new Comment();
		comment.setContent("comment_content1");
		comment.setWriter(user1);
		comment.setDocument(document1);
		comment1 = commentService.create(comment);
	}

	public void createComment2() {
		Comment comment = new Comment();
		comment.setContent("comment_content2");
		comment.setWriter(user1);
		comment.setDocument(document1);
		comment2 = commentService.create(comment);
	}

	public void createDocumentKeeper1() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document1);
		documentKeeper.setKeeper(user1);
		documentKeeper1 = documentKeeperService.create(documentKeeper);
	}

	public void createDocumentKeeper2() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document1);
		documentKeeper.setKeeper(user2);
		documentKeeper2 = documentKeeperService.create(documentKeeper);
	}

	public void createDocumentKeeper3() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document1);
		documentKeeper.setKeeper(user3);
		documentKeeper3 = documentKeeperService.create(documentKeeper);
	}

	public void createDocumentKeeper4() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document2);
		documentKeeper.setKeeper(user1);
		documentKeeper4 = documentKeeperService.create(documentKeeper);
	}

	public void createDocumentKeeper5() {
		DocumentKeeper documentKeeper = new DocumentKeeper();
		documentKeeper.setDocument(document2);
		documentKeeper.setKeeper(user3);
		documentKeeper5 = documentKeeperService.create(documentKeeper);
	}

	public void createDocumentViewer1() {
		DocumentViewer documentViewer = new DocumentViewer();
		documentViewer.setDocument(document1);
		documentViewer.setViewer(user1);
		documentViewerService.create(documentViewer);
	}

	public void createDocumentViewer2() {
		DocumentViewer documentViewer = new DocumentViewer();
		documentViewer.setDocument(document2);
		documentViewer.setViewer(user1);
		documentViewerService.create(documentViewer);
	}

	public void createSkill1() {
		Skill skill = new Skill();
		skill.setName("skill1");
		skill1 = skillRepository.save(skill);
	}

	public void createSkill2() {
		Skill skill = new Skill();
		skill.setName("skill2");
		skill2 = skillRepository.save(skill);
	}

	public void createSkillOwner1() {
		SkillOwner skillOwner = new SkillOwner();
		skillOwner.setSkill(skill1);
		skillOwner.setOwner(user1);
		skillOwner.setPreRank(1);
		skillOwner.setRank(2);
		skillOwner1 = skillOwnerRepository.save(skillOwner);
	}

	public void createSkillOwner2() {
		SkillOwner skillOwner = new SkillOwner();
		skillOwner.setSkill(skill2);
		skillOwner.setOwner(user1);
		skillOwner.setPreRank(1);
		skillOwner.setRank(2);
		skillOwner2 = skillOwnerRepository.save(skillOwner);
	}

	public void createDocumentSkill1() {
		documentSkill1 = documentSkillService.create(document1, skill1);
	}

	public void createDocumentSkill2() {
		documentSkill1 = documentSkillService.create(document1, skill2);
	}

	public void createDocumentSkill3() {
		documentSkill1 = documentSkillService.create(document2, skill1);
	}
}
