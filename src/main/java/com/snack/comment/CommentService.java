package com.snack.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	public Comment findOne(Integer id) {
		return commentRepository.findOne(id);
	}

	@Transactional
	public Comment create(Comment comment) {
		comment.getDocument().increaseCommentCount();
		comment.getWriter().increaseMyCommentCount();
		return commentRepository.save(comment);
	}

	public Comment update(Comment comment) {
		return commentRepository.save(comment);
	}

	public void delete(Integer id) {
		commentRepository.delete(id);
	}

	public void deleteAll() {
		commentRepository.deleteAll();
	}
}
