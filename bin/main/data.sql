-- data.sql

-- Article 데이터
INSERT INTO Article (id, title, content, created_at, password)
VALUES (1, '첫 번째 제목', '첫 번째 내용', '2023-01-01 10:00:00', 'password1');
INSERT INTO Article (id, title, content, created_at, password)
VALUES (2, '두 번째 제목', '두 번째 내용', '2023-02-02 11:11:11', 'password2');
INSERT INTO Article (id, title, content, created_at, password)
VALUES (3, '세 번째 제목', '세 번째 내용', '2023-03-03 12:12:12', 'password3');
INSERT INTO Article (id, title, content, created_at, password)
VALUES (4, '네 번째 제목', '네 번째 내용', '2023-04-04 13:13:13', 'password4');
INSERT INTO Article (id, title, content, created_at, password)
VALUES (5, '다섯 번째 제목', '다섯 번째 내용', '2023-05-05 14:14:14', 'password5');


-- ArticleComment 데이터
INSERT INTO article_comment (id, article_id, parent_comment_id, content, created_at)
VALUES (1, 1, NULL, '첫 번째 댓글', '2023-01-01 10:01:00');
INSERT INTO article_comment (id, article_id, parent_comment_id, content, created_at)
VALUES (2, 1, NULL, '두 번째 댓글', '2023-01-01 10:02:00');
INSERT INTO article_comment (id, article_id, parent_comment_id, content, created_at)
VALUES (3, 2, NULL, '세 번째 댓글', '2023-02-02 11:11:00');
INSERT INTO article_comment (id, article_id, parent_comment_id, content, created_at)
VALUES (4, 2, NULL, '네 번째 댓글', '2023-02-02 11:12:00');
INSERT INTO article_comment (id, article_id, parent_comment_id, content, created_at)
VALUES (5, 2, 1, '다섯 번째 댓글', '2023-02-02 11:13:00');
-- 나머지 ArticleComment 데이터도 동일한 형식으로 추가
