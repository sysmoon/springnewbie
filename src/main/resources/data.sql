INSERT INTO article(title, content) VALUES ('WFA2.1', '11111');
INSERT INTO article(title, content) VALUES ('WFA2.2', '22222');
INSERT INTO article(title, content) VALUES ('WFA2.3', '33333');

-- -- article dummy data
INSERT INTO article(title, content) VALUES ('What is your favorite movie?', 'tell me. blabla');
INSERT INTO article(title, content) VALUES ('What is your favorite food?', 'tell me. blabla');
INSERT INTO article(title, content) VALUES ('What is your favorite hobby?', 'tell me. blabla');


-- comment-4
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'boris', 'matrix');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'joon', 'good will hunting');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'jay', 'surinam');

-- comment-5
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'daniel', 'sushi');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'jb', 'gimbap');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'ellen', 'wine');

-- comment-6
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'daniel', 'tennis');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'jb', 'soccer');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'ellen', 'table tennis');