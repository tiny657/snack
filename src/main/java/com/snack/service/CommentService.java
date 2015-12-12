package com.snack.service;

import com.snack.domain.Comment;
import com.snack.repository.CommentRepository;
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

	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment update(Comment comment) {
		return commentRepository.save(comment);
	}

	public void delete(Integer id) {
		commentRepository.delete(id);
	}
}
