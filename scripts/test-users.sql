USE `demeter`;



INSERT INTO user(username, password, first_name) VALUES ('pres', '{bcrypt}$2a$12$Mm04lcf6sps5kgE2HVe3puv/a1upuwdYSfmpouLlWQGDwHrS94JZO', 'Parker');
INSERT INTO user(username, password, first_name) VALUES ('srut', '{bcrypt}$2a$12$mplZRAfK1F121Y3CkHOCpOmqXxZonDT9Obo.srrTpIluuERVsCiBW', 'Sydney');

INSERT INTO roles(user_id, role, enabled) VALUES (4, 'user', 1);
INSERT INTO roles(user_id, role, enabled) VALUES ('pres', 'user', 1);
