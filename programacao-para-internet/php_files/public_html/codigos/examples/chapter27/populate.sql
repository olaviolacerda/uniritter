use mail;

insert into users values 
('user', password('password'), 'email@host.domain', 'Full Name');

insert into accounts values 
('user', 'localhost', '110', 'POP3', 'user', 'password', ''),
('user', 'localhost', '143', 'IMAP', 'user', 'password', '');

