package com.snack.repository;

import com.snack.App;
import com.snack.domain.Comment;
import com.snack.domain.Document;
import com.snack.domain.DocumentLiker;
import com.snack.domain.User;
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
	DocumentLikerRepository documentLikerRepository;

	User user1, user2, user3, user4;
	Document document1, document2;
	Comment comment1, comment2;
	DocumentLiker documentLiker1, documentLiker2, documentLiker3, documentLiker4;


	@Test
	@Rollback(false)
	public void _deleteAll() {
		userRepository.deleteAll();
		documentRepository.deleteAll();
		commentRepository.deleteAll();
		documentLikerRepository.deleteAll();
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
		createDocumentLiker1();
		createDocumentLiker2();
		createDocumentLiker3();
		createDocumentLiker4();
	}

	@Test
	public void createUser1() {
		User user = new User();
		user.setUserId("userId1");
		user.setName("name1");
		user.setCommentCount(1);
		user.setLevel(2);
		user.setLikeCount(3);
		user.setPoint(4);
		user1 = userRepository.save(user);
	}

	@Test
	public void createUser2() {
		User user = new User();
		user.setUserId("userId2");
		user.setName("name2");
		user.setCommentCount(1);
		user.setLevel(2);
		user.setLikeCount(3);
		user.setPoint(4);
		user2 = userRepository.save(user);
	}

	@Test
	public void createUser3() {
		User user = new User();
		user.setUserId("userId3");
		user.setName("name3");
		user.setCommentCount(1);
		user.setLevel(2);
		user.setLikeCount(3);
		user.setPoint(4);
		user3 = userRepository.save(user);
	}

	@Test
	public void createUser4() {
		User user = new User();
		user.setUserId("userId4");
		user.setName("name4");
		user.setCommentCount(1);
		user.setLevel(2);
		user.setLikeCount(3);
		user.setPoint(4);
		user4 = userRepository.save(user);
	}

	@Test
	public void createDocument1() {
		Document document = new Document();
		document.setCommentCount(1);
		document.setAuthor(user1);
		document.setContent("content1");
		document.setLikerCount(2);
		document.setTitle("title1");
		document1 = documentRepository.save(document);
	}

	@Test
	public void createDocument2() {
		Document document = new Document();
		document.setCommentCount(1);
		document.setAuthor(user1);
		document.setContent("content2");
		document.setLikerCount(2);
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
	public void createDocumentLiker1() {
		DocumentLiker documentLiker = new DocumentLiker();
		documentLiker.setDocument(document1);
		documentLiker.setLiker(user1);
		documentLiker1 = documentLikerRepository.save(documentLiker1);
	}

	@Test
	public void createDocumentLiker2() {
		DocumentLiker documentLiker = new DocumentLiker();
		documentLiker.setDocument(document1);
		documentLiker.setLiker(user2);
		documentLiker2 = documentLikerRepository.save(documentLiker2);
	}

	@Test
	public void createDocumentLiker3() {
		DocumentLiker documentLiker = new DocumentLiker();
		documentLiker.setDocument(document2);
		documentLiker.setLiker(user1);
		documentLiker3 = documentLikerRepository.save(documentLiker3);
	}

	@Test
	public void createDocumentLiker4() {
		DocumentLiker documentLiker = new DocumentLiker();
		documentLiker.setDocument(document2);
		documentLiker.setLiker(user3);
		documentLiker4 = documentLikerRepository.save(documentLiker4);
	}
}
