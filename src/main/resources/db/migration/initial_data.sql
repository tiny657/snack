INSERT INTO user (user_id, name, level, point, document_count, comment_count, like_count, reg_date) VALUES ('userId1', 'name1', 1, 2, 3, 4, 5, CURRENT_TIMESTAMP());
INSERT INTO user (user_id, name, level, point, document_count, comment_count, like_count, reg_date) VALUES ('userId2', 'name2', 0, 1, 2, 1, 1, CURRENT_TIMESTAMP());
INSERT INTO document (user_id, title, content, saved_count, like_count, comment_count, post_date, modified_date) VALUES ('userId1', 'title1', 'content1', 1, 2, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() );
INSERT INTO document (user_id, title, content, saved_count, like_count, comment_count, post_date, modified_date) VALUES ('userId2', 'title2', 'content2', 1, 2, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() );
INSERT INTO comment (content, reg_date, document_id, user_id) VALUES ('comment1', CURRENT_TIMESTAMP(), 3, 'userId1');
